package com.tunepruner.fourwards.data.general;



import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Data {
    private Timestamp timestamp;
    private ArrayList<DisplayableInDayList> days;

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
