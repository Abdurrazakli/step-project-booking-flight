package dao;

import entity.User;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserDAO implements DAO<User>{
    private Map<Integer, User> storage = new HashMap<>();
    private final String USER_DB_PATH ="src/main/java/testOnMyOwn/a.bin";

    Database<User> db = new Database<>();

    @Override
    public Optional<User> get(int id) { //TODO: Finding user with id??? or username
        return getAll().flatMap(users ->
                users.stream().filter(user ->
                        user.ID == id).findAny());
    }

    @Override
    public Optional<List<User>> getAll() {
        return db.read(USER_DB_PATH);
    }

    @Override
    public boolean create(User newUser) {
        List<User> users = new ArrayList<>(getAll().isPresent() ? getAll().get() : Collections.emptyList());
        users.add(newUser);
        return db.write(USER_DB_PATH,users);
    }

    @Override
    public boolean delete(int id) {
        return db.write(USER_DB_PATH,getAll().map(users ->
                users.stream().filter(user ->
                        user.ID != id).collect(Collectors.toList())).get());
    }

}
