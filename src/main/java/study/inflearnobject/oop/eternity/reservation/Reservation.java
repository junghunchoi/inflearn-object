package study.inflearnobject.oop.eternity.reservation;

import study.inflearnobject.oop.eternity.generic.Money;

public class Reservation {
    private Customer customer;
    private Screening screening;
    private int audienceCount;
    private Money fee;

    public Reservation(Customer customer, Screening screening, int audienceCount, Money fee) {
        this.customer = customer;
        this.screening = screening;
        this.audienceCount = audienceCount;
        this.fee = fee;
    }
}
