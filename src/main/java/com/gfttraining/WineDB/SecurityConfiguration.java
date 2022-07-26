package com.gfttraining.WineDB;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	// Creamos los usuarios desde aquí
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
       auth.inMemoryAuthentication()
       	   .withUser("admin").password("123").roles("ADMIN")
       	   .and()
       	   .withUser("user").password("123").roles("USER");
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception
    {
       http.authorizeRequests()
       	   .anyRequest().authenticated()
       	   .and()
       	   .httpBasic();
    }
	
	
	
}
