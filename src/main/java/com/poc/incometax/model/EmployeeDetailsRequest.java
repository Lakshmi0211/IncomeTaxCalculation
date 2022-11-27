package com.poc.incometax.model;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.lang.NonNull;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
public class EmployeeDetailsRequest {
    @NonNull
    private Integer employeeID;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    @Email
    private String email;
    @NonNull
    private List<Integer> phoneNumList = Arrays.asList();
    @NonNull
    private String dateOfJoin;
    @NonNull
    private Double empSalary;
}

