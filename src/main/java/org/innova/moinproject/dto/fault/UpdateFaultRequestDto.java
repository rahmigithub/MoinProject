package org.innova.moinproject.dto.fault;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateFaultRequestDto {
    private UUID faultUUID;
    private String faultType;
    private String faultDescription;
}
