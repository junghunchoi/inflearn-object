package study.inflearnobject.process.reservation.persistence;

import study.inflearnobject.process.reservation.domain.Screening;

public interface ScreeningDAO {
    Screening selectScreening(Long screeningId);

    void insert(Screening screening);
}
