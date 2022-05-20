package kr.co.patternbot.soccer.repositories;

import kr.co.patternbot.soccer.domains.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface ScheduleCustomRepository{

}

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
