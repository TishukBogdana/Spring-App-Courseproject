package ifmo;

import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface SeriesService {
    List<Series> findByName(String name);
    void removeByName(String name);
    Iterable<Series> findAll();
    Series findOne(int id);
    void save(Series series);
    void delete (Series series);
    void updateSeries(String name, String descr, String prevName);
}
