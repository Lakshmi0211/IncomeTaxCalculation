package com.poc.incometax.incomeTaxCalcuController;

import com.poc.incometax.incomeTaxCalcuService.IncomeTaxCalService;
import com.poc.incometax.model.EmpCessDeductionResponse;
import com.poc.incometax.model.EmpTaxDeductionResponse;
import com.poc.incometax.model.EmployeeDetailsRequest;
import com.poc.incometax.model.EmployeeDetailsResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/v1/emp/")
public class IncomeTaxCalController {

    @Autowired
    private IncomeTaxCalService incomeTaxCalService;

    @PostMapping("/details/create")
    public ResponseEntity<EmployeeDetailsResponse> createEmpDetails(
             @RequestBody @Valid EmployeeDetailsRequest employeeDetails) {
        return ResponseEntity.ok(incomeTaxCalService.saveEmpDetails(employeeDetails));
    }

    @GetMapping("/deduction")
    public ResponseEntity<EmpTaxDeductionResponse> empTaxDeduction(@RequestParam Integer empId) {
        return ResponseEntity.ok(incomeTaxCalService.getEmpTaxDeduction(empId));
    }

    @GetMapping("/cess")
    public ResponseEntity<EmpCessDeductionResponse> empCessDeduction(@RequestParam Integer empId) {
        return ResponseEntity.ok(incomeTaxCalService.getEmpCessDeduction(empId));
    }
}
