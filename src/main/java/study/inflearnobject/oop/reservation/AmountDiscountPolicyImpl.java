package study.inflearnobject.oop.reservation;

import study.inflearnobject.oop.generic.Money;

import java.util.List;

public class AmountDiscountPolicyImpl extends DiscountPolicy {
    public AmountDiscountPolicyImpl(List<DiscountCondition> conditions) {
        super(conditions);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return null;
    }
}
