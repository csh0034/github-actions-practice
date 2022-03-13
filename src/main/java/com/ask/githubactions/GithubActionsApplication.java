package com.ask.githubactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GithubActionsApplication {

  public static void main(String[] args) {
    SpringApplication.run(GithubActionsApplication.class, args);
  }

}
