package com.skeleton.skeleton.pojos.service.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonServiceResponse {

  private String id;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String alternatePhone;
  private String address;
}
