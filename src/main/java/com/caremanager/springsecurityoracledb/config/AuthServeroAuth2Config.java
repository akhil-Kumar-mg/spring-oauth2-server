package com.caremanager.springsecurityoracledb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthServeroAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private DatasourceConfig datasource;

//    @Autowired
//    private UserApprovalHandler userApprovalHandler;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder oauthClientPasswordEncoder;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.passwordEncoder(oauthClientPasswordEncoder);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception {
        clients.jdbc(datasource.dataSource());
//                .passwordEncoder(oauthClientPasswordEncoder);
//
//        clients.inMemory()
//                .withClient("trusted-client-II")
//                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//                .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//                .scopes("read", "write", "trust")
//                .secret("password")
//                .accessTokenValiditySeconds(120).//Access token is only valid for 2 minutes.
//                refreshTokenValiditySeconds(600);//Refresh token is only valid for 10 minutes.

    }

    @Override
    public void configure(
            AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception {

        endpoints
                .tokenStore(datasource.tokenStore()).approvalStoreDisabled()
                .authenticationManager(authenticationManager);
    }

}
