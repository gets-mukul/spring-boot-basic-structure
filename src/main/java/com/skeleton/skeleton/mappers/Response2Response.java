package com.skeleton.skeleton.mappers;

import com.skeleton.skeleton.entities.Person;
import com.skeleton.skeleton.pojos.service.response.PersonServiceResponse;

public class Response2Response {

  public static PersonServiceResponse personEntityToService(
      final Person personEntity) {
    return PersonServiceResponse.builder()
        .id(personEntity.getId())
        .firstName(personEntity.getFirstName())
        .lastName(personEntity.getLastName())
        .email(personEntity.getEmail())
        .phone(personEntity.getPhone())
        .alternatePhone(personEntity.getAlternatePhone())
        .address(personEntity.getAddress())
        .build();
  }

}
