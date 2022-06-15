package kr.co.patternbot.common._hash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * 기본 틀 만들 때 여기를 참고
 * participant	completion	return
 * ["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
 * ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
 * ["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
 * */
//이거할거임

public class 완주하지못한선수 {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Solution {
        private String [] participant,completion;
        private String answer;

        @Override
        public String toString(){
            return String.format("완주하지 못한 선수 :%d", answer);
        }
    }

    @FunctionalInterface private interface SolutionService<T,R>{
        R solution(T t);
    }
    static class Service{
        Solution test(Solution s){
            SolutionService<Solution, Solution> f = e -> {
                e.answer = "";
                HashMap<String, Integer> map = new HashMap<>();
                for (String st: e.participant) {
                    if(map.get(st) == null){
                        map.put(st, 1);
                    } else {
                        map.put(st, map.get(st)+1);
                    }
                }

                for (String st : e.completion){
                    if(map.get(st) != 0) {
                        map.put(st, map.get(st)-1);
                    }
                }

                for (String key : map.keySet()){
                    if (map.get(key) !=0 ) {

                    }
                }
                return Solution.builder()
                        .participant(e.getParticipant())
                        .completion(e.getCompletion())
                        .answer(e.answer)
                        .build();
            };
            return f.solution(s);

        }

    }

    @Test
    void testSolutionTest(){
        String[] participant1 ={"leo", "kiki", "eden"};
        String[] completion1 ={"eden", "kiki"};
        String[] participant2 ={"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 ={"josipa", "filipa", "marina", "nikola"};
        String[] participant3 ={"mislav", "stanko", "mislav", "ana"};
        String[] completion3 ={"stanko", "ana", "mislav"};

        Solution s1 = Solution.builder()
                .participant(participant1)
                .completion(completion1)
                .build();
        Solution s2 = Solution.builder()
                .participant(participant2)
                .completion(completion2)
                .build();
        Solution s3 = Solution.builder()
                .participant(participant3)
                .completion(completion3)
                .build();
        System.out.println(new Service().test(s1));
        System.out.println(new Service().test(s2));
        System.out.println(new Service().test(s3));

    }
}
