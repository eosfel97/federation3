package com.greta.federation.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CardToken {
    String id;
    Long amount;
    String currency;

}