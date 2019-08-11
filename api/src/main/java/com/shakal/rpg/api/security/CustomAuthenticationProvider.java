package com.shakal.rpg.api.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.shakal.rpg.api.model.User;
import com.shakal.rpg.api.service.UserService;
import com.shakal.rpg.api.utils.Messages;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String encryptedPassword = authentication.getCredentials().toString();

        try {
            User user = (User) this.userService.loadUserByUsername(username);
            if (encoder.bCryptPasswordEncoder().matches(encryptedPassword,user.getPassword())) {
            	
            	AuthenticationContext auth = new AuthenticationContext(true, user.getId(), 
            			user.getUsername(), user.getPassword());
                return auth;
            }else{
                throw new BadCredentialsException(Messages.INVALID_PASSWORD);
            }

        }catch(UsernameNotFoundException e){
            throw new BadCredentialsException(Messages.USER_NOT_FOUND);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
