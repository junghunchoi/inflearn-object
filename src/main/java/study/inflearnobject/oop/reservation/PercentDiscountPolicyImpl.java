package study.inflearnobject.oop.reservation;

import study.inflearnobject.oop.generic.Money;

import java.util.List;

public class PercentDiscountPolicyImpl extends DiscountPolicy {
    private Double percent;

    public PercentDiscountPolicyImpl(DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {

        return screening.getFixedFee().times(percent);
    }
}
