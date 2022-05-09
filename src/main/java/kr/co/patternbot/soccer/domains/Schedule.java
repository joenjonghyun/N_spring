package kr.co.patternbot.soccer.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@Component
@Table(name = "schedules")
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stadiumId ;
    private String date; ;
    private String gubun ;
    private String homeTeamId ;
    private String awayTeamId ;
    private String homeScore ;
    private String awayScore ;

}
