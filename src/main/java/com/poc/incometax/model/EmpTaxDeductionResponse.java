package com.poc.incometax.model;

public class EmpTaxDeductionResponse {
    private Double taxDeduction;

    public Double getTaxDeduction() {
        return taxDeduction;
    }

    public EmpTaxDeductionResponse setTaxDeduction(Double taxDeduction) {
        this.taxDeduction = taxDeduction;
        return this;
    }
}
