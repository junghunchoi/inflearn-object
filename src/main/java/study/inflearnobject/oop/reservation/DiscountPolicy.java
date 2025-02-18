package study.inflearnobject.oop.reservation;

import study.inflearnobject.oop.generic.Money;

import java.util.List;

/**
 * 할인 정책은 다양한 형태로 존재할 수 있기 때문에 추상 클래스로 정의한다.
 */
public abstract class DiscountPolicy {
    private Long id;
    private List<DiscountCondition> conditions;

    public DiscountPolicy(DiscountCondition ... conditionss) {
        this.conditions = conditions;
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition condition : conditions) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    protected abstract Money getDiscountAmount(Screening screening);
}
