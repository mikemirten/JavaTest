package org.mikemirten.metrics.Service.MetricCreator;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class MetricDTO
{
    @NotNull
    @Length(min = 4, max = 255)
    private final String title;

    public MetricDTO(@JsonProperty("title") String title)
    {
        this.title = title;
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
}
