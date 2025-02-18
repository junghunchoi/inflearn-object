//package study.inflearnobject.reservation;
//
//import study.inflearnobject.oop.reservation.OverlappedDiscountPolicy;
//import study.inflearnobject.process.generic.Money;
//import study.inflearnobject.process.reservation.domain.*;
//import study.inflearnobject.process.reservation.persistence.*;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import study.inflearnobject.process.reservation.service.ReservationService;
//
//import java.time.DayOfWeek;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.List;
//
//import static java.time.DayOfWeek.MONDAY;
//import static java.time.DayOfWeek.WEDNESDAY;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static study.inflearnobject.process.reservation.domain.DiscountCondition.ConditionType.PERIOD_CONDITION;
//import static study.inflearnobject.process.reservation.domain.DiscountCondition.ConditionType.SEQUENCE_CONDITION;
//import static study.inflearnobject.process.reservation.domain.DiscountPolicy.PolicyType.AMOUNT_POLICY;
//import static study.inflearnobject.process.reservation.domain.DiscountPolicy.PolicyType.PERCENT_POLICY;
//
//@ExtendWith(MockitoExtension.class)
//public class ReservationServiceTest {
//    @Test
//    public void 비율할인정책_계산하기() {
//        // given
//        Movie movie = new Movie(
//                "한산",
//                Money.wons(10_000L),
//                new PercentDiscountPolicy(
//                        0.1,
//                        new SequenceCondition(1),
//                        new SequenceCondition(3),
//                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 10))));
//
//        Screening screening = new Screening(movie, 1, LocalDateTime.of(2024,12,11, 18, 0));
//
//        // when
//        Money fee = movie.calculateFee(screening);
//
//        // then
//        assertEquals(Money.wons(9000L), fee);
//    }
//
//    @Test
//    public void 금액할인정책_계산하기() {
//        // given
//        Movie movie = new Movie(
//                "한산",
//                Money.wons(10_000L),
//                new AmountDiscountPolicy(
//                        Money.wons(1000L),
//                        new SequenceCondition(1),
//                        new SequenceCondition(3),
//                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 10))));
//
//        Screening screening = new Screening(movie, 1, LocalDateTime.of(2024,12,11, 18, 0));
//
//        // when
//        Money fee = movie.calculateFee(screening);
//
//        // then
//        assertEquals(Money.wons(9000L), fee);
//    }
//
//    @Test
//    public void 비할인정책_계산하기() {
//        // given
//        Movie movie = new Movie(
//                "한산",
//                Money.wons(10_000L),
//                new NoneDiscountPolicy());
//
//        Screening screening = new Screening(movie, 1, LocalDateTime.of(2024,12,11, 18, 0));
//
//        // when
//        Money fee = movie.calculateFee(screening);
//
//        // then
//        assertEquals(Money.wons(10000L), fee);
//    }
//
//    @Test
//    public void 중복할인정책_계산하기() {
//        // given
//        Movie movie = new Movie(
//                "한산",
//                Money.wons(10_000L),
//                new OverlappedDiscountPolicy(
//                        new PercentDiscountPolicy(
//                                0.1,
//                                new SequenceCondition(1),
//                                new SequenceCondition(3),
//                                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 10))),
//                        new AmountDiscountPolicy(
//                                Money.wons(1000L),
//                                new SequenceCondition(1),
//                                new SequenceCondition(3),
//                                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 10)))));
//
//        Screening screening = new Screening(movie, 1, LocalDateTime.of(2024,12,11, 18, 0));
//
//        // when
//        Money fee = movie.calculateFee(screening);
//
//        // then
//        assertEquals(Money.wons(8000L), fee);
//    }
//}
