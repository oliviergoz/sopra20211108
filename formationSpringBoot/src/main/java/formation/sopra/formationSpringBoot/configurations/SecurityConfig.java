package formation.sopra.formationSpringBoot.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		//http.antMatcher("/**").csrf().disable().authorizeRequests().anyRequest().permitAll();
		
		http
			.antMatcher("/api/**")
				.csrf().ignoringAntMatchers("/api/**")
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
					.antMatchers(HttpMethod.OPTIONS).anonymous()
					.antMatchers("/api/auth").authenticated()
					.antMatchers(HttpMethod.POST,"/api/client").permitAll()
					.antMatchers("/api/**").hasRole("USER")
				.and()
				.httpBasic()
			.and()
			.antMatcher("/**")
				.authorizeRequests()
					.antMatchers("/panier/valider","/panier/save").hasRole("USER")
					.antMatchers("/client/**","/public/**","/panier/**").permitAll()
					.antMatchers("/produit/**").hasRole("ADMIN")
					.antMatchers("/commande/**").hasRole("ADMIN")
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

//	@Autowired
//	private DataSource dataSource;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// @formatter:off
//		auth.inMemoryAuthentication()
//				.withUser("olivier").password("{noop}olivier").roles("USER")
//				.and()
//				.withUser("admin").password("{noop}admin").roles("ADMIN");
//		// @formatter:on

//		// @formatter:off
//		auth.jdbcAuthentication()
//				.dataSource(dataSource)
//					.usersByUsernameQuery("select users_login,users_password,users_enable from users where users_login=?")
//					.authoritiesByUsernameQuery("select u.users_login,ur.roles from users_roles ur join users u on u.id=ur.user_id  where u.users_login=?");
//		// @formatter:on

		auth.userDetailsService(userDetailsService);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public PasswordEncoder passwordEncorder() {
//		return  NoOpPasswordEncoder.getInstance();
//	}
}
