package study.inflearnobject.reservation.persistence.memory;

import study.inflearnobject.reservation.domain.DiscountCondition;
import study.inflearnobject.reservation.persistence.DiscountConditionDAO;

import java.util.List;

public class DiscountConditionMemoryDAO extends InMemoryDAO<DiscountCondition> implements DiscountConditionDAO {
    @Override
    public List<DiscountCondition> selectDiscountConditions(Long policyId) {
        return findMany(condition -> condition.getPolicyId().equals(policyId));
    }
}
