package kr.co.patternbot.common._greedy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

public class 단속카메라 {
    @Builder
    @AllArgsConstructor
    @Getter
    @NoArgsConstructor
    public static class Solution{
        private int [][] routes;
        private int answer = 0;

    }
    @FunctionalInterface
    public interface SolutionService {단속카메라.Solution solution(단속카메라.Solution s);}

    @Test
    void testSolution(){}
}

