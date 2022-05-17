package kr.co.patternbot.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;


public class Fruits {
    @Builder @NoArgsConstructor @AllArgsConstructor @Getter
    private static class Solution{
        private int[] [] arr;
        private int total, apple, grape,orange;
    }
    @FunctionalInterface private interface SolutionService{
        Solution solution(Solution s);
    }
    @Test void testSolution(){
        int [] [] arr = {};
    }
}
