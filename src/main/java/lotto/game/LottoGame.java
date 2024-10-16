package lotto.game;


import lotto.number.LottoBalls;
import lotto.number.LottoNumber;
import lotto.number.WinningNumbers;
import lotto.prize.PrizeCountMap;
import lotto.prize.PrizeCounter;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {

        Money amount = inputView.getAmountFromUser();
        LottoCount totalLottoCount = new LottoCount(amount.divideByLottoPrice());

        List<LottoBalls> lottoTickets = new ArrayList<>();

        LottoCount manualLottoCount = inputView.getManualLottoCountFromUser();
        Money amountAfterBuyingManualLotto = amount.buyLotto(manualLottoCount);

        ManualLottoMachine manualLottoMachine = new ManualLottoMachine(inputView.getManualLottoNumbers(manualLottoCount));
        lottoTickets.addAll(manualLottoMachine.generateLottoTicket());

        LottoCount autoLottoCount = new LottoCount(totalLottoCount.getValue() - manualLottoCount.getValue());
        amountAfterBuyingManualLotto.buyLotto(autoLottoCount);


        AutoLottoMachine autoLottoMachine = new AutoLottoMachine(autoLottoCount);
        lottoTickets.addAll(autoLottoMachine.generateLottoTicket());

        List<Integer> winningNumbersFromUser = inputView.getWinningNumbersFromUser();
        Integer bonusNumberFromUser = inputView.getBonusNumberFromUser();
        WinningNumbers winningNumbers = new WinningNumbers(new LottoBalls(winningNumbersFromUser), new LottoNumber(bonusNumberFromUser));

        PrizeCounter prizeCounter = new PrizeCounter(lottoTickets, winningNumbers);
        PrizeCountMap prizeCountMap = prizeCounter.countPrize();

        resultView.showLottoTickets(lottoTickets);
        resultView.showLottoResult(prizeCountMap);
        resultView.showLottoProfit(prizeCountMap.calculateProfitRate(new LottoCount(lottoTickets.size())));
    }

}
