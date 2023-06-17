package com.greta.federation.controller;


import com.greta.federation.dto.CardToken;
import com.greta.federation.dto.PaymentStatus;
import com.greta.federation.utils.Constants;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PaymentController {

    @Autowired
    private Environment env;
    @Value("${stripe.secretKey}")
    private String stripeKey;

   /* @GetMapping(value = Constants.APP_ROOT + "/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("success");
    }
*/
    @PostMapping(value = Constants.APP_ROOT + "/payment")
    public ResponseEntity<PaymentStatus> chargeCustomer(@RequestBody CardToken cardToken) {

        Stripe.apiKey = stripeKey;
        Stripe.setMaxNetworkRetries(2);

        Charge charge;
        PaymentStatus paymentStatus;

        try {
            ChargeCreateParams params =
                    ChargeCreateParams.builder()
                            .setAmount(cardToken.getAmount())
                            .setCurrency(cardToken.getCurrency())
                            .setDescription("Shopper Buy")
                            .setSource(cardToken.getId())
                            .build();

            charge = Charge.create(params);
            System.out.println("Charge = " + charge);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            paymentStatus = new PaymentStatus(timestamp.getTime(), false,
                    charge.getId(),
                    charge.getBalanceTransaction(),
                    charge.getReceiptUrl()
            );

        } catch (StripeException e) {
            paymentStatus = new PaymentStatus();
            paymentStatus.setPayment_failed(true);
            System.out.println("Something went wrong with Stripe API: " + e.getMessage());
            return ResponseEntity.badRequest().body(paymentStatus);
        } catch (Exception e) {
            paymentStatus = new PaymentStatus();
            paymentStatus.setPayment_failed(true);
            System.out.println("An unexpected error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(paymentStatus);
        }

        System.out.println("Payment is successful....");
        return ResponseEntity.ok(paymentStatus);
    }
}