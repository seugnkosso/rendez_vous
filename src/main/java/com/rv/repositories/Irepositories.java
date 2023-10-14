package com.rv.repositories;


public interface Irepositories<Obj> {
    int insert(Obj obj);

    Obj findById(int nextInt);
    int lastInsertId();
}
