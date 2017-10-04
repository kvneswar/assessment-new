package com.assessment.services.repositories;/**
 * Created by Anand Tadepalli on 9/16/2017.
 */

import com.assessment.services.domain.QuestionBank;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionBankRepository extends JpaRepository<QuestionBank, Long>{
	
	Page<QuestionBank> findAllBySchoolCode(String schoolCode, Pageable pageable);
	
	Page<QuestionBank> findAllBySchoolCodeAndIdIn(String schoolCode, List<Long> ids, Pageable pageable);

}
