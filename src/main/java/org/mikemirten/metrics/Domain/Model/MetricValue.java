package org.mikemirten.metrics.Domain.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "metric_values")
public class MetricValue
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private Double value;

    @ManyToOne
    @JoinColumn(name = "metric_id", nullable = false)
    @JsonIgnore
    private Metric metric;

    public MetricValue() {}

    public MetricValue(Metric metric, Double value)
    {
        this.metric = metric;
        this.value  = value;
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
     * Get metric owns the value
     *
     * @return Metric
     */
    public Metric getMetric()
    {
        return metric;
    }

    /**
     * Get value
     *
     * @return Float
     */
    public Double getValue()
    {
        return value;
    }
}
