package com.tunepruner.fourwards.data.log;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ClockTimeEntry {
    private ArrayList<TimeAllottment> timeAllottments;
    private LocalDateTime clockIn;
    private LocalDateTime clockOut;
    private ProductivityGraph productivity;
    private RelevanceGraph relevance;

    private class ProductivityGraph {
    }

    private class RelevanceGraph {
    }
}
