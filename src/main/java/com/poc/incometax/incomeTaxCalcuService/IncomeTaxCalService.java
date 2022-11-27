package com.poc.incometax.incomeTaxCalcuService;

import com.poc.incometax.model.EmpCessDeductionResponse;
import com.poc.incometax.model.EmpTaxDeductionResponse;
import com.poc.incometax.model.EmployeeDetailsRequest;
import com.poc.incometax.model.EmployeeDetailsResponse;


public interface IncomeTaxCalService {
    public EmployeeDetailsResponse saveEmpDetails(EmployeeDetailsRequest employeeDetails);
    public EmpTaxDeductionResponse getEmpTaxDeduction(Integer empId);

    public EmpCessDeductionResponse getEmpCessDeduction(Integer empId);
}
