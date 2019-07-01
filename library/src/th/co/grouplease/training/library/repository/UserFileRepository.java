package th.co.grouplease.training.library.repository;

import th.co.grouplease.training.library.domain.User;
import th.co.grouplease.training.library.exception.NotImplementedException;

import java.util.List;

public class UserFileRepository implements UserRepository {

    @Override
    public List<User> getUsers() {
        throw new NotImplementedException();
    }

    @Override
    public void saveUsers(List<User> users) {
        throw new NotImplementedException();
    }
}
