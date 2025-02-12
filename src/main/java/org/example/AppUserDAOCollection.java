package org.example;

import java.util.*;

public class AppUserDAOCollection implements AppUserDAO {

    private HashSet<AppUser> appUsers = new HashSet<>();


    @Override
    public AppUser persist(AppUser appUser) {
        appUsers.add(appUser);
        return appUser;
    }

    @Override
    public AppUser findByUsername(String username) {
        Iterator<AppUser> appUserIterator = appUsers.iterator();
        AppUser appUser = null;
        while (appUserIterator.hasNext()) {
            appUser = appUserIterator.next();
            if (appUser.getUsername().equals(username)) {
                break;
            }
        }
        return appUser;
       /* AppUser appUserToReturn = null;       //I know it all could have been done with an easy for each, but wanted to try out the Iterator
        for (AppUser appUser : appUsers){
            if (appUser.getUsername().equals(username)){
                appUserToReturn = appUser;
            }
        }
        return  appUserToReturn;*/
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
