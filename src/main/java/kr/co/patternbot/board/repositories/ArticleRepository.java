package kr.co.patternbot.board.repositories;

import kr.co.patternbot.board.domains.Article1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article1, Long> {
}
