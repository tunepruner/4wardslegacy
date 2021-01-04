package com.tunepruner.fourwards.data.plan;

import com.tunepruner.fourwards.data.general.ListAreaItem;
import com.tunepruner.fourwards.data.general.ListAreaList;
import com.tunepruner.fourwards.data.general.Subscriber;
import com.tunepruner.fourwards.gui.ListArea;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Plan implements ListAreaList<PlanItem> {
    private Timestamp timestamp;
    private ObservableList<PlanItem> planItems = FXCollections.observableArrayList();
    private ArrayList<Subscriber> subscribers;

    public Plan() {
    }

    public Plan(Timestamp timestamp, ObservableList<PlanItem> planItems) {
        this.timestamp = timestamp;
        this.planItems = planItems;
        this.subscribers = new ArrayList<>();
    }

    public ObservableList<PlanItem> getPlanItems() {
        return planItems;
    }

    public int size() {
        return planItems.size();
    }

    @Override
    public ObservableList<PlanItem> addListenerOnly() {
        return planItems;
    }

    @Override
    public PlanItem get(int index) {
        return planItems.get(index);
    }

    @Override
    public void add(int index, ListArea listArea, String topicNameToAdd) {
        PlanItem planItem = new PlanItem(topicNameToAdd);
        add(index, planItem);
    }

    @Override
    public void add(int index, PlanItem planItemToAdd) {
        planItems.add(index, planItemToAdd);
    }

    @Override
    public void remove(PlanItem planItemToRemove) {
        planItems.remove(planItemToRemove);
    }

    @Override
    public void remove(String topicNameToRemove) {
        int indexOf = indexOf(topicNameToRemove);
        planItems.remove(indexOf);
    }

    @Override
    public void replace(PlanItem itemToRemove, PlanItem itemToReplaceWith) {

    }

    @Override
    public void replace(String itemToRemove, String itemToReplaceWith) {

    }

    @Override
    public int indexOf(String name) {
        Integer indexOfPlanItem = null;
        for ( int i = 0; i < planItems.size(); i++ ) {
            if (planItems.get(i).getTopic().getName().equals(name)) {
                indexOfPlanItem = i;
                break;
            }
        }
        return indexOfPlanItem;
    }

    @Override
    public int indexOf(PlanItem planItemToEvaluate) {
        Integer indexOfPlanItem = null;
        for ( int i = 0; i > planItems.size(); i++ ) {
            if (planItemToEvaluate == planItems.get(i)) {
                indexOfPlanItem = i;
                break;
            }
        }
        return indexOfPlanItem;
    }

    @Override
    public boolean contains(PlanItem planItemToQuery) {
        return planItems.contains(planItemToQuery);
    }


    @Override
    public boolean contains(String topicNameToQuery) {
        return planItems
                .stream()
                .anyMatch(planItem -> planItem.getTopic().getName().equals(topicNameToQuery));
    }

    @Override
    public void readFromFile() {

    }

    @Override
    public void notifySubscribers() {
        for ( Subscriber subscriber : subscribers ) {
            subscriber.update();
        }
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }
}
