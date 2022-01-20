package multiplex.dao.impl;

import multiplex.dao.AbstractDao;
import multiplex.dao.MovieDao;
import multiplex.model.Movie;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl extends AbstractDao<Movie> implements MovieDao {
    public MovieDaoImpl(SessionFactory factory) {
        super(factory, Movie.class);
    }
}
