//package com.caremanager.springsecurityoracledb.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//
//    @Autowired
//    private DatasourceConfig datasource;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) {
//        resources.tokenServices(tokenServices());
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.requestMatchers()
//                .antMatchers("/login", "/oauth/authorize")
//                .and()
//                .authorizeRequests()
//                .anyRequest().
//                .authenticated()
//                .and()
//                .formLogin()
//                .permitAll();
//    }
//
//    @Bean
//    @Primary
//    public DefaultTokenServices tokenServices() {
//        final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
//        defaultTokenServices.setTokenStore(datasource.tokenStore());
//        return defaultTokenServices;
//    }
//
//
//}
