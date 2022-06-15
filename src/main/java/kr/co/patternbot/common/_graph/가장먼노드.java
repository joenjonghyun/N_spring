package kr.co.patternbot.common._graph;

//그래프내가
//가장먼노드 ㄱㄱ

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * 입출력 예
 * n	vertex	return
 * 6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3
 * */

public class 가장먼노드 {
    @Getter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class Solution {
        boolean [] n;
        private int [][] edge;

        @Override
        public String toString(){
            return String.format("가장먼노드:");
        }
    }

    @FunctionalInterface private interface SolutionService{
        Solution solution(Solution s);
    }

    @Test void testSolutionTest(){
    }

}
