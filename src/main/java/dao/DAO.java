package dao;

import java.util.List;
import java.util.Optional;

/*
* Temporary implementation:
* delete @return true if object deleted
*
* */

public interface DAO<A> {
    Optional<A> get(int id);                  // id->A.id
    List<A> getAll();
    boolean create(A a);
    //todo check all delete functions for a better logic
    boolean delete(int id);         // id-> A.id
}
