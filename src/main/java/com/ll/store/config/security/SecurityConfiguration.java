package com.ll.store.config.security;
;
import com.ll.store.config.security.service.AuthenticationService;
import com.ll.store.config.security.service.TokenService;
import com.ll.store.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationService serviceAuthentication;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    //Configurações de autenticação (login)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(serviceAuthentication).passwordEncoder(new BCryptPasswordEncoder());
    }

    //Configurações de autorização (url)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/brands").permitAll()
                .antMatchers(HttpMethod.GET, "/brands/*").permitAll()
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.DELETE, "/users/*").permitAll()
                .antMatchers(HttpMethod.PATCH, "/users/*").permitAll()
                .antMatchers(HttpMethod.GET, "/markets").permitAll()
                .antMatchers(HttpMethod.GET, "/markets/*").permitAll()
                .antMatchers(HttpMethod.GET, "/products").permitAll()
                .antMatchers(HttpMethod.GET, "/products/*").permitAll()
                .antMatchers(HttpMethod.GET, "/sections").permitAll()
                .antMatchers(HttpMethod.GET, "/sections/*").permitAll()
                .antMatchers(HttpMethod.GET, "/file").permitAll()
                .antMatchers(HttpMethod.GET, "/file/*").permitAll()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .anyRequest().authenticated()
                .and().cors()
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(new JwtTokenFilterAuthentication(tokenService, userRepository), UsernamePasswordAuthenticationFilter.class);
    }
}
