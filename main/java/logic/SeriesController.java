package logic;

import ifmo.Series;
import ifmo.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Богдана on 04.12.2017.
 */
@RestController
public class SeriesController {
    @Autowired
    private  SeriesService service;
    @RequestMapping("/series/upd")
    public void updateSeries(@RequestParam(value = "name") String name, @RequestParam(value = "plot") String plot, @RequestParam(value = "prevname") String prevname){
        service.updateSeries(name,plot,prevname);
    }
    ///delete!
    @RequestMapping("/series/add")
    public void addSeria(@RequestParam(value = "name") String name, @RequestParam(value = "plot") String plot){
        Series series = new Series();
        series.setPlot(plot);
        series.setName(name);
        service.save(series);
    }
@RequestMapping("/series/rembyname")
    public  void removeByName(@RequestParam(value = "name") String name){
        service.removeByName(name);
    }
    @RequestMapping("/series/getbyname")
    public List<Series> findByName(@RequestParam(value = "name") String name){
        return service.findByName(name);
    }
    @RequestMapping("/series/findone")
    public Series findOne(int id){
        return service.findOne(id);
    }
    @RequestMapping("/series/findall")
    public Iterable<Series> findAll(){
        return service.findAll();
    }
}
