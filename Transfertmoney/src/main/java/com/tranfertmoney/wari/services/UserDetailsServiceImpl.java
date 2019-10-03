package com.tranfertmoney.wari.services;

import com.tranfertmoney.wari.model.User;
import com.tranfertmoney.wari.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private User userConnecte;

    @Autowired
    UserRepository userRepository;

    @Override // methode heriter
    @Transactional // demarrer , operation
    public UserPrinciple loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
        this.userConnecte = user;
        return UserPrinciple.build(user);
    }
    public User getUserConnecte(){
        return userConnecte;
    }
}
