package study.inflearnobject.oop.reservation;

import org.springframework.cglib.core.Local;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PeriodDiscountConditionImpl implements DiscountCondition {

    private LocalTime startTime;
    private LocalTime endTime;
    private DayOfWeek dayOfWeek;

    // 특정기간인 경우 할인여부판단
    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek)
                && startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0
                && endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }
}
