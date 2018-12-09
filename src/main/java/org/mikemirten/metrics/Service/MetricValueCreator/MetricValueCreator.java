package org.mikemirten.metrics.Service.MetricValueCreator;

import org.mikemirten.metrics.Domain.Model.Metric;
import org.mikemirten.metrics.Domain.Model.MetricValue;
import org.mikemirten.metrics.Exception.ActionException;

public interface MetricValueCreator
{
    /**
     * Create new value for certain metric
     *
     * @patam metric
     * @param dto
     * @return MetricValue
     * @throws ActionException
     */
    MetricValue create(Metric metric, MetricValueDTO dto) throws ActionException;
}
