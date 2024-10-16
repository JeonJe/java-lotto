package lotto.game;

import lotto.number.LottoBalls;

import java.util.List;

public interface LottoMachine {
    List<LottoBalls> generateLottoTicket();
}
