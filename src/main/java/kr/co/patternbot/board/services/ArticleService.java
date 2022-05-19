package kr.co.patternbot.board.services;

import kr.co.patternbot.board.domains.Article1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ArticleService {
    List<Article1> findAll();

    List<Article1> findAll(Sort sort);

    Page<Article1> findAll(Pageable pageable);

    long count();

    String delete(Article1 article);

    String save(Article1 article);


}
