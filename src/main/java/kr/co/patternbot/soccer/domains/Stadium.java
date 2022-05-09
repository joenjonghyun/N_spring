package kr.co.patternbot.soccer.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@Component
@Table(name = "stadiums")
public class Stadium {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long stadiumId;
    private String stadiumName;
    private String homeTeamId;
    private String seatCount;
    private String address;
    private String ddd;
    private String tel;
}
