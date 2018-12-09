package org.mikemirten.metrics.EventListener;

import org.mikemirten.metrics.Domain.Model.User;
import org.mikemirten.metrics.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * The listener ensures there is at least one user in the database presents.
 * Otherwise creates one.
 */
@Component
public class EnsureUserEventListener
{
    /**
     * Repository of users
     */
    private final UserRepository userRepository;

    @Autowired
    public EnsureUserEventListener(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationEvent()
    {
        if (userRepository.count() > 0) {
            return;
        }

        User user = new User("admin");
        userRepository.save(user);
    }
}
