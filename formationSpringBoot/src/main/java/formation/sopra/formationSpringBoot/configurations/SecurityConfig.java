package formation.sopra.formationSpringBoot.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/images/**", "/css/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// authentification par user =>authenticated
		// par role=>hasRole hasAnyRole

		// @formatter:off
		http.antMatcher("/**")
				.authorizeRequests()
					.antMatchers("/client/**","/public/**").permitAll()
					.antMatchers("/produit/**").authenticated()
					.antMatchers("/commande/**","/panier/**").hasRole("USER")
					.anyRequest().authenticated()
				.and()
				.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/auth/home")
					.failureUrl("/login?error=")
					.permitAll()
				.and()
				.logout()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/public?logout=");
		// @formatter:on
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// @formatter:off
		auth.inMemoryAuthentication()
				.withUser("olivier").password("{noop}olivier").roles("USER")
				.and()
				.withUser("admin").password("{noop}admin").roles("ADMIN");
		// @formatter:on
	}

//	@Bean
//	public PasswordEncoder passwordEncorder() {
//		return  NoOpPasswordEncoder.getInstance();
//	}
}
