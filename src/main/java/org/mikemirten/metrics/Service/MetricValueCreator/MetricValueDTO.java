package org.mikemirten.metrics.Service.MetricValueCreator;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class MetricValueDTO
{
    @NotNull
    private final Float value;

    public MetricValueDTO(@JsonProperty("value") Float value)
    {
        this.value = value;
    }

    /**
     * Get value
     *
     * @return float
     */
    public Float getValue()
    {
        return value;
    }
}
