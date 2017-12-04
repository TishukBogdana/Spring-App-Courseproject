package logic;

import com.sun.istack.internal.Nullable;
import ifmo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;


/**
 * Created by Богдана on 04.12.2017.
 */
@RestController
public class CommentOnSeriesController {
    @Autowired
    private CommentOnSeriesService service;
    @Autowired
    private SeriesService sService;
    @Autowired
    private HumanService hService;
    @RequestMapping("/sercom/getall")
    public Iterable<CommentOnSeries> findAll(){
        return service.findAll();
    }
    @RequestMapping("/sercom/getbyser")
    public List<CommentOnSeries> finfBySeries(@RequestParam(value = "seria") int id_seria){
        Series seria = sService.findOne(id_seria);
        return service.findBySeries(seria);
    }
    @RequestMapping("/sercom/getbyauth")
    public List<CommentOnSeries> findByAuthor(@RequestParam(value = "author") String login){
        Human author =  hService.findByLogin(login).get(0);
        return service.findByAuthor(author);
    }
    @RequestMapping("/sercom/rembyser")
    public void removeBySeries(@RequestParam(value = "seria") int id_seria){
        Series seria = sService.findOne(id_seria);
        service.removeBySeries(seria);
    }
    @RequestMapping("/sercom/rembyauth")
    public void removeByAuthor(@RequestParam(value = "author") String login){
        Human author =  hService.findByLogin(login).get(0);
         service.removeByAuthor(author);
    }
    @RequestMapping("/sercom/upd")
    public void update(@RequestParam(value = "id") int id, @RequestParam(value = "content") String content){
        service.updateComment(content, new Timestamp(System.currentTimeMillis()), id);
    }
    @RequestMapping("/sercom/add")
    public void add(@Nullable @RequestParam(value = "reply") int id_com, @RequestParam(value = "author") String login, @RequestParam(value = "news") int id_series, @RequestParam(value = "content") String content){
        CommentOnSeries comment  = new CommentOnSeries();
        Human author  = hService.findByLogin(login).get(0);
        Series series = sService.findOne(id_series);
        CommentOnSeries reply = service.findOne(id_com);
        comment.setAuthor(author);
        comment.setSeries(series);
        comment.setCommentOnSeriesByOnComment(reply);
        comment.setContent(content);
        comment.setDateAdd( new Timestamp(System.currentTimeMillis()));
        service.save(comment);
    }
}
