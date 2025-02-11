package org.example;

import java.util.HashSet;

public interface AppUserDAO {

    AppUser persist(AppUser appUser);
    AppUser findByUsername(String username);
    HashSet<AppUser> findAll();
    void remove(String username);
}
