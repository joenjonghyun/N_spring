package kr.co.patternbot.common.enums;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.function.BiFunction;

public class Calculator {
    //이넘은 스태틱 클래스를 만들어놓은 것이라고 생각하면 됨
    @RequiredArgsConstructor /**여기3번*/ enum Operation{
        PLUS("+",(x, y)->(x + y)), //4번
        MINUS("_",(x, y)->(x - y)),
        MULTI("*",(x, y)->(x * y)),
        DIVIDE("/",(x, y)->(x / y))
        ;
        private final String opcode; //순서가 중요함 여기 라인 1번
        private final BiFunction<Integer, Integer, Integer> f; //2번

        @Override public String toString() {return opcode;} //4번
        public int apply(int a, int b){return f.apply(a, b);} //5번 apply이름 맞춰주면 가독성이 좋음

    }
    @Test
    void calculatorTest(){
        System.out.println("+: "+Operation.PLUS.apply(7,5)); //5번
        System.out.println("-: "+Operation.MINUS.apply(7,5));
        System.out.println("*: "+Operation.MULTI.apply(7,5));
        System.out.println("/: "+Operation.DIVIDE.apply(7,5));
    }

}

