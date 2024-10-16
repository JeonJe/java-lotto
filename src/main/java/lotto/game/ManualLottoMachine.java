package lotto.game;

import lotto.number.LottoBalls;
import lotto.strategy.ManualLottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoMachine implements LottoMachine {
    private final List<List<Integer>> manualLottoNumbers;

    public ManualLottoMachine(List<List<Integer>> manualLottoNumbers) {
        this.manualLottoNumbers = manualLottoNumbers;
    }

    @Override
    public List<LottoBalls> generateLottoTicket() {
        List<LottoBalls> lottoTickets = new ArrayList<>();

        for (List<Integer> manualLottoNumber : manualLottoNumbers) {
            lottoTickets.add(new LottoBalls(new ManualLottoNumberStrategy(manualLottoNumber).generate()));

        }

        return lottoTickets;
    }
}
