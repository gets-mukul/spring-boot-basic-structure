package com.skeleton.skeleton.services.impl;

import static com.skeleton.skeleton.mappers.Request2Request.personServiceToEntity;
import static com.skeleton.skeleton.mappers.Response2Response.personEntityToService;

import com.skeleton.skeleton.entities.Person;
import com.skeleton.skeleton.pojos.service.request.PersonServiceRequest;
import com.skeleton.skeleton.pojos.service.response.PersonServiceResponse;
import com.skeleton.skeleton.repositories.IPersonRepository;
import com.skeleton.skeleton.services.IPersonService;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@Builder
public class PersonService implements IPersonService {

  private final IPersonRepository personRepository;

  @Override
  public PersonServiceResponse createNewPerson(
      @NonNull final PersonServiceRequest personRequest) {
    final Person personEntity = personServiceToEntity(personRequest);
    final Person newPerson = personRepository.save(personEntity);
    log.info("createNewPerson :: id: [ {} ]", newPerson.getId());
    return personEntityToService(newPerson);
  }

}
