package com.example.FinelProjectBitLab.config;

import com.example.FinelProjectBitLab.services.UserServic;
import com.example.FinelProjectBitLab.services.imp.ItemSevicImp;
import com.example.FinelProjectBitLab.services.imp.UserSevicImp;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(proxyTargetClass = true, prePostEnabled = true,securedEnabled = true)
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    private final UserSevicImp userService;

    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.authorizeRequests().antMatchers("/css/**", "/js/**").permitAll();
        http.exceptionHandling().accessDeniedPage("/forbidden");
        http.formLogin()
                .loginProcessingUrl("/auth") //Отправка запроса на авторизацию
                .usernameParameter("email")
                .usernameParameter("password")
                .defaultSuccessUrl("/profileSuccess") //Если всё норм откроет страницу
                .failureUrl("/loginPage?loginError") //При ошибке +
                .loginPage("/loginPage").permitAll(); //Страница логина

        http.logout()
                .logoutUrl("/exit") //Запрос на выход
                .logoutSuccessUrl("/"); //При выходе перекинет на строницу +
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
