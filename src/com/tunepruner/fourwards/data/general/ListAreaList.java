package com.tunepruner.fourwards.data.general;

import com.tunepruner.fourwards.data.plan.PlanItem;
import com.tunepruner.fourwards.gui.ListArea;
import javafx.collections.ObservableList;

public interface ListAreaList<T extends ListAreaItem> extends Observable {
    public T get(int index);
    public void add(int index, ListArea listArea, String topicNameToAdd);
    public void add(int index, T t);
    public void remove(T t);
    public void remove(String name);
    public void replace(T itemToRemove, T itemToReplaceWith);
    public void replace(String itemToRemove, String itemToReplaceWith);
    public int indexOf(String name);
    public int indexOf(T t);
    public boolean contains(T t);
    public boolean contains(String name);
    public void readFromFile();

    public int size();
    public ObservableList<PlanItem> addListenerOnly();
}
