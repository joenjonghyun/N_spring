package kr.co.patternbot.board.domains;

import com.sun.istack.NotNull;
import kr.co.patternbot.board.domains.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Eager
@Table(name = "boards")
public class Board {
    @Id
    @Column(name = "board_id")
    @GeneratedValue
    private long boardId;
    @Column @NotNull
    private String boardName;
    @Column(name = "created_date") @NotNull private String writtenDate;

    @OneToMany(mappedBy = "board")
    List<Article> a = new ArrayList<>();
}
