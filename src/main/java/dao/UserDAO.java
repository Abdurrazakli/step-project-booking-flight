package dao;

import entity.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserDAO implements DAO<User>{

    private final String USER_DB_PATH = "./data/users.bin";
    FileOperations<User> fileOperations = new FileOperations<>();


    @Override
    public Optional<User> get(int id) { //TODO: Finding user with id??? or username
        return  Optional.of(getAll()
                .stream()
                .filter(f->f.getID() == id)
                .collect(Collectors.toList())
                .get(0));
    }

    @Override
    public List<User> getAll() {
        return fileOperations.read(USER_DB_PATH);
    }

    @Override
    public boolean create(User newUser) {
        List<User> users = new ArrayList<>(getAll());
        users.add(newUser);
        return fileOperations.write(USER_DB_PATH,users);
    }

    @Override
    public boolean delete(int id) {
        List<User> all =  getAll();
        List<User> deleted = all.stream().filter(f -> f.getID() != id).collect(Collectors.toList());
        if (all.size() == deleted.size()) return false;
        return fileOperations.write(USER_DB_PATH,deleted);
    }

}
