package com.tunepruner.fourwards.gui.newgui.cell;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class CellAnimationBehaviorTest {

    //https://www.baeldung.com/mockito-verify
    //https://www.baeldung.com/mockito-spy
    //https://www.tutorialsteacher.com/ioc

    static CellPlacement placement;
    static CellAnimationBehavior classToTestMock;
    static CellAnimationBehavior classToTestReal;

    @BeforeAll
    public static void setup(){
        placement = mock(CellPlacement.class);
        classToTestMock = mock(CellAnimationBehavior.class);
        classToTestReal = new CellAnimationBehavior(placement);
    }

    @Test
    void animateInIsCalled() {
        assertTrue(false);
    }

    @Test
    void animateOutIsCalled() {
        classToTestMock.animateOut();
        verify(classToTestMock, times(2)).animateOut();
    }

    @Test
    void animateToIsCalled() {
        classToTestMock.animateTo();
        verify(classToTestMock, times(2)).animateTo();
    }

    @Test
    void handleDragIsCalled() {
        classToTestMock.handleDrag();
        verify(classToTestMock, times(2)).handleDrag();
    }

    @Test
    void ifUpdateIsCalled() {
        classToTestMock.update();
        verify(classToTestMock, times(2)).update();

    }

}