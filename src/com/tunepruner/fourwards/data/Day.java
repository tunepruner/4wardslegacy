package com.tunepruner.fourwards.data;

import java.time.LocalDate;

public class Day {
    private LocalDate dateToday;
    Data data;

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
