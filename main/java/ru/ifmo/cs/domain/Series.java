package ru.ifmo.cs.domain;

import lombok.*;
import ru.ifmo.cs.domain.CommentOnSeries;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Богдана on 11.11.2017.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sergen")
    @SequenceGenerator(name="sergen",sequenceName = "series_id_series_seq")
    @Column(name = "id_series", nullable = false)
    private int idSeries;

    @Basic
    @Column(name = "plot", nullable = false, length = -1)
    private String plot;

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "series", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<CommentOnSeries> comments;

}
