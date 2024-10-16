package lotto.game;

import lotto.number.LottoBalls;

import java.util.List;
import java.util.stream.Collectors;

public class TestLottoMachine implements LottoMachine {
    private final List<LottoBalls> fixedBalls;

    public TestLottoMachine(List<LottoBalls> fixedBalls) {
        this.fixedBalls = fixedBalls;
    }
    public static TestLottoMachine fromBallSet(List<Integer> number) {
        return new TestLottoMachine(List.of(new LottoBalls(number)));
    }
    public static TestLottoMachine fromBallSets(List<List<Integer>> numbers) {
        return new TestLottoMachine(numbers.stream()
                .map(LottoBalls::new)
                .collect(Collectors.toUnmodifiableList()));
    }

    @Override
    public List<LottoBalls> generateLottoTicket() {
        return fixedBalls;
    }
}
