package com.skeleton.skeleton.pojos.controller.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonControllerRequest {

  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String alternatePhone;
  private String address;
}
