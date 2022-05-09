package kr.co.patternbot.board.repositories;

import kr.co.patternbot.board.domains.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
