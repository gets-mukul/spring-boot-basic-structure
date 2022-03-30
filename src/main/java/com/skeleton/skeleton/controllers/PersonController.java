package com.skeleton.skeleton.controllers;

import static com.skeleton.skeleton.constants.api.EndPoints.PERSON_URL;
import static com.skeleton.skeleton.mappers.Request2Request.personControllerToService;
import static com.skeleton.skeleton.mappers.Response2Request.personServiceToController;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

import com.skeleton.skeleton.entities.APIResponse;
import com.skeleton.skeleton.pojos.controller.requests.PersonControllerRequest;
import com.skeleton.skeleton.pojos.controller.response.PersonControllerResponse;
import com.skeleton.skeleton.pojos.service.request.PersonServiceRequest;
import com.skeleton.skeleton.pojos.service.response.PersonServiceResponse;
import com.skeleton.skeleton.services.impl.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PERSON_URL)
@RequiredArgsConstructor
@Slf4j
public class PersonController {

  private final PersonService personService;

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<APIResponse> createPerson(
      @RequestBody final PersonControllerRequest personRequest) {

    try {
      final PersonServiceRequest serviceRequest = personControllerToService(personRequest);

      final PersonServiceResponse serviceResponse = personService.createNewPerson(serviceRequest);

      final PersonControllerResponse personResponse = personServiceToController(serviceResponse);

      log.info("createPerson :: id: [ {} ]", personResponse.getId());
      return ResponseEntity.status(OK).body(APIResponse.builder().message(
              String.format("New Person Created Successfully id: %s", personResponse.getId()))
          .error(null).details(personResponse)
          .build());
    } catch (final Exception e) {
      log.error("Error while creating new person: {}", e.getMessage());
      return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(APIResponse.builder().message(
          "Error while creating person").error(e.getMessage()).build());
    }
  }

}