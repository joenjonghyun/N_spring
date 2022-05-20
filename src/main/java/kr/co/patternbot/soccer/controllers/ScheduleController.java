package kr.co.patternbot.soccer.controllers;

import kr.co.patternbot.auth.domains.User;
import kr.co.patternbot.soccer.domains.Schedule;
import kr.co.patternbot.soccer.services.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService service;


    // Embeded Methods
    @GetMapping("/findAll")
    public List<Schedule> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAll/sort")
    public List<Schedule> findAll(Sort sort) {
        return service.findAll(sort);
    }

    @GetMapping("/findAll/pageable")
    public Page<Schedule> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Schedule schedule) {
        return service.delete(schedule);
    }

    @PostMapping("/join")
    public String save(@RequestBody Schedule schedule) {
        return service.save(schedule);
    }

    @GetMapping("/findById/{stadiumId}")
    public Optional<Schedule> findById(@PathVariable String stadiumId) {
        return service.findById(stadiumId);
    }

    @GetMapping("/existsById/{stadiumId}")
    public boolean existsById(@PathVariable String stadiumId) {
        return service.existsById(stadiumId);
    }
}
