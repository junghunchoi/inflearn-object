package study.inflearnobject.oop.reservation;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
