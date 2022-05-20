package kr.co.patternbot.board.controllers;

import kr.co.patternbot.board.domains.Board;
import kr.co.patternbot.board.services.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;


    // Embeded Methods
    @GetMapping("/findAll")
    public List<Board> findAll() {return service.findAll();}

    @GetMapping("/findAll/sort")
    public List<Board> findAll(Sort sort) {return service.findAll(sort);}

    @GetMapping("/findAll/pageable")
    public Page<Board> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Board board) {
        return service.delete(board);
    }

    @PostMapping("/join")
    public String save(@RequestBody Board board) {
        return service.save(board);
    }

    @GetMapping("/findById/{boardId}")
    public Optional<Board> findById(@PathVariable String boardId) {
        return service.findById(boardId);
    }

    @GetMapping("/existsById/{boardId}")
    public boolean existsById(@PathVariable String boardId) {
        return service.existsById(boardId);
    }
}


