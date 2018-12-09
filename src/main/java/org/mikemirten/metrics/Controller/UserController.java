package org.mikemirten.metrics.Controller;

import org.mikemirten.metrics.Domain.Model.User;
import org.mikemirten.metrics.JsonDocument.JsonResponse;
import org.mikemirten.metrics.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    /**
     * Repository of users
     */
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    /**
     * Get list of all users
     *
     * @return JsonResponse
     */
    @GetMapping("/users")
    public JsonResponse list()
    {
        Iterable<User> users = userRepository.findAll();

        return new JsonResponse(users);
    }
}
