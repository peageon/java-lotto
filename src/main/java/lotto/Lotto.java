package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> checkDupe = new HashSet<Integer>(numbers);
        if (checkDupe.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 숫자들은 달라야 합니다");
        }
    }

    // TODO: 추가 기능 구현
    public static List<List<Integer>> generateLotto(Integer count) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i=0; i < count; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(lotto);
        }
        return lottos;
    }

    public static void checkBuyAmount(Integer amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위");
        }
    }

}
