package com.pblgllgs.client.auth;
/*
 *
 * @author pblgl
 * Created on 29-01-2024
 *
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return
                security
                        .authorizeHttpRequests(auth -> auth
                                .requestMatchers(HttpMethod.GET, "/authorized").permitAll()
                                .requestMatchers(HttpMethod.GET, "/read").hasAnyAuthority("SCOPE_read", "SCOPE_write")
                                .requestMatchers(HttpMethod.POST, "/write").hasAuthority("SCOPE_write")
                                .anyRequest().authenticated()
                        )
                        .csrf(AbstractHttpConfigurer::disable)
                        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .oauth2Login(login -> login.loginPage("/oauth2/authorization/oidc-client"))
                        .oauth2Client(withDefaults())
                        .oauth2ResourceServer(resourceserver -> resourceserver.jwt(withDefaults()))
                        .build();
    }
}
