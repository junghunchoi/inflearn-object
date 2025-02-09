package study.inflearnobject.process.reservation.persistence;

import study.inflearnobject.process.reservation.domain.Reservation;

public interface ReservationDAO {
    void insert(Reservation reservation);
}
