package com.tunepruner.fourwards;

import com.sun.javafx.binding.StringFormatter;
import com.tunepruner.fourwards.data.daylist.Day;
import com.tunepruner.fourwards.gui.ListArea;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.awt.*;

public class Main extends Application {
    private Rectangle rectBackground;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane listAreaPane = new Pane();
        listAreaPane.toFront();

        //Data.readFromFile();
        //Data.persist();
        //Day day = Data.getDay(LocalData.now())
        //TODO remember to uncomment these!!

        ListArea listArea = new ListArea(
                "PlanList",
                listAreaPane,
                new Point(350, 150),//topLeft
                500,
                500,
                25,
                200,
                10,
                primaryStage,
                new Day()/*TODO replace this with day above*/
//                ,
//                day
        );
        rectBackground = new Rectangle();
        rectBackground.setFill(listArea.COLOR_OF_INNER_PANE);

        listAreaPane = listArea.drawListArea();

        Group root = new Group();
        root.getChildren().addAll(listAreaPane, rectBackground);
        rectBackground.toBack();

        Scene scene = new Scene(root, 1300, 700);
        this.rectBackground.widthProperty().bind(scene.widthProperty());
        this.rectBackground.heightProperty().bind(scene.heightProperty());

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}