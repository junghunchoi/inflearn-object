package study.inflearnobject.reservation.persistence.memory;


import study.inflearnobject.reservation.domain.Reservation;
import study.inflearnobject.reservation.persistence.ReservationDAO;

public class ReservationMemoryDAO extends InMemoryDAO<Reservation> implements ReservationDAO {
    @Override
    public void insert(Reservation reservation) {
        super.insert(reservation);
    }
}
