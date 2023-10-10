package org.library.model;

public abstract class BaseModel<T> {

    private T id;

    public BaseModel() {
    }

    public BaseModel(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
