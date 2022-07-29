package dev.locus.flatup.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import dev.locus.flatup.auth.filter.AuthWithTokenFilter;
import dev.locus.flatup.auth.service.AuthenticationService;
import dev.locus.flatup.auth.service.TokenService;
import dev.locus.flatup.usuario.repository.UsuarioRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TokenService tokenService;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    // autenticação
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
    }

    // autorização
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().authorizeHttpRequests()
                .antMatchers( "/swagger-ui/**").permitAll()
                .antMatchers( "/h2-console/**").permitAll()
                .antMatchers( "/auth").permitAll()
                .antMatchers(HttpMethod.POST, "/usuario/salvar").permitAll()
                .anyRequest().authenticated().and().csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .addFilterBefore(
                    new AuthWithTokenFilter(tokenService, usuarioRepository), 
                    UsernamePasswordAuthenticationFilter.class);
    }

    // recursos estaticos
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**","/configuration/**", "/swagger-resources/**");
    }
    
}
