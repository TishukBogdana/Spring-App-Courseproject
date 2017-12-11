package ru.ifmo.cs.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Богдана on 10.12.2017.
 */
@Entity
public class News {
    private int idNews;
    private String body;
    private String name;
    private Timestamp dateAdd;
    private Boolean moderated;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "news_id_news_seq")
    @Column(name = "id_news", nullable = false)
    public int getIdNews() {
        return idNews;
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
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

    @Basic
    @Column(name = "moderated", nullable = true)
    public Boolean getModerated() {
        return moderated;
    }

    public void setModerated(Boolean moderated) {
        this.moderated = moderated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (idNews != news.idNews) return false;
        if (body != null ? !body.equals(news.body) : news.body != null) return false;
        if (name != null ? !name.equals(news.name) : news.name != null) return false;
        if (dateAdd != null ? !dateAdd.equals(news.dateAdd) : news.dateAdd != null) return false;
        if (moderated != null ? !moderated.equals(news.moderated) : news.moderated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNews;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateAdd != null ? dateAdd.hashCode() : 0);
        result = 31 * result + (moderated != null ? moderated.hashCode() : 0);
        return result;
    }
}
