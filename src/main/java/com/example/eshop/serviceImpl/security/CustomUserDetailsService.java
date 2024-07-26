package com.example.eshop.serviceImpl.security;

import com.example.eshop.entity.users.Buyer;
import com.example.eshop.repository.users.BuyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final BuyerRepository buyerRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<Buyer> optionalBuyer = buyerRepository.findByName(name);
        Buyer buyer = optionalBuyer
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + name));
        return new org.springframework.security.core.userdetails.User(
                buyer.getName(),
                buyer.getPassword(),
                new ArrayList<>() // Authorities (Roles) can be added here
        );

    }
}
