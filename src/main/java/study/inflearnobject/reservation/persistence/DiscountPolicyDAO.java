package study.inflearnobject.reservation.persistence;

import study.inflearnobject.reservation.domain.DiscountPolicy;

public interface DiscountPolicyDAO {
    DiscountPolicy selectDiscountPolicy(Long movieId);

    void insert(DiscountPolicy discountPolicy);
}
