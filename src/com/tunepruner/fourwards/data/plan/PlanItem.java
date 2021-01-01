package com.tunepruner.fourwards.data.plan;

import com.tunepruner.fourwards.data.general.Topic;
import com.tunepruner.fourwards.data.daylist.*;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder={"topicName"})
public class PlanItem {
    @XmlElement(name = "topic", type = Topic.class)
    private Topic topic;/*must get from list of Topics, instantiate only in constructure!*/
    private Day day;/*must get from list of Days*/
    public static final String TOPIC_NAME="topicName";
    private Status status;
    private enum Status{PLANNED_ONLY, WORKING, DONE, CANCELED}

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic){
        this.topic = topic;
    }

    public PlanItem(){}

    public PlanItem(String topicName) {
        this.topic = new Topic(topicName);
    }
}
