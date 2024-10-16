package lotto.game;

import lotto.exception.LottoIllegalArgumentException;
import lotto.number.LottoBalls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    @DisplayName("사용자가 입력한 금액이 원하는 수의 수동 로또를 살 수 없는 금액이면 예외가 발생한다.")
    @Test
    void validateManualLottoCount() {
        assertThatThrownBy(() -> new Money(400).buyLotto(new LottoCount(1)))
                .isInstanceOf(LottoIllegalArgumentException.class);
    }

    @DisplayName("로또 티켓 1개를 만들 수 있다.")
    @Test
    void generateLottoTicket() {
        TestLottoMachine lottoMachine = TestLottoMachine.fromBallSet(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoMachine.generateLottoTicket()).isEqualTo(List.of(new LottoBalls(List.of(1, 2, 3, 4, 5, 6))));
    }

    @DisplayName("자동 번호 로또 티켓 2개를 만들 수 있다.")
    @Test
    void generateAutoLottoTickets() {
        TestLottoMachine lottoMachine = TestLottoMachine.fromBallSets(List.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6)));
        List<LottoBalls> lottoBalls = lottoMachine.generateLottoTicket();
        assertThat(lottoBalls).hasSize(2)
                .isEqualTo(
                        List.of(
                                new LottoBalls(List.of(1, 2, 3, 4, 5, 6)), new LottoBalls(List.of(1, 2, 3, 4, 5, 6))
                        ));
    }

    @DisplayName("수동 번호 로또 티켓 2개를 만들 수 있다.")
    @Test
    void generateManualLottoTickets() {
        ManualLottoMachine lottoMachine = new ManualLottoMachine(List.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6)));
        List<LottoBalls> lottoBalls = lottoMachine.generateLottoTicket();
        assertThat(lottoBalls).hasSize(2)
                .isEqualTo(
                        List.of(
                                new LottoBalls(List.of(1, 2, 3, 4, 5, 6)), new LottoBalls(List.of(1, 2, 3, 4, 5, 6))
                        ));
    }

}
