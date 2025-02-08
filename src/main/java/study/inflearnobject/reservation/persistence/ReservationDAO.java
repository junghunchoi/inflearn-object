package study.inflearnobject.reservation.persistence;

import study.inflearnobject.reservation.domain.Reservation;

public interface ReservationDAO {
    void insert(Reservation reservation);
}
