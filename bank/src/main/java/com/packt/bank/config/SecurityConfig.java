package com.packt.bank.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select USERNAME, PASSWORD, ENABLED from UTENTE where USERNAME=?")
				.authoritiesByUsernameQuery("select USERNAME_RUOLO, RUOLO from RUOLI where USERNAME_RUOLO=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password");

		http.formLogin().defaultSuccessUrl("/welcome", true).failureUrl("/login?error");

		http.logout().logoutSuccessUrl("/login?logout");

		http.exceptionHandling().accessDeniedPage("/403");

		http.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/aggiungi-utente").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/welcome").access("hasRole('ROLE_USER')")
		.antMatchers("/le-tue-carte").access("hasRole('ROLE_USER')")
		.antMatchers("/le-tue-operazioni").access("hasRole('ROLE_USER')");
		
		http.csrf().disable();
	}

}
