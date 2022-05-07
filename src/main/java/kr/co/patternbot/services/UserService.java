package kr.co.patternbot.services;

import kr.co.patternbot.domains.User;

public interface UserService {
    void join(User join);
    String login(User login);
    void logout(User logout);
}
