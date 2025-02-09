package study.inflearnobject.process.reservation.domain;

import study.inflearnobject.process.generic.TimeInterval;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
    public enum ConditionType { PERIOD_CONDITION, SEQUENCE_CONDITION, COMBINED_CONTIDTION }

    private Long id;
    private Long policyId;
    private ConditionType conditionType;
    private DayOfWeek dayOfWeek;
    private TimeInterval interval;
    private Integer sequence;

    public DiscountCondition() {
    }

    public DiscountCondition(Long policyId, ConditionType conditionType, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime, Integer sequence) {
        this(null, policyId, conditionType, dayOfWeek, startTime, endTime, sequence);
    }

    public DiscountCondition(Long id, Long policyId, ConditionType conditionType, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime, Integer sequence) {
        this.id = id;
        this.policyId = policyId;
        this.conditionType = conditionType;
        this.dayOfWeek = dayOfWeek;
        this.interval = interval;
        this.sequence = sequence;
    }

    // 조건이 추가
    public boolean isSatisfiedBy(Screening screening) {
        if (isPeriodCondition()) {
            if (screening.isPlayedIn(dayOfWeek, interval.getStartTime(), interval.getEndTime())) {
                return true;
            }
        } else if (isSequenceCondition()){
            if (sequence.equals(screening.getSequence())) {
                return true;
            }
        } else if (isCombinedCondition()) {
            if (screening.isPlayedIn(dayOfWeek, interval.getStartTime(), interval.getEndTime()) &&
                    sequence.equals(screening.getSequence())) {
                return true;
            }
        }

        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public boolean isPeriodCondition() {
        return ConditionType.PERIOD_CONDITION.equals(conditionType);
    }

    public boolean isSequenceCondition() {
        return ConditionType.SEQUENCE_CONDITION.equals(conditionType);
    }

    public boolean isCombinedCondition() {
        return ConditionType.COMBINED_CONTIDTION.equals(conditionType);
    }

    public ConditionType getConditionType() {
        return conditionType;
    }

    public void setConditionType(ConditionType conditionType) {
        this.conditionType = conditionType;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public TimeInterval getInterval() {
        return interval;
    }

    public void setInterval(TimeInterval interval) {
        this.interval = interval;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}
