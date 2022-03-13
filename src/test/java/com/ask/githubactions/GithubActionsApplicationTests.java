package com.ask.githubactions;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GithubActionsApplicationTests {

  @EnabledIfEnvironmentVariable(named = "BUILD_SUCCESS", matches = "false")
  @Test
  void enabledFailTest() {
    fail("BUILD_SUCCESS 환경변수 값이 false 이므로 실패처리");
  }

}
