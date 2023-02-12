package com.rawrysmode.entities;

public class TableEntity<E> {

    private E entity;
    private boolean hasChanged;
    private boolean isCreated;

    public TableEntity(E entity) {
        this.entity = entity;
        this.hasChanged = false;
        this.isCreated = false;
    }

    public TableEntity(E entity, boolean isCreated) {
        this.entity = entity;
        this.hasChanged = false;
        this.isCreated = true;
    }

    public E getEntity() {
        return entity;
    }

    public void setEntity(E entity) {
        this.entity = entity;
    }

    public boolean hasChanged() {
        return hasChanged;
    }

    public void setHasChanged(boolean hasChanged) {
        this.hasChanged = hasChanged;
    }

    public boolean isCreated() {
        return isCreated;
    }

    public void setCreated(boolean isCreated) {
        this.isCreated = isCreated;
    }

}
