package com.tunepruner.fourwards.gui.newgui.cell;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CellAnimationBehaviorTest {
    static CellPlacement placement;
    static CellAnimationBehavior classToTest;

    @BeforeAll
    public static void setup(){
        classToTest = new CellAnimationBehavior();
        placement = mock(CellPlacement.class);
    }

    @Test
    void animateIn() {
//        assertTrue(2 == 3);
        classToTest.animateIn();
        verify(placement, times(2)).getPosition();
    }

    @Test
    void animateOut() {
        assertTrue(2 == 3);
    }

    @Test
    void animateTo() {
        assertTrue(2 == 3);
    }

    @Test
    void handleDrag() {
        assertTrue(2 == 3);
    }

    @Test
    void update() {
        assertTrue(2 == 3);

    }
}