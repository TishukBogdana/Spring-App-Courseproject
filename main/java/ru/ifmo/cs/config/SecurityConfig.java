package ru.ifmo.cs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


import javax.servlet.Filter;

/**
 * Created by Богдана on 06.12.2017.
 */
@Configuration
@EnableOAuth2Sso
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
/* @Bean
    @ConfigurationProperties("security.oauth2.client")
    public AuthorizationCodeResourceDetails facebook() {
        return new AuthorizationCodeResourceDetails();
    }

    @Bean
    @ConfigurationProperties("security.oauth2.resource")
    @Primary
    public ResourceServerProperties facebookResource() {
        return new ResourceServerProperties();
    }

    @Qualifier("oauth2ClientContext")
    @Autowired
   private OAuth2ClientContext oauth2ClientContext;

    private Filter ssoFilter() {
        OAuth2ClientAuthenticationProcessingFilter vkFilter = new OAuth2ClientAuthenticationProcessingFilter("/mainpage.html");
        OAuth2RestTemplate facebookTemplate = new OAuth2RestTemplate(facebook(), oauth2ClientContext);
       vkFilter.setRestTemplate(facebookTemplate);
        UserInfoTokenServices tokenServices = new UserInfoTokenServices(facebookResource().getUserInfoUri(), facebook().getClientId());
        tokenServices.setRestTemplate(facebookTemplate);
     vkFilter.setTokenServices(tokenServices);

        return vkFilter;
    }*/

    @Override
    public void configure(HttpSecurity http) throws Exception {

 // http.addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);
   http.csrf().disable().authorizeRequests().antMatchers("*.html").permitAll().and()
         .authorizeRequests().antMatchers("/articles/*").permitAll().and()
           .authorizeRequests().antMatchers("/artcom/*").permitAll().and()
               .authorizeRequests().antMatchers("/auth/**")
           .authenticated();

   /*.authorizeRequests().antMatchers("/login**").permitAll()
   .antMatchers("/login*").permitAll()
           .antMatchers("/login").permitAll();*/
    }

}
