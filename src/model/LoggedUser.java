package model;


import view.Observer;
import view.UBFLIX;

import java.util.ArrayList;

public class LoggedUser implements Subject {
    private volatile static LoggedUser uniqueInstance;
    public ArrayList<Observer> observers;
    public LoggedUser(){
        observers = new ArrayList<>();

    }

    public static LoggedUser getInstance() {
        if (uniqueInstance == null) {
            synchronized (LoggedUser.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new LoggedUser();
                }
            }
        }
        return uniqueInstance;
    }
    private String User;
    public String getUser(){return User;}

    public void setUser(String User) {
        this.User = User;
        _notify();
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void _notify() {
        for(Observer o:observers){
            o._update();
        }
    }
}
