package com.ijse.gdse.railway_management.railway_management_system.Model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class paymentModel {
    private String p_id;
    private Double amount;
    private String booking_id    ;
    private String date;
    private String method;
}
