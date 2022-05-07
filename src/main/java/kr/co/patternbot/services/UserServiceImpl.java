package kr.co.patternbot.services;

import kr.co.patternbot.domains.User;
import kr.co.patternbot.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;

    @Override
    public void join(User join) {

    }

    @Override
    public String login(User login) {

        return null;
    }

    @Override
    public void logout(User logout) {

    }
}
