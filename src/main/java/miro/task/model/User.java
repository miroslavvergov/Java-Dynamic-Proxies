package miro.task;

@Data
public class User {
    private String name;
}
public interface UserService {
    void addUser(User user);
}
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) {
        System.out.println(user.getName() + " is added successfully");
    }
}
