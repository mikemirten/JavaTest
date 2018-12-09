package org.mikemirten.metrics.Repository;

import org.mikemirten.metrics.Domain.Model.Metric;
import org.springframework.data.repository.CrudRepository;

public interface MetricRepository extends CrudRepository<Metric, Integer>
{
}
