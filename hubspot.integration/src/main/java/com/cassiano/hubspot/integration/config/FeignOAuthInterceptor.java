package com.cassiano.hubspot.integration.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class FeignOAuthInterceptor implements RequestInterceptor {

    // Aqui você pode injetar seu token dinamicamente via service ou usar um valor fixo pra testes
    private final String accessToken = "pat-na1-72af4aab-1c37-4514-a59c-20095d009070";

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", "Bearer " + accessToken);
    }
}
