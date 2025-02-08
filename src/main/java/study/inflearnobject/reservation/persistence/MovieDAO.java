package study.inflearnobject.reservation.persistence;

import study.inflearnobject.reservation.domain.Movie;

public interface MovieDAO {
    Movie selectMovie(Long movieId);

    void insert(Movie movie);
}
