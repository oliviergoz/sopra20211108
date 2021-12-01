package formation.sopra.exoBoot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.antMatcher("/**")
				.authorizeRequests()
					.antMatchers("/","/public/**").permitAll()
					//.antMatchers("/secure/admin/**").hasRole("ADMIN")
					//.antMatchers("/secure/user/**").hasRole("USER")
					.anyRequest().authenticated()
				.and()
				.formLogin()
					
				.and()
				.logout()
					.logoutSuccessUrl("/?logout=");
		// @formatter:on
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// @formatter:off
//		auth.inMemoryAuthentication()
//				.withUser("user").password("{noop}user").roles("USER")
//				.and()
//				.withUser("admin").password("{noop}admin").roles("ADMIN");
//		// @formatter:on
		

	}
}
