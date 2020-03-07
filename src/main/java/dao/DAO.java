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
    Optional<List<A>> getAll();
    void create(A a);
    Optional<Boolean> delete(int id);         // id-> A.id
}
