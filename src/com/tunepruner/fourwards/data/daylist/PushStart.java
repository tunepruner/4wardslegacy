package com.tunepruner.fourwards.data.daylist;

import com.tunepruner.fourwards.data.general.*;

import java.sql.Timestamp;
import java.time.LocalDate;

public class PushStart implements DisplayableInDayList {
    private Timestamp timestamp;
    private LocalDate date;
    /*Needn't be effectively final, but must be unique!
     * Also, must represent day that precedes it!*/
}
