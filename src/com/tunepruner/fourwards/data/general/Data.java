package com.tunepruner.fourwards.data.general;

import com.tunepruner.fourwards.data.daylist.Day;
import com.tunepruner.fourwards.data.plan.Plan;
import com.tunepruner.fourwards.data.plan.PlanItem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    private boolean listHasBeenCreated = false;
    @XmlElement(name = "time_container", type = PlanItem.class)
    private static ObservableList<PlanItem> dataFromFile = FXCollections.observableArrayList();
    private static ObservableList<Day> days = FXCollections.observableArrayList();
    private Timestamp timestamp;

//    public static ObservableList<PlanItem> getDataFromFile() {
//        return dataFromFile;
//    }
//    public static Integer indexOf(PlanItem planItemToEvaluate) {
//
//        Integer indexOfPlanItem = null;
//        for ( int i = 0; i > dataFromFile.size(); i++ ) {
//            if (planItemToEvaluate == dataFromFile.get(i)) {
//                indexOfPlanItem = i;
//                break;
//            }
//        }
//        return indexOfPlanItem;
//    }
//
//    public static Integer indexOf(String topicName) {
//        Integer indexOfPlanItem = null;
//        for ( int i = 0; i < dataFromFile.size(); i++ ) {
//            if (dataFromFile.get(i).getTopic().getName().equals(topicName)) {
//                indexOfPlanItem = i;
//                break;
//            }
//        }
//        return indexOfPlanItem;
//    }
//
//    public static void add(int index, PlanItem planItemToAdd) {
//        dataFromFile.add(index, planItemToAdd);
//    }
//
//    public static void add(int index, ListArea listArea, String topicNameToAdd) {
//        PlanItem planItem = new PlanItem(topicNameToAdd);
//        add(index, planItem);
//    }
//
//    public static void remove(PlanItem planItemToRemove) {
//        dataFromFile.remove(planItemToRemove);
//    }
//
//    public static void remove(String topicNameToRemove) {
//        int indexOf = indexOf(topicNameToRemove);
//        dataFromFile.remove(indexOf);
//    }
//
//    public static boolean contains(PlanItem planItemToQuery) {
//        return dataFromFile.contains(planItemToQuery);
//    }

//    public static boolean contains(String topicNameToQuery) {
//        return dataFromFile
//                .stream()
//                .anyMatch(planItem -> planItem.getTopic().getName().equals(topicNameToQuery));
//    }

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
//        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
//        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//
//        File f = new File("data.xml");
//
//        Data data = (Data) unmarshaller.unmarshal(f);
        generate();
    }

    public static void generate(){
        ObservableList<PlanItem> planItems = FXCollections.observableArrayList();
        List<PlanItem> planItemsArrayList = Arrays.asList(new PlanItem("One"), new PlanItem("Two"), new PlanItem("Three"), new PlanItem("Four"), new PlanItem("Five"), new PlanItem("Six"), new PlanItem("Seven"), new PlanItem("Eight"), new PlanItem("Nine"), new PlanItem("Ten"), new PlanItem("Eleven"), new PlanItem("Twelve"), new PlanItem("Thirteen"), new PlanItem("Fourteen"), new PlanItem("Fifteen"), new PlanItem("Sixteen"), new PlanItem("Seventeen"), new PlanItem("Eighteen"), new PlanItem("Nineteen"), new PlanItem("Twenty"), new PlanItem("Twenty-one"), new PlanItem("Twenty-two"));
        planItems.addAll(planItemsArrayList);

        List daysArray = Arrays.asList(
                new Day(LocalDate.now().minus(Period.ofDays(2))),
                new Day(LocalDate.now().minus(Period.ofDays(1))),
                new Day(LocalDate.now()));
        days.addAll(daysArray);
        for ( int i = 0; i < days.size(); i++ ) {
            days.get(i).setPlan(new Plan(new Timestamp(System.currentTimeMillis()), planItems));
        }
    }
    public static Day getToday(){
        Optional<Day> today = days.stream()
                .filter(day -> day.getDate().equals(LocalDate.now()))
                .findAny();
        return today.orElse(null);
    }

    public static Day getDay(LocalDate dateOfDayToRetrieve) {
        Optional<Day> today = days.stream()
                .filter(day -> day.getDate().equals(dateOfDayToRetrieve))
                .findAny();
        return today.orElse(null);
    }
}
