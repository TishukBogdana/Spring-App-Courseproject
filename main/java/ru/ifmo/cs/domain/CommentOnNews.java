package ru.ifmo.cs.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Богдана on 07.12.2017.
 */
@Entity
@Table(name = "comment_on_news")
public class CommentOnNews {
    private int id;
    private String content;
    private Timestamp dateAdd;

    private News news;
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

        CommentOnNews that = (CommentOnNews) o;

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
    @JoinColumn(name = "news", referencedColumnName = "id_news" , nullable = false)
    public News getNews(){
        return news;
    }
    public void setNews(News news){
        this.news = news;
    }

}