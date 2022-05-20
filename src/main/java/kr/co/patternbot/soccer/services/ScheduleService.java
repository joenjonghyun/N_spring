package kr.co.patternbot.soccer.services;

import kr.co.patternbot.soccer.domains.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {


    List<Schedule> findAll();

    List<Schedule> findAll(Sort sort);

    Page<Schedule> findAll(Pageable pageable);

    long count();

    String delete(Schedule schedule);

    String save(Schedule schedule);

    Optional<Schedule> findById(String stadiumId);

    boolean existsById(String stadiumId);
}
