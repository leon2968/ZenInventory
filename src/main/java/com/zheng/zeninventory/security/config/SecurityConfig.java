package com.zheng.zeninventory.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
/*
 * Config for spring security
 */
public class SecurityConfig {
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	/*
	 * FilterChain only allows user login/register page access before authentication
	 */
	public SecurityFilterChain filerChain(HttpSecurity http) throws Exception{
		http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/login").permitAll()
				.antMatchers("/registerUser").permitAll()
				.antMatchers("/registerUser?success").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin(
						form -> form
								.loginPage("/login")
								.loginProcessingUrl("/login")
								.defaultSuccessUrl("/index")
								.permitAll()
				).logout(
						logout -> logout
									.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
									.permitAll()
				);
		return http.build();
				
	}
}
