package study.inflearnobject.process.reservation.persistence.memory;


import study.inflearnobject.process.reservation.domain.Reservation;
import study.inflearnobject.process.reservation.persistence.ReservationDAO;

public class ReservationMemoryDAO extends InMemoryDAO<Reservation> implements ReservationDAO {
    @Override
    public void insert(Reservation reservation) {
        super.insert(reservation);
    }
}
