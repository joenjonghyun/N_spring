package kr.co.patternbot.soccer.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@Component
@Table(name = "teams")
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long teamId;
    private String regionName;
    private String teamName;
    private String eTeamName;
    private String origYyyy;
    private String stadiumId;
    private String zipcode1;
    private String zipcode2;
    private String address;
    private String ddd;
    private String tel;
    private String fax;
    private String homepage;
    private String teamOwner;
}
