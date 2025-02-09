package study.inflearnobject.process.reservation.persistence;



import study.inflearnobject.process.reservation.domain.DiscountCondition;

import java.util.List;

public interface DiscountConditionDAO {
    List<DiscountCondition> selectDiscountConditions(Long policyId);

    void insert(DiscountCondition discountCondition);
}
