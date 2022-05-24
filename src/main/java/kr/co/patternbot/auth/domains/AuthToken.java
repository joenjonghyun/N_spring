package kr.co.patternbot.auth.domains;

import io.jsonwebtoken.*;
import lombok.extern.java.Log;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log //log찍는 이유는 토큰발급된걸 알아야하기 때문 감시시스템
public class AuthToken {
    private String token;
    private String key;

    public AuthToken(String key) {
        this.key = key;
        this.token = createToken();
    }
//Exception은 개발자의 의도대로 만드는거임 누가 시스템에대해 비정상적으로 접근했을때 막는거임 그 코드가 아래.
    //트라이 영역을 벗어나면 토큰을 주지 않고 null값을 보내줌
    private String createToken() {
        try{
            Map<String, Object> headers = new HashMap<>();
            headers.put("typ", "JWT");
            headers.put("alg", "HS256");
            Map<String, Object> payload = new HashMap<>();
            payload.put("data", "dummy");
            Date ext = new Date();
            ext.setTime(ext.getTime() + 1000 * 60L * 10L); //시간을 나타낸 것인데 60초 X 10초 해서 600초 = 10분을 나타냄
            return Jwts.builder()
                    .setHeader(headers)
                    .setClaims(payload)  //payload는 리액트라 생각하셈
                    .setSubject("user")
                    .setExpiration(ext)
                    .signWith(SignatureAlgorithm.HS256, key.getBytes()) //H256으로 암호를 해독하겠단 뜻. H256이건 자주바뀜
                    .compact();
        }
        catch (SecurityException e){log.info("SecurityException JWT");}  //이상이 발생하면 해당 인셉션에 대해 찍어라 라는 뜻
        catch (MalformedJwtException e){log.info("MalformedJwtException JWT");}
        catch (ExpiredJwtException e){log.info("ExpiredJwtException JWT");}
        catch (UnsupportedJwtException e){log.info("UnsupportedJwtException JWT");}
        catch (IllegalAccessError e){log.info("IllegalAccessError JWT");}
        return null;
    }
}
