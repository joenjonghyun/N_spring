package kr.co.patternbot.common._bruteForce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

public class 과일바구니 {
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Solution{
        private int total, apple, grape, orange;

        @Override
        public String toString() {
            return String.format("total: %d, apple: %d, grape: %d, orange: %d",
                    total, apple, grape, orange);
        }
    }
    @FunctionalInterface interface ISolution{
        Solution solution(Solution s);
    }
    @Test
    void test(){}
}