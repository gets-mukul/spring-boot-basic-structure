package com.skeleton.skeleton.integration;

import static com.skeleton.skeleton.constants.api.EndPoints.PERSON_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skeleton.skeleton.pojos.controller.requests.PersonControllerRequest;
import com.skeleton.skeleton.repositories.IPersonRepository;
import com.skeleton.skeleton.services.impl.PersonService;
import com.skeleton.skeleton.utils.BaseIntegrationTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;

@AutoConfigureMockMvc
@ActiveProfiles("local")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Testcontainers
class PersonControllerTest extends BaseIntegrationTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private PersonService personService;
  @Autowired
  private IPersonRepository personRepository;

  @Test
  @DisplayName("Integration test for happy flow of create new person")
  void createPersonHappyFlowTest() throws Exception {
    final PersonControllerRequest request = PersonControllerRequest.builder()
        .firstName("mocker name").lastName("mocker last name").email("mocked email")
        .phone("3232323232").alternatePhone("9898989898").address("mocked_address").build();
    String response = mockMvc.perform(
            post(PERSON_URL).contentType(APPLICATION_JSON).content(
                asJsonString(request)))
        .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
    JSONObject jsonObject = new JSONObject(response);
    JSONObject details = (JSONObject) jsonObject.get("details");
    String id = (String) details.get("id");
    validateNewData(id, request);
  }

  private void validateNewData(final String id,
      final PersonControllerRequest request) {
    final String DB_URL = mySQLContainer.getJdbcUrl();
    final String USER = mySQLContainer.getUsername();
    final String PASS = mySQLContainer.getPassword();
    final String query = String.format("SELECT * FROM person p WHERE id = '%s'",
        id);

    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement()) {
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        assertEquals(rs.getString("first_name"), request.getFirstName());
        assertEquals(rs.getString("last_name"), request.getLastName());
        assertEquals(rs.getString("phone"), request.getPhone());
        assertEquals(rs.getString("address"), request.getAddress());
      }
      stmt.close();
    } catch (final Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
