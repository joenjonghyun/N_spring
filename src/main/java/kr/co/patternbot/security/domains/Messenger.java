package kr.co.patternbot.security.domains;

import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Component;

//스프링이 몰라도 돼서 컴포넌트를 안 줌 , 리액트로 던질거임
@Getter @Builder
public class Messenger {
    private String message, code;
    private int status;
}
