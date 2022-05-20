package kr.co.patternbot.board.services;

import kr.co.patternbot.board.domains.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    List<Article> findAll();

    List<Article> findAll(Sort sort);

    Page<Article> findAll(Pageable pageable);

    long count();

    String delete(Article article);

    String save(Article article);

    Optional<Article> findById(String articleId);

    boolean existsById(String articleId);


}
