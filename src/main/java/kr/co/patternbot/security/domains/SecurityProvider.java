package kr.co.patternbot.security.domains;

import kr.co.patternbot.auth.domains.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Log //씨씨티비같은 역할, 방문자나 뭔 상황이 발생했을 때 로그를 찍어줌
@Component //스프링시큐리티가 알아야하기 때문에 컴포넌트를 걸었음
@RequiredArgsConstructor
public class SecurityProvider implements AuthenticationProvider {

    private final UserDetailsServiceImpl service;

    @Value("${security.jwt.token.security-key:secret-key}")
    private String securityKey;

    @Value("${security.jwt.token.expiration-length:3600000}")
    private long validityInMs = 3600000; //1h

    @PostConstruct
    protected void init(){
        securityKey = Base64.getEncoder().encodeToString(securityKey.getBytes());
        log.info("securityKey: "+securityKey); //토큰생성한걸 값으로찍어서보려는 작업임 나중에는 지워야돼
    }

    //roles는 사용자들 위치에 따라서 보기를 다르게 할 수 있는 코드
    public String createToken(String username, List<Role> roles){
        return "";
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
