package database;

import java.util.List;

public interface CRUD {
    //Object es una clase generica para los objetos donde culquier
    // objeto de Java que puede ser un object
    public Object insert(Object object);
    public boolean update(Object object0);

    public boolean delete(Object object);

    public List<Object> findAll();


    public Object findById(int d);
}
