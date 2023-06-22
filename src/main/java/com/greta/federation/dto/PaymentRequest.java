package com.greta.federation.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PaymentRequest {

    private int amount;
    private String currency;
    private String token;
}