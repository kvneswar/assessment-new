package com.assessment.services.repositories;/**
 * Created by Anand Tadepalli on 9/16/2017.
 */

import com.assessment.services.domain.Test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long>{

}
