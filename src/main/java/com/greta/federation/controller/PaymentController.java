package com.greta.federation.controller;
import com.greta.federation.dto.PaymentRequest;
import com.greta.federation.dto.PaymentStatus;
import com.greta.federation.utils.Constants;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class PaymentController {

    @PostMapping(value = Constants.APP_ROOT +"/charge")
    public ResponseEntity<String> charge(@RequestBody PaymentRequest paymentRequest) {
        try {
            Charge charge = createCharge(paymentRequest.getAmount(), paymentRequest.getCurrency(), paymentRequest.getToken());
            // Traitez la charge réussie ici
            return ResponseEntity.ok("Paiement réussi !");
        } catch (StripeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur de paiement : " + e.getMessage());
        }
    }

    private Charge createCharge(long amount, String currency, String token) throws StripeException {
        Charge charge;
        PaymentStatus paymentStatus;
        ChargeCreateParams params = ChargeCreateParams.builder()
                .setAmount(amount)
                .setDescription("achat client ")
                .setCurrency(currency)
                .setSource(token)
                .build();
        charge = Charge.create(params);
        System.out.println("Charge = " + charge);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        paymentStatus = new PaymentStatus(timestamp.getTime(), false,
                charge.getId(),
                charge.getBalanceTransaction(),
                charge.getReceiptUrl()
        );

        return Charge.create(params);
    }
}
