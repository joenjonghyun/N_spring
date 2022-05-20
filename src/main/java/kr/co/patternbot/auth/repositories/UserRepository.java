package kr.co.patternbot.auth.repositories;

import kr.co.patternbot.auth.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//섞이지 말라고 커스텀 작업
interface UserCustomRepository{
    void update(User user);
    String login(User user);
}

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
