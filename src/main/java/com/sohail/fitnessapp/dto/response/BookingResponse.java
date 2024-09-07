package com.sohail.fitnessapp.dto.response;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class BookingResponse {

    @NotNull
    private Long BookingId;

    @NotNull
    private String message;
}
