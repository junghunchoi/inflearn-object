package study.inflearnobject.oop.eternity.reservation;

import study.inflearnobject.oop.eternity.generic.Money;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
