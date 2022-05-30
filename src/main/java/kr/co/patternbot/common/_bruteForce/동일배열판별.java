package kr.co.patternbot.common._bruteForce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

public class 동일배열판별 {
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Solution{
        private String result;

        @Override
        public String toString() {
            return String.format("A배열과 B배열은 %s 배열입니다",
                    result);
        }
    }
    @FunctionalInterface interface ISolution{
        Solution solution(Solution s);
    }
    @Test
    void test(){}
}