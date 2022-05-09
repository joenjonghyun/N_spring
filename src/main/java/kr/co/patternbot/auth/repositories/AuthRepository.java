package kr.co.patternbot.auth.repositories;

import kr.co.patternbot.auth.domains.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
}