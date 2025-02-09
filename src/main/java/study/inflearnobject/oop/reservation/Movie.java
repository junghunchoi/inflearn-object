package study.inflearnobject.oop.reservation;

import study.inflearnobject.oop.generic.Money;

public class Movie {
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public Money getFee() {
        return fee;
    }
}
