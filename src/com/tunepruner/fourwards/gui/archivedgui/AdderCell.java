package com.tunepruner.fourwards.gui.archivedgui;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.awt.*;

public class AdderCell extends Cell {
    public static final String STRING_TO_DISPLAY = "Drag to add new";
    private static AdderCell adderCell;

    public AdderCell(ListArea listArea, String string) {
        super(listArea, string);
    }

    @Override
    public Point determineCellPosition() {
        Point point = new Point();
        point.setLocation(-75, -100);
        return point;
    }

    @Override
    public void revealCell(Pane pane) {
        cellGroup.setOpacity(0);
        pane.getChildren().add(cellGroup);
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
                new Duration(300),
                new KeyValue(cellGroup.opacityProperty(), 1));
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    public static AdderCell getInstance(ListArea listArea) {
        adderCell = new AdderCell(listArea, STRING_TO_DISPLAY);
        adderCell.designCell();
        adderCell.revealCell(listArea.getStartAreaPane());
        return adderCell;
    }

    @Override
    public void handleDragAndDrop() {
        cellGroup.setOnMouseClicked(event -> {
//            listArea.getList().add("testing");
//            super.designCell("testing");
        });

        cellGroup.setOnMousePressed(event -> {
//            listArea.getGrid().currentDraggedFromIndex = listArea.getList().indexOf(((Label) hBox.getChildren().get(1)).getText());
//
//            preCalcSceneX = event.getSceneX();
//            preCalcSceneY = event.getSceneY();
//            isInListArea = false;

        });
    }

}
