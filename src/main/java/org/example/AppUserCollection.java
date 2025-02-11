package org.example;

import java.util.*;

public class AppUserCollection implements AppUserDAO {

    private HashSet<AppUser> appUsers = new HashSet<>();


    @Override
    public AppUser persist(AppUser appUser) {
        appUsers.add(appUser);
        return appUser;
    }

    @Override
    public AppUser findByUsername(String username) {
        Iterator<AppUser> appUserIterator = appUsers.iterator();
        AppUser appUser;
        while (appUserIterator.hasNext()) {
            appUser = appUserIterator.next();
            if (appUser.getUsername().equals(username)) {
                break;
            }
        }
        return (AppUser) appUserIterator;
    }


    @Override
    public HashSet<AppUser> findAll() {
        return appUsers;
    }

    @Override
    public void remove(String username) {
        Iterator<AppUser> appUserIterator = appUsers.iterator();
        AppUser appUser;
        while (appUserIterator.hasNext()) {
            appUser = appUserIterator.next();
            if (appUser.getUsername().equals(username)) {
                appUserIterator.remove();
                break;
            }
        }
    }
}
