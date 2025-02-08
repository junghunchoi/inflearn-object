package study.inflearnobject.reservation.persistence;

import study.inflearnobject.reservation.domain.Screening;

public interface ScreeningDAO {
    Screening selectScreening(Long screeningId);

    void insert(Screening screening);
}
