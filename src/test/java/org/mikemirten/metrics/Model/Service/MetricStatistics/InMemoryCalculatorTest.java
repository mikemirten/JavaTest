package org.mikemirten.metrics.Model.Service.MetricStatistics;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.mikemirten.metrics.Domain.Model.Metric;
import org.mikemirten.metrics.Domain.Model.MetricValue;
import org.mikemirten.metrics.Domain.Service.MetricStatistics.InMemoryCalculator;
import org.mikemirten.metrics.Domain.Service.MetricStatistics.MetricStatistics;

import java.util.HashSet;
import java.util.Set;

public class InMemoryCalculatorTest
{
    @Test
    public void calculateEven()
    {
        Metric metric = createMetric(2.25, 5.5, 23.5, 3.0);

        InMemoryCalculator calculator = new InMemoryCalculator();
        MetricStatistics   statistics = calculator.calculate(metric);

        assertEquals(2.25, statistics.getMin(), 0.01);
        assertEquals(23.5, statistics.getMax(), 0.01);
        assertEquals(8.56, statistics.getMean(), 0.01);
        assertEquals(4.25, statistics.getMedian(), 0.01);
    }

    @Test
    public void calculateOdd()
    {
        Metric metric = createMetric(23.5, 5.5, 2.25, 3.0, 20.0);

        InMemoryCalculator calculator = new InMemoryCalculator();
        MetricStatistics   statistics = calculator.calculate(metric);

        assertEquals(2.25, statistics.getMin(), 0.01);
        assertEquals(23.5, statistics.getMax(), 0.01);
        assertEquals(10.85, statistics.getMean(), 0.01);
        assertEquals(5.5, statistics.getMedian(), 0.01);
    }

    /**
     * Prepare test metric
     *
     * @param values testing values
     * @return Mock of metric
     */
    private Metric createMetric(double... values)
    {
        Set<MetricValue> set = new HashSet<>(values.length);

        for (double val: values) {
            MetricValue value = mock(MetricValue.class);
            when(value.getValue()).thenReturn(val);

            set.add(value);
        }

        Metric metric = mock(Metric.class);
        when(metric.getValues()).thenReturn(set);

        return metric;
    }
}
