package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.ldap.LdapAuthenticationProviderConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		LdapAuthenticationProviderConfigurer<AuthenticationManagerBuilder>.ContextSourceBuilder autenticador = auth.ldapAuthentication()
		.userSearchFilter("uid={0}")
		//.userDnPatterns("uid={0}")
		//.groupSearchBase("cn=users,cn=accounts")
		.contextSource()
		//.ldif("classpath:test-server.ldif");
		//.managerDn("uid=admin,cn=users,cn=accounts")
        //.managerPassword("password")
		.url("ldap://freeipa.portal.incige.com:389/cn=users,cn=accounts,dc=portal,dc=incige,dc=com");
		System.out.println(autenticador);

	}
}
