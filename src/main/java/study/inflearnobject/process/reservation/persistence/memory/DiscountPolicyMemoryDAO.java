package study.inflearnobject.process.reservation.persistence.memory;


import study.inflearnobject.process.reservation.domain.DiscountPolicy;
import study.inflearnobject.process.reservation.persistence.DiscountPolicyDAO;

public class DiscountPolicyMemoryDAO extends InMemoryDAO<DiscountPolicy> implements DiscountPolicyDAO {
    @Override
    public DiscountPolicy selectDiscountPolicy(Long movieId) {
        return findOne(policy -> policy.getMovieId().equals(movieId));
    }
}
