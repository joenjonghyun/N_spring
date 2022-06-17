package kr.co.patternbot.common._sort;

import lombok.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * packageName: com.toomuchcoder.api.common._sort
 * fileName        : BubbleSort.java
 * author          : solyikwon
 * date            : 2022-05-24
 * desc            :
 * 버블 정렬은 옆에 있는 데이터와 비교하여 더 작은 값을 앞으로 보내는 정렬입니다.
 * 1   9   4   6   11   10   3   15   2   13
 * 위와 같은 수가 있을 때 수들을 오름차순하는 버블 정렬을 해보겠습니다.
 * 먼저 배열의 맨 앞부터 두 수씩 비교합니다. 1과 9를 비교하여 1이 더 작으므로 1을 정렬합니다.
 * 그 다음 9와 4를 비교하여 4가 더 작으므로 9와 4의 위치를 교환하고 4를 정렬합니다.
 * 그 다음 9와 6을 비교하여 6이 더 작으므로 9와 6의 위치를 교환하고 6를 정렬합니다.
 * 그 다음 9와 6을 비교하여 6이 더 작으므로 9와 6의 위치를 교환하고 6를 정렬합니다.
 * 1   9   4   6   11   10   3   15   2   13
 * 1   4   9   6   11   10   3   15   2   13
 * 1   4   6   9   11   10   3   15   2   13
 * 1   4   6   9   11   10   3   15   2   13
 * . . .
 * 1   4   6   9   10   3   11   2   13   15
 * 위와 같은 방식으로 1차 버블 정렬을 끝나면 가장 큰 수인 15의 정렬이 확정됩니다. 이후 정렬이 확정된 데이터를 제외한 나머지 배열에서 2차 버블 정렬을 수행합니다
 * 1   4   6   9   10   3   11   2   13   15
 * 1   4   6   9   3   10   2   11   13   15
 * 2차 버블 정렬이 끝나면 가장 큰 수인 13의 정렬이 확정됩니다. 이러한 방식으로 1차, 2차, 3차 . . . 반복하여 정렬하는 방식이 버블 정렬입니다.
 * https://devbirdfeet.tistory.com/99?category=845027
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-05-24         solyikwon      최초 생성
 **/
public class 버블정렬 {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Solution {
        private int[] array;
        private int temp;

        public String toString() {
            return Arrays.toString(array);
        }
    }

    @FunctionalInterface
    private interface SolutionService {
        Solution solutionServiceApply(Solution solutionParam);
    }

    class Service {
        Solution test(Solution solutionParamTest) {
            SolutionService f = e -> {
                for (int i = 0; i < e.array.length; i++) {
                    for (int j = 0; j < 9-i; j++) {
                        if (e.array[j] > e.array[j + 1]) {
                            e.temp = e.array[j];
                            e.array[j] = e.array[j + 1];
                            e.array[j + 1] = e.temp;
                        }
                    }
                }
                return Solution.builder().array(e.array).build();
            };
            return f.solutionServiceApply(solutionParamTest);
        }
    }
    @Test
    void testSolution() {
        int[] arr = {1, 9, 4, 6, 11, 10, 3, 15, 2, 13};
        Solution solutionInstance = Solution.builder().array(arr).build();
        Service serviceInstance = new Service();
        System.out.println(serviceInstance.test(solutionInstance));
    }
}