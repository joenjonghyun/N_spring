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
    public static class Person{
        private String name, ssn, age;
        @Override //알트인서트에서 투스트링
        public String toString(){
            int age = (Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()))) - (1900+Integer.parseInt(ssn.substring(0,2)));
            int age1 = (Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()))) - (2000+Integer.parseInt(ssn.substring(0,2)));
            String gender = ssn.substring(7).equals("1")||ssn.substring(7).equals("3") ? "남자":"여자";
            int age2 = ssn.substring(7).equals("1")||ssn.substring(7).equals("2") ? age:age1;
            return String.format("이름:%s, 성별: %s, 나이: %d살", name,gender,age2);
        }
    }

    //기능: 회원검색
    interface PersonService{
        Person search(List<Person> arr);
    }
    static class PersonServiceImpl implements PersonService{
        @Override
        public Person search(List<Person> arr) {
            return arr
                    .stream()
                    .filter(e -> e.getName().equals("신사임당"))
                    .collect(Collectors.toList()).get(0);
        }
    }
    @Test
    void personStreamTest(){
        List<Person> arr = Arrays.asList(
                Person.builder().name("신사임당").ssn("021224-4").build(),
                Person.builder().name("유관순").ssn("970224-2").build(),
                Person.builder().name("홍길동").ssn("000202-3").build(),
                Person.builder().name("전종현").ssn("980814-1").build()
        );
        System.out.println(new PersonServiceImpl()
                .search(arr));

        //"홍길동","900120-1"
        //"김유신","911220-1"
        //"유관순","000204-4"
        //남성, 여성, 나이 판단 로직
    }
}
