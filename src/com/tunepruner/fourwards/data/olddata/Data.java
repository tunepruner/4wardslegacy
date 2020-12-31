package com.tunepruner.fourwards.data.olddata;

import com.tunepruner.fourwards.gui.ListArea;
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

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    private boolean listHasBeenCreated = false;
    @XmlElement(name = "time_container", type = TimeContainer.class)
    private static ObservableList<TimeContainer> dataFromFile = FXCollections.observableArrayList();


    public static ObservableList<TimeContainer> getDataFromFile() {
        return dataFromFile;
    }
    public static Integer indexOf(TimeContainer timeContainerToEvaluate) {
        Integer indexOfTimeContainer = null;
        for ( int i = 0; i > dataFromFile.size(); i++ ) {
            if (timeContainerToEvaluate == dataFromFile.get(i)) {
                indexOfTimeContainer = i;
                break;
            }
        }
        return indexOfTimeContainer;
    }

    public static Integer indexOf(String topicName) {
        Integer indexOfTimeContainer = null;
        for ( int i = 0; i < dataFromFile.size(); i++ ) {
            if (dataFromFile.get(i).getTopic().getName().equals(topicName)) {
                indexOfTimeContainer = i;
                break;
            }
        }
        return indexOfTimeContainer;
    }

    public static void add(TimeContainer timeContainerToAdd) {
        dataFromFile.add(timeContainerToAdd);
    }

    public static void add(int index, TimeContainer timeContainerToAdd) {
        dataFromFile.add(index, timeContainerToAdd);
    }

    public static void add(ListArea listArea, String topicNameToAdd) {
        TimeContainer timeContainer = new TimeContainer(topicNameToAdd);
        add(timeContainer);
    }

    public static void add(int index, ListArea listArea, String topicNameToAdd) {
        TimeContainer timeContainer = new TimeContainer(topicNameToAdd);
        add(index, timeContainer);
    }

    public static void remove(TimeContainer timeContainerToRemove) {
        dataFromFile.remove(timeContainerToRemove);
    }

    public static void remove(String topicNameToRemove) {
        int indexOf = indexOf(topicNameToRemove);
        dataFromFile.remove(indexOf);
    }

    public static boolean contains(TimeContainer timeContainerToQuery) {
        return dataFromFile.contains(timeContainerToQuery);
    }

    public static boolean contains(String topicNameToQuery) {
        return dataFromFile
                .stream()
                .anyMatch(timeContainer -> timeContainer.getTopic().getName().equals(topicNameToQuery));
    }

    public static void printAllContent() {
        for ( TimeContainer timeContainer : dataFromFile ) {
            System.out.println(timeContainer.getTopic().getName());
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