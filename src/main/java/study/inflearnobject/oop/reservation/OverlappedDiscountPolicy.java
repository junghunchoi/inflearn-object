package study.inflearnobject.oop.reservation;

import study.inflearnobject.oop.generic.Money;

import java.util.ArrayList;
import java.util.List;

public class OverlappedDiscountPolicy extends DiscountPolicy{
    private List<DiscountPolicy> policies = new ArrayList<>();

    /**
     * 조건상 할인 정책이 반드시 필요하므로 없을 경ㅇ
     * 항상 true로 반환할 수 있도록 생성자를 정의한다.
     */
    public OverlappedDiscountPolicy(DiscountPolicy ... policies) {
        super(null, screening -> true);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        Money result = Money.ZERO;

        for (DiscountPolicy each : policies) {
            result = result.plus(each.calculateDiscountAmount(screening));
        }

        return result;
    }
}
