package dao.interfaces;

import model._IDEntity;

import java.util.List;

public interface IAbstractDAO<E extends _IDEntity> {

    public List<E> getAll();

    public E getById(Integer id);

    public boolean update(E entity);

    public boolean create(E entity);

    public boolean delete(E entity);

    public boolean deleteById(Integer id);

}
