package com.harish.starting;

//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//import org.springframework.security.web.authentication.HttpStatusEntryPoint;
//
//	@Configuration
//	@EnableWebSecurity(debug = true)
	public class SecurityConfig {//extends WebSecurityConfigurerAdapter {

	    //@Override
	    //protected void configure(HttpSecurity http)throws Exception {
//	        http.authorizeRequests().anyRequest().authenticated()
//	                .and()
//	                .oauth2Login();
//	    	http.cors().and()
//            .csrf()
//            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
//            .authorizeRequests(a -> a
//                    .antMatchers("/", "/error", "/webjars/**","/oauth2/**","/*.css","/*.js*","/assets/**","/test/**").permitAll()
//                    .anyRequest().authenticated()
//            )
//            .exceptionHandling(e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//            )
//            .logout()
//            .permitAll()
//            .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
//                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
//            }).and()
//            .oauth2Login().defaultSuccessUrl("http://localhost:4200");
	    }

	
