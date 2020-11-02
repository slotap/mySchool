package com.slotap.myschool.security;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@EnableGlobalMethodSecurity(jsr250Enabled = true, securedEnabled = true, prePostEnabled = true)
@KeycloakConfiguration
class SecurityConfiguration extends KeycloakWebSecurityConfigurerAdapter {
    @Bean
   KeycloakSpringBootConfigResolver keycloakConfigResolver(){
        return new KeycloakSpringBootConfigResolver();
    }

    @Autowired
    void configureGlobal(AuthenticationManagerBuilder auth){
        var authorityManager = new SimpleAuthorityMapper();
        authorityManager.setPrefix("ROLE_");
        authorityManager.setConvertToUpperCase(true);
        KeycloakAuthenticationProvider keycloakProvider = keycloakAuthenticationProvider();
        keycloakProvider.setGrantedAuthoritiesMapper(authorityManager);
        auth.authenticationProvider(keycloakProvider);
    }

   @Override
    protected void configure(final HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests()
              //  .antMatchers("/v1/getTest/*")
              //  .hasAnyRole("ADMIN","PARENT","TEACHER")
                .anyRequest()
                .permitAll();
    }

    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }
}
