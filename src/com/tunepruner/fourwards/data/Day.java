package com.tunepruner.fourwards.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Day {
    private LocalDate dateToday;/*constructor only!*/
    private ObservableList<TimeContainer> list = FXCollections.observableArrayList();


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
