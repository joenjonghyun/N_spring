package kr.co.patternbot.common._greedy;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

//그리디 내가
public class 구명보트 {
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Solution{ }
    @FunctionalInterface
    public interface SolutionService {구명보트.Solution solution(구명보트.Solution s);}
    @Test
    void testSolution(){}
}
