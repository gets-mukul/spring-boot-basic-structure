package com.skeleton.skeleton.utils;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

public class BaseIntegrationTest {

  protected static final MySQLContainer mySQLContainer;

  static {
    mySQLContainer = (MySQLContainer) (new MySQLContainer("mysql:8.0.27")
        .withUsername("root")
        .withPassword("Mysql@1997")
        .withDatabaseName("skeleton")
        .withReuse(true));
    mySQLContainer.start();
  }

  @DynamicPropertySource
  public static void setDatasourceProperties(final DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
    registry.add("spring.datasource.password", mySQLContainer::getPassword);
    registry.add("spring.datasource.username", mySQLContainer::getUsername);
  }
}
