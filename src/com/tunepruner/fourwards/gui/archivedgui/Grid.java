package com.tunepruner.fourwards.gui.archivedgui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.awt.*;

import static org.mockito.Mockito.mock;

public class Grid {
    ObservableMap<Integer, Point> gridMap = FXCollections.observableHashMap();
    public int currentDraggedFromIndex;
    double currentScrollDirectionX = 0;
    double currentScrollDirectionY = 0;

    public void setGridMap(ObservableMap<Integer, Point> gridMap) {
        this.gridMap = gridMap;
    }

    public ObservableMap<Integer, Point> getGridMap() {
        return gridMap;}

    public Grid(ListArea listArea) {
        /*Calculate the angle of the left edge of the ListArea.*/
        double xDiff = 1;
        double yDiff = 1;

        /*Calculate the y difference and the x difference between one cell and the next.*/
        double xGridFactor = ((listArea.getCellHeight() + listArea.getCellPadding()) * xDiff)/yDiff;
        double yGridFactor = -(listArea.getCellHeight() + listArea.getCellPadding());

        /*Distribute points on that line.*/
        for ( int i = 0; i < listArea.getPlan().size(); i++) {
            Point startingPoint = new Point(
                    listArea.getTopLeft().x - listArea.getCellWidth()*2 - listArea.getCellHeight(),
                    listArea.getTopLeft().y + listArea.getAreaHeight());
            Point iteratedPoint = new Point(
                    (int) startingPoint.x + (int) xGridFactor * i,
                    (int) startingPoint.y + (int) yGridFactor * i);
            gridMap.put(i, iteratedPoint);
        }

    }

    public int getIndexOfXY(ListArea listArea, Point currentPoint) {
        int resultingIndex = currentDraggedFromIndex;
        for ( int i = 0; i < gridMap.size(); i++) {
            if (
                    Math.abs(currentPoint.y - (gridMap.get(i).y)) < listArea.getCellHeight() &&
                    Math.abs(currentPoint.x - (gridMap.get(i).x)) < listArea.getCellWidth())
            {
                resultingIndex =  i;
            }
        }
        return resultingIndex;
    }


    public boolean animationPermitted(ListArea listArea, Cell cell) {
        boolean isInList = listArea.getPlan().contains(cell.string);
        boolean isInListArea = false;
        boolean needsAnUpdate = false;
        boolean justGotDropped = false;
        boolean animationPermitted;

        for ( int i = 0; i < gridMap.size(); i++ ) {
            if (cell.currentPosition.equals(gridMap.get(i))) {
                isInListArea = true;
                cell.isInListArea = true;
                break;
            }
        }

        if (isInListArea && isInList) {
            if (listArea.getPlan().indexOf(cell.string) != getIndexOfXY(listArea, cell.currentPosition)) {
                needsAnUpdate = true;
            }
        }

        if (isInList) {
            if (!isInListArea) {
                justGotDropped = true;
//Here's the problem. Look at the code above that's suppose to turn "isInListArea to true".
            }
        }

        if (needsAnUpdate || justGotDropped) {
            animationPermitted = true;
        } else {
            animationPermitted = false;
        }

        return animationPermitted;
    }

}
