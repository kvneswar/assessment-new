package com.assessment.services.repositories;/**
 * Created by Anand Tadepalli on 9/16/2017.
 */

import com.assessment.services.domain.QuestionBank;
import com.assessment.services.domain.QuestionPaper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionPaperRepository extends CrudRepository<QuestionPaper, Long>{

}
