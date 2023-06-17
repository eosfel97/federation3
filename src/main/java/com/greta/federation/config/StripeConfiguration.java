package com.greta.federation.config;
import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfiguration {

    @Value("${stripe.secretKey}")
    private String stripeKey;

    @Bean
    public void initStripe() {
        Stripe.apiKey = stripeKey;
    }
}
