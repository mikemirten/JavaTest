package org.mikemirten.metrics.Repository;

import org.mikemirten.metrics.Domain.Model.MetricValue;
import org.springframework.data.repository.CrudRepository;

public interface MetricValueRepository extends CrudRepository<MetricValue, Integer>
{
}
