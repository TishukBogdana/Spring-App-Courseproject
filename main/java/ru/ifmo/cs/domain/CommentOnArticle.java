package ru.ifmo.cs.domain;

import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Богдана on 07.12.2017.
 */
@Entity
@Table(name = "comment_on_article")
public class CommentOnArticle {
    private int id;
    private String content;
    private Timestamp dateAdd;

   private Article article;
    @Id
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
    @JoinColumn(name = "article", referencedColumnName = "id_article" , nullable = false)
    public Article getArticle(){
        return article;
    }
    public void setArticle(Article article){
        this.article=article;
    }


}
