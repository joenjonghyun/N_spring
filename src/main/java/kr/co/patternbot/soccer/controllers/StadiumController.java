package kr.co.patternbot.soccer.controllers;

import kr.co.patternbot.soccer.domains.Player;
import kr.co.patternbot.soccer.domains.Stadium;
import kr.co.patternbot.soccer.services.StadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stadiums")
public class StadiumController {
    private final StadiumService service;


    // Embeded Methods
    @GetMapping("/findAll")
    public List<Stadium> findAll() {return service.findAll();}

    @GetMapping("/findAll/sort")
    public List<Stadium> findAll(Sort sort) {return service.findAll(sort);}

    @GetMapping("/findAll/pageable")
    public Page<Stadium> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Stadium stadium) {
        return service.delete(stadium);
    }

    @PostMapping("/join")
    public String save(@RequestBody Stadium stadium) {
        return service.save(stadium);
    }

    @GetMapping("/findById/{stadiumId}")
    public Optional<Stadium> findById(@PathVariable String stadiumId) {
        return service.findById(stadiumId);
    }

    @GetMapping("/existsById/{stadiumId}")
    public boolean existsById(@PathVariable String stadiumId) {
        return service.existsById(stadiumId);
    }
}
