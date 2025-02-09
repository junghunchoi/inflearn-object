package study.inflearnobject.oop.reservation;

import study.inflearnobject.oop.generic.Money;

public class PercentDiscountPolicyImpl extends DiscountPolicy {
    private Double percent;
    @Override
    protected Money getDiscountAmount(Screening screening) {

        return screening.getFixedFee().times(percent);
    }
}
