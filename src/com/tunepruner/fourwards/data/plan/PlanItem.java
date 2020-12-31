package com.tunepruner.fourwards.data.plan;

import com.tunepruner.fourwards.data.Topic;

public class PlanItem {
    private Topic topic;/*Set only in constructor*/
    private Status status;
    private enum Status{PLANNED_ONLY, WORKING, DONE, CANCELED}

    /*public int getPercentageOfFreeTimeLeft()*/
}
