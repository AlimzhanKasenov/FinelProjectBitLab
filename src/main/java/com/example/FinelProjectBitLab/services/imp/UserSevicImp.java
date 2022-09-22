package com.example.FinelProjectBitLab.services.imp;

import com.example.FinelProjectBitLab.model.User;
import com.example.FinelProjectBitLab.repository.UserRepos;
import com.example.FinelProjectBitLab.services.UserServic;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSevicImp implements UserDetailsService, UserServic {

    @Autowired
    private UserRepos userRepos;

    public User getUser(String email){
        return userRepos.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = getUser(username);
        if (foundUser != null) return  foundUser;
        throw new UsernameNotFoundException("User not found");
    }
}
