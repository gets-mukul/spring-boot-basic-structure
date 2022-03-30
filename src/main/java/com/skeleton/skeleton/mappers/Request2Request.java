package com.skeleton.skeleton.mappers;

import com.skeleton.skeleton.entities.Person;
import com.skeleton.skeleton.pojos.controller.requests.PersonControllerRequest;
import com.skeleton.skeleton.pojos.service.request.PersonServiceRequest;

public class Request2Request {

  public static PersonServiceRequest personControllerToService(
      final PersonControllerRequest personRequest) {
    return PersonServiceRequest.builder()
        .firstName(personRequest.getFirstName())
        .lastName(personRequest.getLastName())
        .email(personRequest.getEmail())
        .phone(personRequest.getPhone())
        .alternatePhone(personRequest.getAlternatePhone())
        .address(personRequest.getAddress())
        .build();
  }

  public static Person personServiceToEntity(
      final PersonServiceRequest serviceRequest) {
    return Person.builder()
        .firstName(serviceRequest.getFirstName())
        .lastName(serviceRequest.getLastName())
        .email(serviceRequest.getEmail())
        .phone(serviceRequest.getPhone())
        .alternatePhone(serviceRequest.getAlternatePhone())
        .address(serviceRequest.getAddress())
        .build();
  }

}
