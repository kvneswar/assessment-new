package com.assessment.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.services.domain.TestResults;

@Repository
public interface TestResultsRepository extends JpaRepository<TestResults, Long>{

}
