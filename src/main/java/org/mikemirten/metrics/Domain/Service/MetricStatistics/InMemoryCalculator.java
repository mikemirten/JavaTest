package org.mikemirten.metrics.Domain.Service.MetricStatistics;

import org.mikemirten.metrics.Domain.Model.Metric;
import org.mikemirten.metrics.Domain.Model.MetricValue;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * A statistics calculator using memory to store temporary data.
 * Due to necessity of sorting for median calculation, has complexity O(n log(n)).
 */
@Service
public class InMemoryCalculator implements StatisticsCalculator
{
    /**
     * {@inheritDoc}
     */
    @Override
    public MetricStatistics calculate(Metric metric)
    {
        Set<MetricValue> valuesSet = metric.getValues();
        Integer size = valuesSet.size();

        if (size == 0) {
            return new MetricStatistics(0.0, 0.0, 0.0, 0.0);
        }

        List<Double> values = new ArrayList<>(size);

        for (MetricValue value: valuesSet) {
            values.add(value.getValue());
        }

        values.sort(null);

        return new MetricStatistics(
            values.get(0),
            values.get(size - 1),
            values.stream().mapToDouble(d -> d).average().getAsDouble(),
            calculateMedian(values)
        );
    }

    /**
     * Calculate median by given list of values
     *
     * @param values
     * @return Double
     */
    private Double calculateMedian(List<Double> values)
    {
        Integer size = values.size();

        if (size == 1) {
            return values.get(0);
        }

        if (size % 2 == 0) {
            return (values.get((size - 1) / 2) + values.get(size / 2)) / 2;
        }

        return values.get(size / 2);
    }
}
