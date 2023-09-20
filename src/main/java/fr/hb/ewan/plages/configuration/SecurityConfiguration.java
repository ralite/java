package fr.hb.ewan.plages.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import fr.hb.ewan.plages.handler.CustomFailureHandler;
import fr.hb.ewan.plages.handler.CustomSuccessHandler;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration {

	// private PasswordEncoder passwordEncoder;

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception  {

		http.csrf(csrf -> csrf.disable()).formLogin() // defaultSuccessUrl("/clients")
				.successHandler(new CustomSuccessHandler())
				.failureHandler(new CustomFailureHandler()).and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/index").and()
				// Accès
				.authorizeHttpRequests(requests -> requests.antMatchers("/swagger-ui/index.html").permitAll()
						.antMatchers("/index").permitAll()
						.antMatchers("/parasols").authenticated()
						.antMatchers(HttpMethod.GET, "/clients").hasRole("ADMIN")
						.antMatchers(HttpMethod.GET, "/reservations").hasRole("ADMIN")
						.antMatchers(HttpMethod.GET, "/parasols").hasAnyRole("USER", "ADMIN"))
				.headers().frameOptions().disable();
		return http.build();
	}

//	@Bean
//	InMemoryUserDetailsManager initUtilisateurs() {
//		UserDetails toto = User.builder().username("toto").password(passwordEncoder.encode("toto")).roles("ADMIN")
//				.build();
//		UserDetails titi = User.builder().username("titi").password(passwordEncoder.encode("titi")).roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(toto, titi);
//	}
}