package com.tunepruner.fourwards.gui;

import com.tunepruner.fourwards.data.general.Data;
import com.tunepruner.fourwards.data.general.Subscriber;
import com.tunepruner.fourwards.data.plan.*;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.stage.Popup;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.shape.Polygon;

import java.awt.*;

import javafx.scene.control.ProgressBar;


public class Cell implements Subscriber {
    HBox hBox;
    VBox vBox;
    Polygon leftTriangle;
    Polygon rightTriangle;
    Group cellGroup;
    Label label;
    String string;
    boolean isInListArea = false;
    Point currentPosition = new Point();
    double preCalcSceneX, preCalcSceneY;
    ListArea listArea;

    public Cell(ListArea listArea, String string) {
        this.hBox = new HBox();
        this.vBox = new VBox();
        this.leftTriangle = new Polygon();
        this.rightTriangle = new Polygon();
        this.cellGroup = new Group();
        this.label = new Label(string);
        this.string = string;
        this.listArea = listArea;
        this.listArea.getPlan().addSubscriber(this);
    }

    public void designCell(String string) {
        Pane paneInsideHBox1 = new Pane();
        Pane paneInsideHBox2 = new Pane();
        Pane paneInsideVBox1 = new Pane();
        Pane paneInsideVBox2 = new Pane();
        Button btn = new Button();
        ProgressBar progressBar = new ProgressBar(1);
        cellGroup.getChildren().addAll(hBox, vBox, leftTriangle, rightTriangle);

        leftTriangle.getPoints().addAll((double) -listArea.getCellHeight() + 100.0, listArea.getCellHeight() + 100.0,
                0.00 + 100.0, 0.0 + 100.0,
                0.0 + 100.0, (double) listArea.getCellHeight() + 100.0);

        rightTriangle.getPoints().addAll(
                (double) listArea.getCellWidth() + 100.0, (double) listArea.getCellWidth() + listArea.getCellHeight() * 2 + 100.0,
                (double) listArea.getCellWidth() + 100.0, (double) listArea.getCellWidth() + listArea.getCellHeight() + 100.0,
                (double) listArea.getCellWidth() + listArea.getCellHeight() + 100.0, (double) listArea.getCellWidth() + listArea.getCellHeight() + 100.0);

        SVGPath svgPath = new SVGPath();
        svgPath.setContent("M4,10h24c1.104,0,2-0.896,2-2s-0.896-2-2-2H4C2.896,6,2,6.896,2,8S2.896,10,4,10z M28,14H4c-1.104,0-2,0.896-2,2  s0.896,2,2,2h24c1.104,0,2-0.896,2-2S29.104,14,28,14z M28,22H4c-1.104,0-2,0.896-2,2s0.896,2,2,2h24c1.104,0,2-0.896,2-2  S29.104,22,28,22z");
        svgPath.setRotate(90);
        svgPath.setScaleX(.5);
        svgPath.setScaleY(.8);

        hBox.setMinWidth(listArea.getCellWidth());
        hBox.setMaxWidth(listArea.getCellWidth());
        hBox.setMinHeight(listArea.getCellHeight());
        hBox.setMaxHeight(listArea.getCellHeight());
        Background hBoxBackground = new Background(new BackgroundFill(listArea.COLOR_OF_CELLS, CornerRadii.EMPTY, Insets.EMPTY));
        hBox.setBackground(hBoxBackground);
        hBox.setManaged(true);

        progressBar.setRotate(-90);
        progressBar.setScaleX(3.5);
        progressBar.setOpacity(1);
        progressBar.setManaged(true);
        progressBar.setStyle(
                "-fx-control-inner-background: rgb(1, 150, 150);" +
                        " -fx-text-box-border: rgb(1, 150, 150);" +
                        " -fx-background: rgb(1, 100, 150);" +
                        " -fx-accent: rgb(1, 100, 150); ");
        progressBar.setBackground(hBoxBackground);


        btn.setOpaqueInsets(new Insets(0));
        btn.setScaleX(.6);
        btn.setScaleY(.6);
        btn.setAlignment(Pos.CENTER);
        btn.setStyle("-fx-background-color: rgb(1, 200, 500);");
//        btn.setBackground(new Background(new BackgroundFill(listArea.COLOR_OF_INNER_PANE, CornerRadii.EMPTY, Insets.EMPTY)));
        btn.setEffect(listArea.dropShadow);

        vBox.setMinWidth(listArea.getCellHeight());
        vBox.setMaxWidth(listArea.getCellHeight());
        vBox.setMinHeight(listArea.getCellWidth() + listArea.getCellHeight());
        vBox.setMaxHeight(listArea.getCellWidth() + listArea.getCellHeight());
        vBox.setBackground(hBox.getBackground());
        vBox.setManaged(true);

        label.setAlignment(Pos.BOTTOM_CENTER);
        label.setTextFill(listArea.COLOR_OF_SOFT_ACCENTS);

        leftTriangle.setFill(listArea.COLOR_OF_CELLS);
        rightTriangle.setFill(listArea.COLOR_OF_CELLS);

        hBox.getChildren().add(paneInsideHBox1);
        hBox.setHgrow(paneInsideHBox1, Priority.ALWAYS);
        hBox.getChildren().add(label);
        hBox.getChildren().add(paneInsideHBox2);
        hBox.setHgrow(paneInsideHBox2, Priority.ALWAYS);
        hBox.getChildren().add(btn);
        hBox.getChildren().add(svgPath);

        hBox.relocate(100, 100);
        vBox.relocate(listArea.getCellWidth() + 100, 100);

        vBox.getChildren().add(paneInsideVBox1);
        vBox.setVgrow(paneInsideVBox1, Priority.ALWAYS);
        vBox.getChildren().add(progressBar);
        vBox.getChildren().add(paneInsideVBox2);
        vBox.setVgrow(paneInsideVBox2, Priority.ALWAYS);

        btn.setOnAction(event -> {
            Popup popup = new Popup();
            Label lbl1 = new Label("this");
            lbl1.setTextFill(Color.WHITE);
            Label lbl2 = new Label("that");
            lbl2.setTextFill(Color.WHITE);
            Label lbl3 = new Label("the other thing");
            lbl3.setTextFill(Color.WHITE);
            VBox vBox1 = new VBox();
            vBox1.setBackground(new Background(new BackgroundFill(listArea.COLOR_OF_CELLS, CornerRadii.EMPTY, Insets.EMPTY)));
            vBox1.setPadding(new Insets(5, 10, 5, 10));
            vBox1.getChildren().addAll(lbl1, lbl2, lbl3);
            popup.getContent().addAll(vBox1);
            popup.setAnchorX(hBox.getLayoutX() + listArea.getCellWidth() / 2);
            popup.setAnchorY(hBox.getLayoutY() + listArea.getCellHeight() / 2);
            popup.setHeight(300);
            popup.show(listArea.getStage());

        });

        Point point = determineCellPosition();

        cellGroup.setLayoutX(point.x);
        cellGroup.setLayoutY(point.y);
        cellGroup.setEffect(listArea.dropShadow);

        handleDragAndDrop();
//
//        cueReposition();
    }

    public Point determineCellPosition() {
        return listArea.getGrid().getGridMap().get(listArea.getPlan().indexOf(string));
    }

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

    public void handleDragAndDrop() {
        cellGroup.setOnMouseEntered(event -> {

        });
        cellGroup.setOnMousePressed(event -> {
            listArea.getGrid().currentDraggedFromIndex = listArea.getPlan().indexOf(string);

            preCalcSceneX = event.getSceneX();
            preCalcSceneY = event.getSceneY();
            isInListArea = false;

        });
        cellGroup.setOnMouseExited(event -> cellGroup.toBack());

        cellGroup.setOnDragDetected(event -> {
        });

        cellGroup.setOnMouseDragged(event -> {
            double offsetX = event.getSceneX() - preCalcSceneX;
            double offsetY = event.getSceneY() - preCalcSceneY;

            Group d = (Group) (event.getSource());

            cellGroup.setLayoutX(cellGroup.getLayoutX() + offsetX);
            cellGroup.setLayoutY(cellGroup.getLayoutY() + offsetY);

            /*Report the current position in Point format,
             * for use by the animation algorithm.*/
            Point newPoint;
            int x = (int) (d.getLayoutX() + offsetX);
            int y = (int) (d.getLayoutY() + offsetY);
            newPoint = new Point(x, y);
            currentPosition = newPoint;

            preCalcSceneX = event.getSceneX();
            preCalcSceneY = event.getSceneY();

            int localCurrentDraggedFromInt = listArea.getGrid().currentDraggedFromIndex;
            int updatedInsertionInt = listArea.getGrid().currentDraggedFromIndex;

            if (listArea.getPlan().contains(string)) {
                listArea.getPlan().remove(string);

                listArea.getPlan().add(localCurrentDraggedFromInt, listArea, "");
            }

            if (listArea.getPlan().contains("")) {
                updatedInsertionInt = listArea.getGrid().getIndexOfXY(listArea, currentPosition);
                listArea.getPlan().remove("");
            }

            if (!listArea.getPlan().contains("")) {
                listArea.getPlan().add(updatedInsertionInt, listArea, "");
            }
            cellGroup.toFront();
            executeReposition();
        });

        cellGroup.setOnMouseReleased(event -> {
            int indexToInsert = 0;

            if (listArea.getPlan().contains("")) {
                if (!listArea.getPlan().contains(string)) {
                    indexToInsert = listArea.getPlan().indexOf("");
                    listArea.getPlan().remove("");
                    listArea.getPlan().add(indexToInsert, listArea, string);
                }
                isInListArea = false;
            }
        });
    }

    public void cueReposition() {
        /*(Everything enclosed in listener to the ObservableList)
         * Animate a timeline transform for HBox, then for VBox.
         */
        //TODO I need to make this compatible with scrolling somehow.
        // While making them mutually exclusive would be easier,
        // the product will feel much more complete if they
        // can both happen at once.
        boolean animationPermitted = listArea.getGrid().animationPermitted(listArea,/*maybe add point here*/ this);

        if (animationPermitted) {
            executeReposition();
        }
//        listArea.getPlan().addListenerOnly().addListener((ListChangeListener.Change<? extends PlanItem> c) -> {
//            while (c.next()) {
//
//                if (c.wasAdded()) {
//                    boolean animationPermitted = listArea.getGrid().animationPermitted(listArea,/*maybe add point here*/ this);
//
//                    if (animationPermitted) {
//                        executeReposition(listArea);
//                    }
//                }
//            }
//        });
    }

    public void executeReposition() {
       final Duration SEC_2 = Duration.millis(200);
        Timeline timeline = new Timeline();
        int targetIndex;

        if (listArea.getPlan().contains(string)) {
            targetIndex = listArea.getPlan().indexOf(string);
        } else {
            targetIndex = listArea.getPlan().indexOf("");
        }

        KeyFrame end = new KeyFrame(SEC_2,
                new KeyValue(cellGroup.layoutXProperty(), listArea.getGrid().getGridMap().get(targetIndex).x),
                new KeyValue(cellGroup.layoutYProperty(), listArea.getGrid().getGridMap().get(targetIndex).y));

        timeline.getKeyFrames().add(end);
        timeline.play();
        currentPosition.x = listArea.getGrid().getGridMap().get(targetIndex).x;
        currentPosition.y = listArea.getGrid().getGridMap().get(targetIndex).y;
        timeline.setOnFinished(event -> {
        });
    }

    public void update() {
        cueReposition();
    }
}
