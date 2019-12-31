package model;


import view.Observer;

import java.util.ArrayList;

public class LoggedClient implements Subject{
    private volatile static LoggedClient uniqueInstance;
    public ArrayList<Observer> observers;

    public LoggedClient(){
        observers = new ArrayList<>();
    }
    public static LoggedClient getInstance() {
        if (uniqueInstance == null) {
            synchronized (LoggedClient.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new LoggedClient();
                }
            }
        }
        return uniqueInstance;
    }
    private String client;
    public String getClient(){return client;}

    public void setClient(String client) {
        this.client = client;
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
