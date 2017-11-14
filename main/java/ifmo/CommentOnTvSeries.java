package ifmo;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Богдана on 11.11.2017.
 */
@Entity
@Table(name = "comment_on_tv_series")
public class CommentOnTvSeries {
    private int id;
    private String content;
    private Timestamp dateAdd;
    private CommentOnTvSeries commentOnTvSeriesByOnComment;
    private Human author ;
  public CommentOnTvSeries(){}
    public CommentOnTvSeries(int id, String content, Timestamp dateAdd,  CommentOnTvSeries onComment,Human author){
        this.content = content;
        this.dateAdd =dateAdd;
        this.commentOnTvSeriesByOnComment=onComment;
        this.author =author;
        this.id =id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ctvs")
    @SequenceGenerator(name = "ctvs", sequenceName = "comment_on_tv_series_id_seq")
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 512)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "date_add", nullable = true)
    public Timestamp getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Timestamp dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentOnTvSeries that = (CommentOnTvSeries) o;

        if (id != that.id) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (dateAdd != null ? !dateAdd.equals(that.dateAdd) : that.dateAdd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (dateAdd != null ? dateAdd.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "on_comment", referencedColumnName = "id")
    public CommentOnTvSeries getCommentOnTvSeriesByOnComment() {
        return commentOnTvSeriesByOnComment;
    }

    public void setCommentOnTvSeriesByOnComment(CommentOnTvSeries commentOnTvSeriesByOnComment) {
        this.commentOnTvSeriesByOnComment = commentOnTvSeriesByOnComment;
    }
    @ManyToOne
    @JoinColumn (name = "author", referencedColumnName = "id_human", nullable = false)
    public Human getAuthor(){return author;};
    public  void setAuthor(Human author){this.author =  author;}
}
