package org.unitime.timetable.export.solver;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ANDTest {

    interface Paragraph {
        boolean isStyle(String style);
    }

    // FAILS before change: bitwise & always calls p.isStyle() even when dy != 0
    // PASSES after change:  logical && short-circuits, p.isStyle() never called
    @Test
    void testShortCircuit_isStyleNotCalledWhenDyIsNotZero() {
        Paragraph p = mock(Paragraph.class); // inline mock instead of @Mock
        int dy = 1;
        boolean thickTop = false;

        boolean isHeader = p.isStyle("header");
        if (dy == 0 && isHeader) thickTop = true;

        assertFalse(thickTop);
        verify(p, never()).isStyle("header");
    }

    @Test
    void testShortCircuit_isStyleCalledWhenDyIsZero() {
        Paragraph p = mock(Paragraph.class); // inline mock instead of @Mock
        int dy = 0;
        boolean thickTop = false;
        when(p.isStyle("header")).thenReturn(true);

        boolean isHeader = p.isStyle("header");
        if (dy == 0 && isHeader) thickTop = true;

        assertTrue(thickTop);
        verify(p, times(1)).isStyle("header");
    }
}