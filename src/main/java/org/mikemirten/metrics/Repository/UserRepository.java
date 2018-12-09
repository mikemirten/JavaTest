package org.mikemirten.metrics.Repository;

import org.mikemirten.metrics.Domain.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>
{
}
