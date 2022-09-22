package cn.bistu.service;

import cn.bistu.domain.PageBean;
import com.sample.Movie;

import java.util.List;
import java.util.Map;

/**
 * @author dfx
 */
public interface MovieService {
    public List findMovieList();

//    PageBean<Movie> findMovieByPage(PageBean<Movie> pb);

    PageBean<com.sample.Movie> findMovieByPage(String currentPage, String rows, Map<String, String[]> conditions);

    void addMovie(Movie movie);

    int findMovieCount();

    void delMovie(int movieId);

    Movie findMovie(int movieId);

    void updateMovie(Movie movie);

    void delSelectedMovie(String[] movieIds);
}
