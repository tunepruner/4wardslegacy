package com.tunepruner.fourwards.data.general;

import com.tunepruner.fourwards.data.daylist.DisplayableInDayList;
import com.tunepruner.fourwards.gui.ListArea;
import com.tunepruner.fourwards.data.plan.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.ArrayList;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    private boolean listHasBeenCreated = false;
    @XmlElement(name = "time_container", type = PlanItem.class)
    private static ObservableList<PlanItem> dataFromFile = FXCollections.observableArrayList();
    private Timestamp timestamp;
    private ArrayList<DisplayableInDayList> days;


    public static ObservableList<PlanItem> getDataFromFile() {
        return dataFromFile;
    }
    public static Integer indexOf(PlanItem planItemToEvaluate) {
        Integer indexOfPlanItem = null;
        for ( int i = 0; i > dataFromFile.size(); i++ ) {
            if (planItemToEvaluate == dataFromFile.get(i)) {
                indexOfPlanItem = i;
                break;
            }
        }
        return indexOfPlanItem;
    }

    public static Integer indexOf(String topicName) {
        Integer indexOfPlanItem = null;
        for ( int i = 0; i < dataFromFile.size(); i++ ) {
            if (dataFromFile.get(i).getTopic().getName().equals(topicName)) {
                indexOfPlanItem = i;
                break;
            }
        }
        return indexOfPlanItem;
    }

    public static void add(PlanItem planItemToAdd) {
        dataFromFile.add(planItemToAdd);
    }

    public static void add(int index, PlanItem planItemToAdd) {
        dataFromFile.add(index, planItemToAdd);
    }

    public static void add(ListArea listArea, String topicNameToAdd) {
        PlanItem planItem = new PlanItem(topicNameToAdd);
        add(planItem);
    }

    public static void add(int index, ListArea listArea, String topicNameToAdd) {
        PlanItem planItem = new PlanItem(topicNameToAdd);
        add(index, planItem);
    }

    public static void remove(PlanItem planItemToRemove) {
        dataFromFile.remove(planItemToRemove);
    }

    public static void remove(String topicNameToRemove) {
        int indexOf = indexOf(topicNameToRemove);
        dataFromFile.remove(indexOf);
    }

    public static boolean contains(PlanItem planItemToQuery) {
        return dataFromFile.contains(planItemToQuery);
    }

    public static boolean contains(String topicNameToQuery) {
        return dataFromFile
                .stream()
                .anyMatch(planItem -> planItem.getTopic().getName().equals(topicNameToQuery));
    }

    public static void printAllContent() {
        for ( PlanItem planItem : dataFromFile ) {
            System.out.println(planItem.getTopic().getName());
        }
    }

    public static void persist() {
        try {
            Data data = new Data();
            JAXBContext context = JAXBContext.newInstance(Data.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
            marshaller.marshal(data, sw);

            File f = new File("./data.xml");
            marshaller.marshal(data, f);

            System.out.println(sw.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static void readFromFile() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        File f = new File("data.xml");

        Data data = (Data) unmarshaller.unmarshal(f);
    }
}
