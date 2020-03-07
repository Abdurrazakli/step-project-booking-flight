package entity;

import java.util.Objects;

public class User {
    public final int ID;
    public final String name;
    public final String surname;
    public final String username;
    public final String password;

    public User(int id, String name, String surname, String username, String password) {
        this.ID = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    private String represent(){
        return String.format("%d %s %s %s %s",ID,name,surname,username,password);
    }

    @Override
    public String toString() {
        return String.format("User: [%s]",represent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID,name,surname,username,password);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return user.ID == this.ID && user.username.equals(this.username);
    }
}
