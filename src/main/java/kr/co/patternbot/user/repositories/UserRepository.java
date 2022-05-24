package kr.co.patternbot.user.repositories;

import kr.co.patternbot.user.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//섞이지 말라고 커스텀 작업
interface UserCustomRepository{
    void update(User user);
    String login(User user);
}

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
}
