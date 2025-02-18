package study.inflearnobject.eternity;

import org.junit.jupiter.api.Test;
import study.inflearnobject.oop.eternity.generic.Money;
import study.inflearnobject.oop.eternity.reservation.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EterniryTest {
    @Test
    public void 비율할인정책_계산하기() {
        // given
        Movie movie = new Movie(
                Money.wons(10_000L),
                new PercentDiscountPolicy(
                        0.1,
                        new SequenceDiscountCondition(1),
                        new SequenceDiscountCondition(3),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 10))));

        Screening screening = new Screening(movie, 1, LocalDateTime.of(2024, 12, 11, 18, 0));

        // when
        Money fee = movie.calculateFee(screening);

        // then
        assertEquals(Money.wons(9000L), fee);
    }
    @Test
    public void 금액할인정책_계산하기() {
        // given
        Movie movie = new Movie(
                Money.wons(10_000L),
                new AmountDiscountPolicy(
                        Money.wons(1000L),
                        new SequenceDiscountCondition(1),
                        new SequenceDiscountCondition(3),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 10))));

        Screening screening = new Screening(movie, 1, LocalDateTime.of(2024,12,11, 18, 0));

        // when
        Money fee = movie.calculateFee(screening);

        // then
        assertEquals(Money.wons(9000L), fee);
    }

    @Test
    public void 비할인정책_계산하기() {
        // given
        Movie movie = new Movie(
                Money.wons(10_000L),
                new NoneDiscountPolicy());

        Screening screening = new Screening(movie, 1, LocalDateTime.of(2024,12,11, 18, 0));

        // when
        Money fee = movie.calculateFee(screening);

        // then
        assertEquals(Money.wons(10000L), fee);
    }
}
