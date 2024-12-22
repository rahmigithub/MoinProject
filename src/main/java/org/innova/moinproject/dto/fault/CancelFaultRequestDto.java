package org.innova.moinproject.dto.fault;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CancelFaultRequestDto {
    private UUID faultUUID;
    private String cancelReason;
}
