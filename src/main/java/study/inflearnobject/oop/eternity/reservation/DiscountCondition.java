package study.inflearnobject.oop.eternity.reservation;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
