package logic;

import ifmo.CommentOnTVSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Богдана on 04.12.2017.
 */
@RestController
public class CommentController {
    @Autowired
    private static CommentOnTVSeriesService service;

}
