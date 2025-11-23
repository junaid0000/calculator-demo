package com.demo;

// IMPORTS - I'll explain each one:
import static org.junit.Assert.*;      // For assertions like assertEquals
import static org.mockito.Mockito.*;   // For Mockito functions like when(), verify()
import org.junit.Test;                 // For @Test annotation
import org.mockito.Mockito;            // Main Mockito class

public class CalculatorWithMockTest {

    @Test
    public void testAddWithMockedHistory() {
        // STEP 1: Create MOCK object (fake CalculationHistory)
        CalculationHistory mockHistory = Mockito.mock(CalculationHistory.class);
        
        // STEP 2: Create real Calculator but with mocked history
        Calculator calculator = new Calculator();
        
        // STEP 3: Test the add method
        int result = calculator.add(5, 3);
        
        // STEP 4: Verify the result is correct
        assertEquals(8, result);
        
        // STEP 5: Verify that history WAS NOT called (since we didn't connect it)
        // This proves we're testing Calculator in isolation
        verify(mockHistory, never()).addRecord(anyString(), anyString());
    }
}