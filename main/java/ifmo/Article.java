package ifmo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by Богдана on 11.11.2017.
 */
@Entity
public class Article {
    private int idArticle;
    private String body;
    private String name;
    private Timestamp dateAdd;
    private Human author;
    private Set<CommentOnArticle> comments;
    public Article(){}
    public Article(int id,String name, String body, Timestamp dateAdd,Human author){
        this.name = name;
        this.body = body;
        this.dateAdd=dateAdd;
        this.author =author;
        this.idArticle=id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "artGen")
    @SequenceGenerator(name = "artGen", sequenceName = "article_id_article_seq")
    @Column(name = "id_article", nullable = false)
    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    @Basic
    @Column(name = "body", nullable = false, length = -1)
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "date_add", nullable = false)
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

        Article article = (Article) o;

        if (idArticle != article.idArticle) return false;
        if (body != null ? !body.equals(article.body) : article.body != null) return false;
        if (name != null ? !name.equals(article.name) : article.name != null) return false;
        if (dateAdd != null ? !dateAdd.equals(article.dateAdd) : article.dateAdd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idArticle;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateAdd != null ? dateAdd.hashCode() : 0);
        return result;
    }
    @ManyToOne
    @JoinColumn(name ="author", referencedColumnName = "id_human", nullable = false)
    public Human getAuthor(){return author;}
    public void setAuthor(Human author){this.author = author;}
    @OneToMany (mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    public Set<CommentOnArticle> getComments(){return  comments;}
    public void setComments(Set<CommentOnArticle> comments){this.comments = comments;}
}
