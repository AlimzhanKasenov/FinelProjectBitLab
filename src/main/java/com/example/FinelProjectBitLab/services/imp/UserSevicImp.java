package com.example.FinelProjectBitLab.services.imp;

import com.example.FinelProjectBitLab.mappers.UserMapper;
import com.example.FinelProjectBitLab.model.User;
import com.example.FinelProjectBitLab.repository.ItemRepos;
import com.example.FinelProjectBitLab.repository.UserRepos;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserSevicImp implements UserDetailsService {
    private final UserMapper userMapper;
    private final UserRepos userRepos;
    private final ItemRepos itemRepos;

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
