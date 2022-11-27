package com.poc.incometax.incomeTaxCalcuRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeTaxCalRepository<EmployeeDetails> extends CrudRepository<EmployeeDetails, Integer> {

    //TODO: We should added required method for performing Data base Operation.
}