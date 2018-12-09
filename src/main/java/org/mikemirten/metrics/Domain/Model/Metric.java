package org.mikemirten.metrics.Domain.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "metrics")
public class Metric
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "metric")
    @JsonIgnore
    private Set<MetricValue> values;

    public Metric()
    {
        values = new HashSet<>();
    }

    public Metric(User user, String title)
    {
        this();

        this.user  = user;
        this.title = title;
    }

    /**
     * Get id
     *
     * @return Integer
     */
    public Integer getId()
    {
        return id;
    }

    /**
     * Get user owns the metric
     *
     * @return User
     */
    public User getUser()
    {
        return user;
    }

    /**
     * Get title
     *
     * @return String
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Get values
     *
     * @return A set of values
     */
    public Set<MetricValue> getValues()
    {
        return values;
    }
}
