package entity;

import java.util.Objects;

public class User {
    public static int ID=1;
    public final String name;
    public final String surname;
    public final String username;
    public final String password;

    public User(String name, String surname, String username, String password) {
        User.ID += 1;
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
        return user.ID == User.ID && user.username.equals(this.username);
    }
}
