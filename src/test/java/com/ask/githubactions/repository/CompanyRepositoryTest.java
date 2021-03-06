package com.ask.githubactions.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.ask.githubactions.entity.Company;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@Slf4j
class CompanyRepositoryTest {

  @Autowired
  private CompanyRepository companyRepository;

  @DisplayName("Company 생성")
  @Test
  void save() {
    // given
    Company company = Company.create("names...", "address...");

    // when
    Company savedCompany = companyRepository.save(company);

    // then
    log.info("company : {}", company);
    assertThat(savedCompany.getId()).isNotEmpty();
    assertThat(savedCompany).isEqualTo(company);
  }

}
