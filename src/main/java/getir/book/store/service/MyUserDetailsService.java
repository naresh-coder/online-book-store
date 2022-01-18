package getir.book.store.service;

import getir.book.store.entities.Customer;
import getir.book.store.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<Customer> customer = customerRepository.findByUsername(s);
        if (customer.isEmpty()) {
            return new User(customer.get().getUsername(), customer.get().getPassword(),
                    new ArrayList<>());
        }
        return null;
    }
}