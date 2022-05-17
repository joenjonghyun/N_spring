package kr.co.patternbot.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import java.util.List;

//1부터100 사이 소수값 구해라
//start 값이랑 end값 prime값
public class PrimeNumber {
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
            private static class Solution{
        private int start, end;
        private int[] primes;

        @Override
        public String toString() {
            return String.format("start: %s, end: %s, prime:%s");
        }
    }
    @FunctionalInterface private interface SolutionService{
        Solution solution(Solution s);
    }
    @Test
    void testSolution(){
        int [] arr = {};
    }

}
