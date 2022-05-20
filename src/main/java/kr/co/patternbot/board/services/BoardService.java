package kr.co.patternbot.board.services;

import kr.co.patternbot.board.domains.Board;
import kr.co.patternbot.board.domains.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface BoardService {

    List<Board> findAll();

    List<Board> findAll(Sort sort);

    Page<Board> findAll(Pageable pageable);

    long count();

    String delete(Board board);

    String save(Board board);

    Optional<Board> findById(String boardId);

    boolean existsById(String boardId);
}
