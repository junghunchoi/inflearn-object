package study.inflearnobject.oop.eternity.reservation;

import study.inflearnobject.oop.eternity.generic.Money;

public class Movie {
    private Money fee;

    private DiscountPolicy discountPolicy;

    public Movie(Money fee, DiscountPolicy discountPolicy) {
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money calculateFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscount(screening));
    }

    public Money getFee() {
        return fee;
    }
}
