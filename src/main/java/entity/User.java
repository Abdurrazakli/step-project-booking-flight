package entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private static int idCounter=1;
    public final int ID;
    public final String name;
    public final String surname;
    public final String username;
    public final String password;

    public User(String name, String surname, String username, String password) {
        this.ID = idCounter++;
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
