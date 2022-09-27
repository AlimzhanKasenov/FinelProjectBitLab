package com.example.FinelProjectBitLab.services.imp;

import com.example.FinelProjectBitLab.model.User;
import com.example.FinelProjectBitLab.repository.UserRepos;
import com.example.FinelProjectBitLab.services.UserServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSevicImp implements UserDetailsService, UserServic {


    @Autowired
    private UserRepos userRepos;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = userRepos.findByEmail(username);
        if (foundUser != null) return  foundUser;
        throw new UsernameNotFoundException("User not found");
    }

}
