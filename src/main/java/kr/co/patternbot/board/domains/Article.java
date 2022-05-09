package kr.co.patternbot.board.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Component
@Entity
@Table(name = "boards")
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projects;
    private String startData;
    private String status;
    private String team;
    private String progress;
    private String action;
}
