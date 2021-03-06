package ru.ifmo.cs.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Богдана on 10.12.2017.
 */
@Entity
//@Table(name = "article" , schema = "s225081")
public class Article {
    private int idArticle;
    private String body;
    private String name;
    private Timestamp dateAdd;
    private Boolean moderated;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "article_id_article_seq1")
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

        Article article = (Article) o;

        if (idArticle != article.idArticle) return false;
        if (body != null ? !body.equals(article.body) : article.body != null) return false;
        if (name != null ? !name.equals(article.name) : article.name != null) return false;
        if (dateAdd != null ? !dateAdd.equals(article.dateAdd) : article.dateAdd != null) return false;
        if (moderated != null ? !moderated.equals(article.moderated) : article.moderated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idArticle;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateAdd != null ? dateAdd.hashCode() : 0);
        result = 31 * result + (moderated != null ? moderated.hashCode() : 0);
        return result;
    }
}
