package com.example.FinelProjectBitLab.config;

import com.example.FinelProjectBitLab.services.UserServic;
import com.example.FinelProjectBitLab.services.imp.ItemSevicImp;
import com.example.FinelProjectBitLab.services.imp.UserSevicImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(proxyTargetClass = true, prePostEnabled = true, securedEnabled = true)
public class ConfigSecurity{

    @Bean
    public UserDetailsService userServic(){
        return new UserSevicImp();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder.userDetailsService(userServic()).passwordEncoder(passwordEncoder());

        http.exceptionHandling().accessDeniedPage("/forbidden");
        http.authorizeRequests().antMatchers("/css/**", "/js/**").permitAll();

                http.formLogin()
                .loginProcessingUrl("/auth") //Кудо отправляется запрос за место, permitAll можно ограничить по провам
                .defaultSuccessUrl("/mainPage") //Если всё норм то перекидывает на
                .failureUrl("/signin?error") //Если ошибка то в строке напишет ошибку и вернётся обратно на строницу входа
                .loginPage("/signin").permitAll() //Строница входа
                .usernameParameter("user_email")
                .passwordParameter("user_password");

        http.logout()
                .logoutSuccessUrl("/") //При успешном выходе перекинет на страницу
                .logoutUrl("/signout"); //Отправляет запрс на выход

        http.csrf().disable();
        return http.build();
    }
}
