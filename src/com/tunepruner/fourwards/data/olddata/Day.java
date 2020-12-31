package com.tunepruner.fourwards.data.olddata;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Day {
    private LocalDate dateToday;/*constructor only!*/
    private ObservableList<TimeContainer> listOfTimeContainers = FXCollections.observableArrayList();
    private ObservableList<TimeContainer> listOfTimeEntries = FXCollections.observableArrayList();


    public Day(){
        this.dateToday = LocalDate.now();
    }

    public Day(LocalDate localDate) {
        this.dateToday = localDate;
    }

    public LocalDate getDateToday() {
        return dateToday;
    }
}
