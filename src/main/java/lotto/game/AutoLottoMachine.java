package lotto.game;

import lotto.number.LottoBalls;
import lotto.strategy.AutoLottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class AutoLottoMachine implements LottoMachine {
    private final LottoCount autoCount;

    public AutoLottoMachine(LottoCount autoCount) {
        this.autoCount = autoCount;
    }

    @Override
    public List<LottoBalls> generateLottoTicket() {
        List<LottoBalls> lottoTickets = new ArrayList<>();

        for (int i = 0; i < autoCount.getValue(); i++) {
            lottoTickets.add(new LottoBalls(new AutoLottoNumberStrategy().generate()));
        }
        return lottoTickets;
    }
}
