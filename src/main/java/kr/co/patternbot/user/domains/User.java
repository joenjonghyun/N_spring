package kr.co.patternbot.user.domains;

import com.sun.istack.NotNull;
import kr.co.patternbot.board.domains.Article;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Eager
@Table(name = "users")
public class User {
    @Id @Column(name = "user_id")
    @GeneratedValue private long userId; //기계가 보는 아이디
    @Column private @NotNull String username; //인간이보는 아이디 위 아래 둘을 기호로 같다고 판단함
    @Column private @NotNull String password;
    @Column private @NotNull String name;
    @Column private @NotNull String email;
    @Column(name = "reg_date") @NotNull private String regDate;

    @OneToMany(mappedBy = "user")
    List<Article> a = new ArrayList<>();

    //EAGER는 등급에 맞는 토큰을 준다고 생각하면 됨
    @ElementCollection(fetch = FetchType.EAGER)
    public List<Role> roles;

}
