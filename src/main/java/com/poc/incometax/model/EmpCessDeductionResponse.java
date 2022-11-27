package com.poc.incometax.model;

import lombok.*;

import java.util.Arrays;
import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
public class EmpCessDeductionResponse {
    private Integer employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private List<Integer> phoneNumList = Arrays.asList();
    private String dateOfJoin;
    private Double empSalary;
    private Double empCess;
}
