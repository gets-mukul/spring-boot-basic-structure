package com.skeleton.skeleton.pojos.service.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonServiceRequest {

  @NonNull
  private String firstName;
  @NonNull
  private String lastName;
  @NonNull
  private String email;
  @NonNull
  private String phone;
  private String alternatePhone;
  @NonNull
  private String address;
}
