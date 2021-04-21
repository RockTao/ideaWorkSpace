package com.example.demo.ObserverPattern;

public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}