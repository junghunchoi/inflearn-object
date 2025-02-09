package study.inflearnobject.process.reservation.persistence.memory;

import study.inflearnobject.process.reservation.domain.Movie;
import study.inflearnobject.process.reservation.persistence.MovieDAO;

public class MovieMemoryDAO extends InMemoryDAO<Movie> implements MovieDAO {
    @Override
    public Movie selectMovie(Long movieId) {
        return findOne(movie -> movie.getId().equals(movieId));
    }
}
