package study.inflearnobject.oop.reservation;

import study.inflearnobject.oop.generic.Money;

import java.util.List;

public class PercentDiscountPolicyImpl extends DiscountPolicy {
    private Double percent;

    public PercentDiscountPolicyImpl(List<DiscountCondition> conditions) {
        super(conditions);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {

        return screening.getFixedFee().times(percent);
    }
}
