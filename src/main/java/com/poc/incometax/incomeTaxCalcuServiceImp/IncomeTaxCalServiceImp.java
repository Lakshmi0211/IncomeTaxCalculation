package com.poc.incometax.incomeTaxCalcuServiceImp;

import com.poc.incometax.incomeTaxCalcuRepository.IncomeTaxCalRepository;
import com.poc.incometax.incomeTaxCalcuService.IncomeTaxCalService;
import com.poc.incometax.model.EmpCessDeductionResponse;
import com.poc.incometax.model.EmpTaxDeductionResponse;
import com.poc.incometax.model.EmployeeDetailsRequest;
import com.poc.incometax.model.EmployeeDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.HashMap;


@Service
public class IncomeTaxCalServiceImp implements IncomeTaxCalService {

    @Autowired(required = false)
    private IncomeTaxCalRepository incomeTaxCalRepository;

    //TODO: As of now, we do not add support for data base operation so, I have been using Map collection.
    HashMap<Integer, EmployeeDetailsRequest> employeeDetailsMap = new HashMap<>();

    /**
     * @param employeeDetails
     * @return String value
     */
    @Override
    public EmployeeDetailsResponse saveEmpDetails(EmployeeDetailsRequest employeeDetails) {
        employeeDetailsMap.put(employeeDetails.getEmployeeID(), employeeDetails);
        return new EmployeeDetailsResponse().setStatusCode(HttpStatus.OK.value()).setMessage(
                "Save EmployeeDetails successfully, The EmployeeID is: " + employeeDetails.getEmployeeID());
    }

    /**
     * @param empId
     * @return
     */
    @Override
    public EmpTaxDeductionResponse getEmpTaxDeduction(Integer empId) {
        Double taxDeduction = 0.0;
        EmployeeDetailsRequest employeeDetails = employeeDetailsMap.get(empId);
        Double empSalary = employeeDetails.getEmpSalary();
        if (empSalary <= 250000) {
            taxDeduction = 0.0;
        } else if (empSalary <= 500000) {
            taxDeduction = 0.05 * (empSalary - 250000);
        } else if (empSalary <= 1000000) {
            taxDeduction = (0.1 * (empSalary - 500000) + 0.05 * (empSalary - 250000));
        } else {
            taxDeduction = (0.2 * (empSalary - 1000000) + 0.1 * (empSalary - 500000) + 0.05 * (empSalary - 250000));
        }
        return new EmpTaxDeductionResponse().setTaxDeduction(taxDeduction);
    }

    /**
     * @param empId
     * @return
     */
    @Override
    public EmpCessDeductionResponse getEmpCessDeduction(Integer empId) {
        EmpCessDeductionResponse empCessDeduction = new EmpCessDeductionResponse();
        EmployeeDetailsRequest employeeDetails = employeeDetailsMap.get(empId);
        Double empSalary = employeeDetails.getEmpSalary();
        if (empSalary >= 2500000) {
            empCessDeduction.setEmpCess(0.2 * (empSalary));
        } else {
            empCessDeduction.setEmpCess(0.0);
        }
        empCessDeduction.setEmployeeID(employeeDetails.getEmployeeID());
        empCessDeduction.setFirstName(employeeDetails.getFirstName());
        empCessDeduction.setLastName(employeeDetails.getLastName());
        empCessDeduction.setPhoneNumList(employeeDetails.getPhoneNumList());
        empCessDeduction.setEmpSalary(employeeDetails.getEmpSalary());
        empCessDeduction.setDateOfJoin(employeeDetails.getDateOfJoin());
        return empCessDeduction;
    }
}
