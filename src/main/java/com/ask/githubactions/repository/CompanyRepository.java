package com.ask.githubactions.repository;

import com.ask.githubactions.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {

}
