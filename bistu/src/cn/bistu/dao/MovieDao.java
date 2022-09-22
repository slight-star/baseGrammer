package cn.bistu.dao;

import com.sample.Movie;

import java.util.List;
import java.util.Map;

/**
 * @author dfx
 */
public interface MovieDao {
    List findYearBoxoffice();
    List findDangqiBoxoffice(int year);
    List findMovieCount();
    List findMovieTop(int year);
    List findTypeTop();

    List findMovieList();

    int findMovieTotalCount();

    List<com.sample.Movie> findMovieByPage(int start, int rows, Map<String, String[]> conditions);

    void addMovie(com.sample.Movie movie);

    void delMovie(int movieId);

    void updateMovieCount(int count);

    com.sample.Movie findMovie(int movieId);

    void updateMovie(Movie movie);

    int findMovieCountByConditions(Map<String, String[]> conditions);
}
