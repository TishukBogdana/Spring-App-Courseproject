package ifmo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by Богдана on 11.11.2017.
 */
@Entity
@Table(name = "comment_on_article")
public class CommentOnArticle {
    private int id;
    private String content;
    private Timestamp dateAdd;
    private Article article;
    private CommentOnArticle onComment;
    private Human author;
    Set<CommentOnArticle> comments;
    public CommentOnArticle(){}
    public CommentOnArticle(int id,String content, Timestamp dateAdd, Article article, CommentOnArticle onComment,Human author){
        this.content = content;
        this.dateAdd =dateAdd;
        this.article = article;
        this.onComment=onComment;
        this.author =author;
        this.id=id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cart")
    @SequenceGenerator(name = "cart", sequenceName = "comment_on_article_id_seq")
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

        CommentOnArticle that = (CommentOnArticle) o;

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
    @JoinColumn(name = "article", referencedColumnName = "id_article", nullable = false)
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @ManyToOne
    @JoinColumn(name = "on_comment", referencedColumnName = "id")
    public CommentOnArticle getOnComment() {
        return onComment;
    }

    public void setOnComment(CommentOnArticle onComment) {
        this.onComment = onComment;
    }
    @ManyToOne
    @JoinColumn (name = "author", referencedColumnName = "id_human", nullable = false)
    public Human getAuthor(){return author;};
    public  void setAuthor(Human author){this.author =  author;}
   /* @OneToMany(mappedBy = "on_comment", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    public Set<CommentOnArticle>  getComments(){
        return comments;
    }
    public void  setComments(Set<CommentOnArticle> comments){
        this.comments = comments;
    }*/
   //todo fix One_to_many in all comments
}
