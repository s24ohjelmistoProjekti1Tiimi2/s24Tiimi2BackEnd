package s24tiimi2.backend.web;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import s24tiimi2.backend.domain.AppUser;
import s24tiimi2.backend.domain.AppUserRepository;

// Spring Security uses this Class to identify and authenticate user
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AppUserRepository userRepository;

    public UserDetailsServiceImpl(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser currentUser = userRepository.findByUsername(username);
        UserDetails user = new User(username, currentUser.getPassword(),
                AuthorityUtils.createAuthorityList(currentUser.getRole()));

        return user;
    }
}
