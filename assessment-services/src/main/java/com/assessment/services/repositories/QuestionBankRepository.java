package com.assessment.services.repositories;/**
 * Created by Anand Tadepalli on 9/16/2017.
 */

import com.assessment.services.domain.QuestionBank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public interface QuestionBankRepository extends CrudRepository<QuestionBank, Long>{

}
