package com.assessment.services.repositories;/**
 * Created by Anand Tadepalli on 9/16/2017.
 */

import com.assessment.services.domain.Test;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long>{

	Page<Test> findAllBySchoolCode(String schoolCode, Pageable pageable);
	
	Page<Test> findAllBySchoolCodeAndIdIn(String schoolCode, List<Long> ids, Pageable pageable);
	
}
