package org.mikemirten.metrics.Service.MetricValueCreator;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class MetricValueDTO
{
    @NotNull
    private final Double value;

    public MetricValueDTO(@JsonProperty("value") Double value)
    {
        this.value = value;
    }

    /**
     * Get value
     *
     * @return float
     */
    public Double getValue()
    {
        return value;
    }
}
