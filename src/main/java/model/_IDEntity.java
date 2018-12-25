package model;

import anotations.Id;

public abstract class _IDEntity implements _iIDEntity {

    @Id
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
