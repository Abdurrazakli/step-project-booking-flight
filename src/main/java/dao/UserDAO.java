package dao;

import entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserDAO implements DAO<User>{
    private Map<Integer, User> storage = new HashMap<>();


    @Override
    public Optional<User> get(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<User>> getAll() {
        return Optional.empty();
    }

    @Override
    public void create(User user) {

    }

    @Override
    public Optional<Boolean> delete(int id) {
        return Optional.empty();
    }
}
