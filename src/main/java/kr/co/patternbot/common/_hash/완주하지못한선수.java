package kr.co.patternbot.common._hash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 기본 틀 만들 때 여기를 참고
 * participant	completion	return
 * ["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
 * ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
 * ["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
 * */
//이거할거임

public class 완주하지못한선수 {
    @Builder @NoArgsConstructor @Getter @AllArgsConstructor
    public static class Solution{
        //속성
        private String[] participant;
        private String[] completion;
        private String answer;

        @Override public String toString(){return String.format("%s, %s, %s",
                Arrays.toString(participant), Arrays.toString(completion), answer);}
    }

    @FunctionalInterface public interface SolutionService{
        Solution solution(Solution s);
    }
    static class Service{
        SolutionService f = e -> {
            e.answer = "";
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (String player : e.participant) hashMap.put(player, hashMap.getOrDefault(player, 0)+1);
            for (String player : e.completion) hashMap.put(player, hashMap.get(player) -1);
            for (String key : hashMap.keySet()){
                if (hashMap.get(key) != 0){
                    e.answer = key;
                }
            }
            return Solution.builder()
                    .answer(e.getAnswer())
                    .completion(e.getCompletion())
                    .participant(e.getParticipant())
                    .build();
        };
        Solution test(Solution s){return f.solution(s);}
    }
    @Test void testSolutionTest(){
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};
        String answer = "";
        Service s1 = new Service();
        Solution s = Solution.builder()
                .participant(participant)
                .completion(completion)
                .answer(answer)
                .build();
        System.out.println(s1.test(s));
    }
}
