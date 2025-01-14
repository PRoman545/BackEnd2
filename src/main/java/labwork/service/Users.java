package labwork.service;

import labwork.structure.User;
import labwork.service.errorHandler.UserNotFound;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    private Map<UUID, User> userMap = new HashMap<>();
    
    public User addUser(User user) {
        User newUser = User.builder()
                .id(UUID.randomUUID())
                .name(user.getName())
                .build();
        userMap.put(newUser.getId(), newUser);
        return newUser;
    }
    
    public List<User> getUsers() {
        return List.copyOf(userMap.values());
    }

    public User getUserId(UUID id) {
        User user = userMap.get(id);
        if (user == null) {
            throw new UserNotFound(id);
        }
        return user;
    }

    public void deleteUser(UUID id) {
        User user = getUserId(id);
        userMap.remove(user.getId());
    }

}