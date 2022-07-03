package kr.co.patternbot.common._greedy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 *
 * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
 *
 * 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
 *
 * 제한 조건
 * number는 2자리 이상, 1,000,000자리 이하인 숫자입니다.
 * k는 1 이상 number의 자릿수 미만인 자연수입니다.
 *
 * 입출력 예
 * number	k	return
 * "1924"	2	"94"
 * "1231234"	3	"3234"
 * "4177252841"	4	"775841"
 * */
//다시해야됨
public class 큰수만들기 {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Solution {
        private String number;
        private int k;
        private int answer;

        @Override
        public String toString() {
            return String.format("%d", answer);
        }

        @FunctionalInterface
        private interface SolutionService {
            Solution solution(Solution s);
        }

        class Service {
            SolutionService f = e -> {
                e.answer = e.k;
                StringBuilder answer = new StringBuilder("");
                int len = number.length() - k;
                int start = 0;

                while(start < number.length() && answer.length() != len) {
                    int leftNum = k + answer.length() + 1;
                    int max = 0;
                    for (int j = start; j < leftNum; j++) {
                        if (max < number.charAt(j) - '0') {
                            max = number.charAt(j) - '0';
                            start = j + 1;
                        }
                    }
                    answer.append(Integer.toString(max));
                }
             return Solution.builder()
                     .k(getK())
                     .answer(getAnswer())
                     .number(getNumber())
                     .build();
            };
            Solution test(Solution s){
                return f.solution(s);
            }
        }

        @Test
        void testSolutionTest() {
            String number = "1924";
            int k = 2;
            Solution solution = Solution.builder()
                    .number(number)
                    .k(k)
                    .answer(answer)
                    .build();
            Service service = new Service();
            System.out.println(service.test(solution));

        }
    }
}
