package com.eloaca.autenticacaoBasica.config.security

import com.eloaca.autenticacaoBasica.config.SecurityDataBaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig(
    private val securityDataBaseService: SecurityDataBaseService,
) : WebSecurityConfigurerAdapter() {

    @Autowired
    fun globalUserDetails(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(securityDataBaseService).passwordEncoder(NoOpPasswordEncoder.getInstance())
    }

    override fun configure(http: HttpSecurity?) {
        http!!.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers(HttpMethod.POST, "/login").permitAll()
            .antMatchers("/managers").hasRole("MANAGERS")
            .antMatchers("/users").hasAnyRole("MANAGERS", "USERS")
            .anyRequest().authenticated().and().httpBasic()
    }
}


    /*
    @Bean
    @Throws(Exception::class)
    fun filterChain2(httpSecurity: HttpSecurity): SecurityFilterChain? {
        httpSecurity
            .authorizeHttpRequests(
                Customizer { authz: AuthorizationManagerRequestMatcherRegistry ->
                    authz
                        .anyRequest().authenticated()
                }
            )
            .httpBasic(withDefaults())
        return httpSecurity.build()
    }

    override fun configure(auth : AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
            .withUser("eloaca")
            .password("{noop}eloaca")
            .roles("USERS")
            .and()
            .withUser("admin")
            .password("{noop}admin")
            .roles("MANAGERS")
    }
     */