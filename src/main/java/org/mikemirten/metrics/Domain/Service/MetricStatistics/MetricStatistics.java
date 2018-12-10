package org.mikemirten.metrics.Domain.Service.MetricStatistics;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetricStatistics
{
    @JsonProperty
    private final Double min;

    @JsonProperty
    private final Double max;

    @JsonProperty
    private final Double mean;

    @JsonProperty
    private final Double median;

    public MetricStatistics(Double min, Double max, Double mean, Double median)
    {
        this.min    = min;
        this.max    = max;
        this.mean   = mean;
        this.median = median;
    }

    /**
     * Get min value
     *
     * @return Double
     */
    public Double getMin()
    {
        return min;
    }

    /**
     * Max value
     *
     * @return Double
     */
    public Double getMax()
    {
        return max;
    }

    /**
     * Get average value
     *
     * @return Double
     */
    public Double getMean()
    {
        return mean;
    }

    /**
     * Get median value
     *
     * @return Double
     */
    public Double getMedian()
    {
        return median;
    }
}
