package org.innova.moinproject.dto.fault;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateFaultRequestDto {
    private int customerNumber;
    private String faultType;
    private String faultDescription;
}