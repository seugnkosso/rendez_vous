package com.rv.repositories.core;

public interface IdataBase {
    void openConnexion();
    void closeConnexion();
    void executeSelect();
    void executeUpdate();
}
