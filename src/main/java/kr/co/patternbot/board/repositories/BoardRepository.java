package kr.co.patternbot.board.repositories;

import kr.co.patternbot.board.domains.Board1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board1, Long> {
}
