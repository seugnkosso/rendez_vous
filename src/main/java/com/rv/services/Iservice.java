package com.rv.services;

public interface Iservice<obj> {
    int add(obj obj);

    obj findById(int nextInt);
    int lastInsertId();
}
