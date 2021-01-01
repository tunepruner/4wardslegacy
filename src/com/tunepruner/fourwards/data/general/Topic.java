package com.tunepruner.fourwards.data.general;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Topic {
    private Timestamp timestamp;
    @XmlAttribute
    private String name;/*Unique and effectively final; serves as key*/
    private Type type;

    private enum Type {STUDY, PRACTICE, CREATION, WELL_BEING}

    public Topic() {
    }

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
