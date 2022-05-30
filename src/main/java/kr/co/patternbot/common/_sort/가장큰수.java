package kr.co.patternbot.common._sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

public class 가장큰수 {
    @Data
    @AllArgsConstructor
    static class Solution{

        @Override public String toString(){


            return "";
        }
    }
    @FunctionalInterface interface SolutionService {
        Solution solution(Solution s);
    }
    @Test
    void testSolution(){

    }
}