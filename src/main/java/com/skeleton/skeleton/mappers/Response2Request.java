package com.skeleton.skeleton.mappers;

import com.skeleton.skeleton.pojos.controller.response.PersonControllerResponse;
import com.skeleton.skeleton.pojos.service.response.PersonServiceResponse;

public class Response2Request {

  public static PersonControllerResponse personServiceToController(
      final PersonServiceResponse serviceResponse) {
    return PersonControllerResponse.builder().id(serviceResponse.getId()).build();
  }

}
