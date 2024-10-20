package br.edu.fatec.sjc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class NumberAscOrderTest {

    private CustomStack<Number> mockStack;

    @BeforeEach
    public void setup() {
        mockStack = Mockito.mock(CustomStack.class);
    }

    @Test
    public void testSortWithNumbers() throws StackEmptyException {
        when(mockStack.isEmpty()).thenReturn(false, false, false, false, false, false, true);
        when(mockStack.pop())
                .thenReturn(12)
                .thenReturn(7)
                .thenReturn(5)
                .thenReturn(9)
                .thenReturn(23)
                .thenReturn(1);

        NumberAscOrder numberAscOrder = new NumberAscOrder(mockStack);
        List<Number> sortedNumbers = numberAscOrder.sort();

        Number[] expected = {1, 5, 7, 9, 12, 23};
        assertArrayEquals(expected, sortedNumbers.toArray());

        verify(mockStack, times(6)).pop();
    }

    @Test
    public void testSortWithEmptyStack() throws StackEmptyException {
        when(mockStack.isEmpty()).thenReturn(true);

        NumberAscOrder numberAscOrder = new NumberAscOrder(mockStack);
        List<Number> sortedNumbers = numberAscOrder.sort();

        assertTrue(sortedNumbers.isEmpty());

        verify(mockStack, never()).pop();
    }
}
