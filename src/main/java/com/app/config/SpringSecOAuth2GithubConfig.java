package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecOAuth2GithubConfig {
	
	@Bean
	SecurityFilterChain defaulSecurityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(requests-> requests.anyRequest().authenticated())
			.oauth2Login(Customizer.withDefaults()); // As now we are using OAuth2 logins and 
		//not html login. Now our application will act as a client application.
		//But here my application does not know the client id and secret. So we create clientRegRepo() (below)
		return http.build();
	}
	
	//We can configure like this, or configure it in application.properties
	/*@Bean
	public ClientRegistrationRepository clientRepository() {
		ClientRegistration clientReg = clientRegistration();
        return new InMemoryClientRegistrationRepository(clientReg);
	}
	
	private ClientRegistration clientRegistration() {
		//CommonOAuth2Provider contains multiple values of github, google, etc. Otherwise we would have had to manually confihure it all.
		return CommonOAuth2Provider.GITHUB.getBuilder("github").clientId("17ec855a81574693b48a")
	           .clientSecret("17c844b17079df6de44ef8ec166afc8bcf2838db").build();
	 }*/

}
