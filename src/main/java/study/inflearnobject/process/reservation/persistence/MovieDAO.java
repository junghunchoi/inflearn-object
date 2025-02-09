package study.inflearnobject.process.reservation.persistence;

import study.inflearnobject.process.reservation.domain.Movie;

public interface MovieDAO {
    Movie selectMovie(Long movieId);

    void insert(Movie movie);
}
