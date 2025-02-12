package study.inflearnobject.oop.reservation;

import study.inflearnobject.oop.generic.Money;

public class Movie {
    private Long id;
    private String title;
    private Money fee;

    public Movie(Long id, String title, Money fee, DiscountPolicy discountPolicy) {
        this.id = id;
        this.title = title;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    private DiscountPolicy discountPolicy;

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public Money getFee() {
        return fee;
    }
}
