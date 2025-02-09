package study.inflearnobject.oop.reservation;

public class SequenceDiscountConditionImpl implements DiscountCondition {
    private int sequence;

    // 해당 회차의 할인여부를 판단해야한다.
    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
