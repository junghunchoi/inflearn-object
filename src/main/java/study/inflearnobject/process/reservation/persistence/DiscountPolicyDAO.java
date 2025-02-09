package study.inflearnobject.process.reservation.persistence;

import study.inflearnobject.process.reservation.domain.DiscountPolicy;

public interface DiscountPolicyDAO {
    DiscountPolicy selectDiscountPolicy(Long movieId);

    void insert(DiscountPolicy discountPolicy);
}
