package org.library.service;

import java.util.List;

public interface BaseService<T, U> {

    List<T> getAll();

    void save(T model);

    void update(T model);

    void delete(U id);

    T loadById(U id);

}
