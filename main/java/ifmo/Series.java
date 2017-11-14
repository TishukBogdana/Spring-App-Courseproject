package ifmo;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Богдана on 11.11.2017.
 */
@Entity
public class Series {
    private int idSeries;
    private String plot;
    private String name;
   private Set<CommentOnSeries> comments;
   public Series(){}
   public Series(int id,String name, String plot){
       this.name =name;
       this.plot=plot;
       this.idSeries=id;
   }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sergen")
    @SequenceGenerator(name="sergen",sequenceName = "series_id_series_seq")
    @Column(name = "id_series", nullable = false)
    public int getIdSeries() {
        return idSeries;
    }

    public void setIdSeries(int idSeries) {
        this.idSeries = idSeries;
    }

    @Basic
    @Column(name = "plot", nullable = false, length = -1)
    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Series series = (Series) o;

        if (idSeries != series.idSeries) return false;
        if (plot != null ? !plot.equals(series.plot) : series.plot != null) return false;
        if (name != null ? !name.equals(series.name) : series.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSeries;
        result = 31 * result + (plot != null ? plot.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
    @OneToMany(mappedBy = "series", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    public Set<CommentOnSeries> getComments(){return comments;}
    public void setComments(Set<CommentOnSeries> comments){this.comments = comments;}
}
