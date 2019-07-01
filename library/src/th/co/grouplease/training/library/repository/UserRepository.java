package th.co.grouplease.training.library.repository;

import th.co.grouplease.training.library.domain.User;

import java.util.List;

public interface UserRepository {
    List<User> getUsers();
    void saveUsers(List<User> users);
}
