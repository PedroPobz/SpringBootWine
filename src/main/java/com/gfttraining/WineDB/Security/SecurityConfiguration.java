package com.gfttraining.WineDB.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	// Creamos los usuarios desde aquí
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
       auth.inMemoryAuthentication()
       	   .withUser("admin").password(passwordEncoder().encode("123")).roles("ADMIN")
       	   .and()
       	   .withUser("user").password(passwordEncoder().encode("123")).roles("USER");
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception
    {
   
		http.authorizeHttpRequests()
			.antMatchers(HttpMethod.POST,"/api/**").hasAnyRole("ADMIN","USER")
			.antMatchers(HttpMethod.DELETE,"/api/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.PUT,"/api/**").hasRole("ADMIN")
			.and()
			.csrf()
			.disable()
			.httpBasic();
    }
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
}