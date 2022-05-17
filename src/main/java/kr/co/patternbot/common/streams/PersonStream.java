package kr.co.patternbot.common.streams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class PersonStream {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Person {
        private String name, ssn;

        @Override //알트인서트에서 투스트링
        public String toString() {
            int age1 = (Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()))) - (1900 + Integer.parseInt(ssn.substring(0, 2)));
            int age2 = (Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()))) - (2000 + Integer.parseInt(ssn.substring(0, 2)));
            String gender = ssn.substring(7).equals("1") || ssn.substring(7).equals("3") ? "남자" : "여자";
            int age = ssn.substring(7).equals("1") || ssn.substring(7).equals("2") ? age1 : age2;
            return String.format("이름:%s, 성별: %s, 나이: %d살", name, gender, age);
        }
    }

    //기능: 회원검색
    //@Func어쩌고는 람다로 만들거라는 뜻
    //람다 사용하는 이유는 필요 할 때만 쓰고 필요없을 땐 없었으면 ㅇㅇ
    @FunctionalInterface interface PersonService {Person search(List<Person> persons);}


    @Test
    void personStreamTest() {
        //"홍길동","900120-1"
        //"김유신","911220-1"
        //"유관순","000204-4"
        //남성, 여성, 나이 판단 로직
        //나중에 컨트롤러로 옮길거임
        //아래는 디비에서 가져온거고
        List<Person> l = Arrays.asList(
                Person.builder().name("신사임당").ssn("021224-4").build(),
                Person.builder().name("유관순").ssn("970224-2").build(),
                Person.builder().name("홍길동").ssn("000202-3").build(),
                Person.builder().name("전종현").ssn("980814-1").build()
        );
        //여기서부터는 서비스에서 가져온거임
        PersonService ps = persons -> persons
                .stream()
                .filter(e -> e.getName().equals("신사임당"))
                .collect(Collectors.toList()).get(0);
        System.out.println(ps
                .search(l));
    }
}
