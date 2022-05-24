package kr.co.patternbot.auth.service;

import kr.co.patternbot.user.domains.User;
import kr.co.patternbot.user.repositories.UserRepository;

import kr.co.patternbot.auth.domains.Auth;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements UserDetailsService {
    private final UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(repository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException(username + "에 해당하는 객체 없음"));
        return Auth.build(user.get());
    }
}
