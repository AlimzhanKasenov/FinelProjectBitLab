package com.example.FinelProjectBitLab.services.imp;

import com.example.FinelProjectBitLab.model.User;
import com.example.FinelProjectBitLab.repository.UserRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSevicImp implements UserDetailsService{
    private final UserRepos userRepos;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepos.findAllByEmail(username);
        if (user != null){
            return user;
        }else {
            throw new UsernameNotFoundException("Ошибка");
        }
    }
}
