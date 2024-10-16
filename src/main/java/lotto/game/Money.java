package lotto.game;

import lotto.exception.LottoIllegalArgumentException;

import java.util.Objects;


public class Money {
    public static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    private final int value;

    public Money(int value) {
        if(value < ZERO) {
            throw LottoIllegalArgumentException.NEGATIVE_AMOUNT;
        }
        this.value = value;
    }

    public int divideByLottoPrice() {
        return value / LOTTO_PRICE;
    }

    public Money buyLotto(LottoCount count){
        if(value - (LOTTO_PRICE * count.getValue()) < 0) {
            throw LottoIllegalArgumentException.INVALID_MANUAL_LOTTO_COUNT;
        }
        return new Money(value - (LOTTO_PRICE * count.getValue()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
