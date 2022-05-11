package kr.co.patternbot.common.lambda;

//자료구조가 들어가면 함수형이 아니기 때문에 hashmap 안 씀
//여기에선 함수형 프로그램을 하기 때문에 도메인이 필요없음
//Arithmetic 은 산술연산이라는 뜻
//람다는 함수형 객체니까 파라미터로 전달할수있음
public class Calculator {
    public static void main(String... args) {
        var s = "계산기";  //타입 추론. 명확 할 때 사용함 그 근거는 7번라인 string...인듯 ?
        System.out.println(s);
        Calculator c = new Calculator();
        System.out.println("10 + 5 = " + c.operate(10, 5, (a, b)->a+b));
        System.out.println("10 - 5 = " + c.operate(10, 5, (a, b)->a-b));
        System.out.println("10 x 5 = " + c.operate(10, 5, (a, b)->a*b));
        System.out.println("10 / 5 = " + c.operate(10, 5, (a, b)->a/b));
    }
    interface Arithmetic {
        int operation(int a, int b);
    }
    private int operate(int a, int b, Arithmetic arith){
        return arith.operation(a, b);
    }
}
