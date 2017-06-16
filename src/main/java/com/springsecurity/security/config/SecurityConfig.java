package com.springsecurity.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static String REALM = "TEST_REALM";
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder manager) throws Exception {
		manager.inMemoryAuthentication()
				.withUser("bill").password("gates").roles("ADMIN")
				.and()
				.withUser("john").password("smith").roles("USER");
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.POST).hasRole("ADMIN")
			.antMatchers("/geolocation")
			.fullyAuthenticated()
			.and().httpBasic().realmName(REALM).authenticationEntryPoint(getCustomAuthenticationEntryPoint())
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	private AuthenticationEntryPoint getCustomAuthenticationEntryPoint() {
		
		return new CustomAuthenticationEntryPoint();
	}
	
	/* To allow Pre-flight [OPTIONS] request from browser */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
	
	
}
