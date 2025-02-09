package study.inflearnobject.oop.reservation;

import study.inflearnobject.oop.generic.Money;
import study.inflearnobject.process.reservation.domain.DiscountCondition;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Reservation reserve(Customer customer, int audienceCount) {
        Money fee = movie.calculateMovieFee(this).times(audienceCount);
        return new Reservation(customer, this, audienceCount, fee);
    }

    public Money getFixedFee() {
        return movie.getFee();
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }
}
