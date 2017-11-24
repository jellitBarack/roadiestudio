package com.hornung.roadiestudio.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private Environment env;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		auth.jdbcAuthentication()
			.dataSource(dataSource)
				.usersByUsernameQuery(env.getProperty("usersByUsernameQuery"))
				.authoritiesByUsernameQuery(env.getProperty("authoritiesByUsernameQuery"));
	}
		
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers("/layout/**", "/static/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().cacheControl().disable();
		http.authorizeRequests()				
				.antMatchers("/**").hasAnyAuthority("adm", "sup", "usr")
				.anyRequest().permitAll()
			.and()
			.formLogin()
				.loginPage("/login").usernameParameter("username").passwordParameter("password").permitAll()
				.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.and().exceptionHandling().accessDeniedPage("/403")
			.and().csrf();
				
	}
}