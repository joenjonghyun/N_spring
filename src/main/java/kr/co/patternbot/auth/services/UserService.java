package kr.co.patternbot.auth.services;

import kr.co.patternbot.auth.domains.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void join(User join);
    String login(User login);
    void logout(User logout);

    List<User> findAll();

    List<User> findAll(Sort sort);

    Page<User> findAll(Pageable pageable);

    long count();

    String delete(User user);

    String save(User user);

    Optional<User> findById(String userid);

    boolean existsById(String userid);

    String put(User user);

    // custom

    List<User> findByUserName(String name);
}
