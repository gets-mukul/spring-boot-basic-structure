package com.skeleton.skeleton.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import com.skeleton.skeleton.entities.Person;
import com.skeleton.skeleton.pojos.service.request.PersonServiceRequest;
import com.skeleton.skeleton.pojos.service.response.PersonServiceResponse;
import com.skeleton.skeleton.repositories.IPersonRepository;
import com.skeleton.skeleton.services.IPersonService;
import com.skeleton.skeleton.services.impl.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PersonServiceTest {

  private IPersonRepository personRepository;
  private IPersonService personService;

  @BeforeEach
  void setup() {
    personRepository = mock(IPersonRepository.class);
    personService = new PersonService(personRepository);
  }

  @Test
  @DisplayName("Happy flow for createNewPerson")
  void createNewPersonHappyFlow() {
    final PersonServiceRequest request = PersonServiceRequest.builder()
        .firstName("mocker name").lastName("mocker last name").email("mocked email")
        .phone("3232323232").alternatePhone("9898989898").address("mocked_address").build();
    Mockito.when(personRepository.save(Mockito.any(Person.class)))
        .thenAnswer(i -> i.getArguments()[0]);

    final PersonServiceResponse response = personService.createNewPerson(
        request);
    assertEquals("mocker name", response.getFirstName());
    assertEquals("mocker last name", response.getLastName());
    assertEquals("3232323232", response.getPhone());
  }
}
