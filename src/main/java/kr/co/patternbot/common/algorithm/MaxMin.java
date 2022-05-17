package kr.co.patternbot.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

//던져지는 값은 인트배열
//elem = 안에 들어있는 엘리먼트 값
//arr값에는 최소값, 최대값, 그외의 다른 엘리먼트값
public class MaxMin {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    private static class Solution {
        private int[] arr;
        private int max, min;

        @Override
        public String toString() {
            return String.format("최소값: %d, 최대값: %d", min, max);
        }
    }

    //아래부터는 기능.
    //prive쓴 이유는 메소드마다 따로 사용하니까 이름 충돌 안 나게 하기 위해
    @FunctionalInterface
    private interface SolutionService {
        Solution solution(Solution s);
    }

    @Test
    void testSolution(){
        int[] arr = {3, 1, 9, 5, 10};
        SolutionService f = e -> {
            int max = 0;
            for (int i : e.getArr()) {if (i > max) max = i;}
            int min = max;
            for (int i : e.getArr()) {if (i < min) min = i;}
            return Solution.builder().min(min).max(max).build();
        };
        Solution s = Solution.builder().arr(arr).build();
        System.out.println(f.solution(s));
    }
}
