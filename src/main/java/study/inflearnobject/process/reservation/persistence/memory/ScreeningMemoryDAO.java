package study.inflearnobject.process.reservation.persistence.memory;

import study.inflearnobject.process.reservation.domain.Screening;
import study.inflearnobject.process.reservation.persistence.ScreeningDAO;

public class ScreeningMemoryDAO extends InMemoryDAO<Screening> implements ScreeningDAO {
    @Override
    public Screening selectScreening(Long id) {
        return findOne(screening -> screening.getId().equals(id));
    }

}
