package test.dao;

import java.util.List;

public interface LogiDao<T> {
    List<T> allObjects();
    void add(T t);

}
