package th.co.grouplease.training.library.repository;

import th.co.grouplease.training.library.domain.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserMockRepository implements UserRepository {

    private List<User> users = new ArrayList<>();

    public UserMockRepository(){
        users.add(new User(UUID.randomUUID().toString(), "John Doe", LocalDate.now()));
        users.add(new User(UUID.randomUUID().toString(), "Jane Doe", LocalDate.now()));
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void saveUsers(List<User> users) {
        if(users == null){
            throw new NullPointerException("users cannot be null");
        } else {
            this.users = users;
        }
    }
}
