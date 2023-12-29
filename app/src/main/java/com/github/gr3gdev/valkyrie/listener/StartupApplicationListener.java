package com.github.gr3gdev.valkyrie.listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.stereotype.Component;

import com.github.gr3gdev.valkyrie.dao.bean.User;
import com.github.gr3gdev.valkyrie.dao.repository.UserRepository;

@Component
public class StartupApplicationListener implements ApplicationListener<ApplicationStartedEvent> {

    @Value("${single.page.application.url:/}")
    String externalUrl;

    private final RegisteredClientRepository registeredClientRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public StartupApplicationListener(RegisteredClientRepository registeredClientRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.registeredClientRepository = registeredClientRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        final User user = new User();
        user.setUsername("thor");
        user.setPassword(passwordEncoder.encode("password"));
        userRepository.save(user);

        final RegisteredClient publicClient = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId("valkyrie")
                .clientSecret(passwordEncoder.encode("secret"))
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_POST)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .redirectUri(externalUrl + "/")
                .postLogoutRedirectUri(externalUrl + "/login")
                .scope(OidcScopes.OPENID)
                .scope(OidcScopes.PROFILE)
                .clientSettings(ClientSettings.builder()
                        .requireAuthorizationConsent(true)
                        .requireProofKey(true)
                        .build())
                .build();
        registeredClientRepository.save(publicClient);
    }

}
