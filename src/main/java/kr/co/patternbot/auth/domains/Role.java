package kr.co.patternbot.auth.domains;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;

//권한을 주는거임 그랜티드어쏠리티.
//게터만 쓰고 빌더를 안 쓴다는 것은 read 온리임 수정불가능.
@Getter
@RequiredArgsConstructor
public enum Role implements GrantedAuthority {
    ADMIN("ROLE_ADMIN", "관리자권한"),
    USER("ROLE_USER", "사용자권한"),
    UNKNOWN_USER("ROLE_UNKNOWN_USER", "알수없는 사용자")
    ;
    private final String code;
    private final String description;

    public static Role of(String code) {
        return Arrays.stream(Role.values()).filter(i -> i.getCode().equals(code))
                .findAny().orElse(UNKNOWN_USER);
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
