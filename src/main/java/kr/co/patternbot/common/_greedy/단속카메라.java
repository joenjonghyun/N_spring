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
        private int answer;

    }
    @FunctionalInterface
    public interface SolutionService {단속카메라.Solution solution(단속카메라.Solution s);}

    class Service{
        SolutionService f = e -> {
            return Solution.builder().build();
        };
        Solution test(Solution s){
            return f.solution(s);
        }
    }

    @Test
    void testSolution(){
        int[][] routes = {{}};
        int answer =0;
        Solution s = Solution.builder().routes(routes).answer(answer).build();
    }
}

