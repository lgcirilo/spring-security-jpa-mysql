package com.lgcirilo.springsecurityjpamysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("entrou em loadUserByUsername");
        Optional<User> user = userRepository.findByUsername(username);

//        user.orElseThrow(() -> new UsernameNotFoundException("not found: " + username));
        if (!user.isPresent()) {
            logger.info("entrou na excecao");

            throw new UsernameNotFoundException("not found: " + username);
        }

//        return user.map(MyUserDetails::new).get();
        logger.info(user.get().toString());
        return new MyUserDetails(user.get());

    }
}
