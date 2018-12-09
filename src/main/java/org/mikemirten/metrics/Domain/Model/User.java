package org.mikemirten.metrics.Domain.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String username;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Metric> metrics;

    public User()
    {
        metrics = new HashSet<>();
    }

    public User(String username)
    {
        this();
        this.username = username;
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
     * Get username
     *
     * @return String
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Get metrics belongs to the user
     *
     * @return A list of metrics
     */
    public Set<Metric> getMetrics()
    {
        return metrics;
    }
}
