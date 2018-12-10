package org.mikemirten.metrics.Domain.Service.MetricStatistics;

import org.mikemirten.metrics.Domain.Model.Metric;

/**
 * Interface of statistics calculator
 */
public interface StatisticsCalculator
{
    /**
     * Calculate statistics for given metric
     *
     * @param metric
     * @return Double
     */
    MetricStatistics calculate(Metric metric);
}
