package com.tunepruner.fourwards.data.general;

public interface Observable {
    public void notifySubscribers();

    public void addSubscriber(Subscriber subscriber);
}
