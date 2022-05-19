package kr.co.patternbot.auth.repositories;

import kr.co.patternbot.auth.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface UserCustomRepository{
    void update(User user);
    String login(User user);
}

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository{

}
