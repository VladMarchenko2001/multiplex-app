package multiplex.service.impl;

import multiplex.dao.MovieDao;
import multiplex.exception.DataProcessingException;
import multiplex.model.Movie;
import multiplex.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        return movieDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get movie by id " + id));
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
