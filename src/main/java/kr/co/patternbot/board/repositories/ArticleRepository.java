package kr.co.patternbot.board.repositories;

import kr.co.patternbot.board.domains.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//섞이지 말라고 커스텀작업
interface ArticleCustomRepository{

}

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
