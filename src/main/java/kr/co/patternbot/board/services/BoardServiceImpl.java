package kr.co.patternbot.board.services;

import kr.co.patternbot.board.controllers.BoardController;
import kr.co.patternbot.board.repositories.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository repository;

}
