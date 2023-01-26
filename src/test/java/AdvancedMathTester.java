import org.example.AdvancedMath;
import org.example.BasicMath;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AdvancedMathTester {
    @InjectMocks
    AdvancedMath advancedMath = new AdvancedMath();

    @Mock
    BasicMath basicMath;

    // Test 1
    @Test
    public void testMultiplyDifferenceBy5() {
        // Given
//        when(basicMath.subtract(80.0,20.0)).thenReturn(60.0);
        given(basicMath.subtract(80.0, 20.0)).willReturn(60.0);

        // When
        Assert.assertEquals(advancedMath.multiplyDifferenceBy5(80.0, 20.0),300.0, 0);

        // Then

    }
    // Test 2
    @Test
    public void testMultiplySumBy5() {
        // Given
//        when(basicMath.add(75.0,25.0)).thenReturn(100.0);
//        when(basicMath.multiply(100.0, 5)).thenReturn(500.0);
        given(basicMath.add(75.0, 25.0)).willReturn(100.0);
        given(basicMath.multiply(100.0, 5)).willReturn(500.0);

        // When
        Assert.assertEquals(advancedMath.multiplySumBy5(75.0, 25.0),500.0, 0);

        // Then

    }
    // Test 3
    @Test
    public void testSquareOfSum() {
        // Given
//        when(basicMath.add(20.0,20.0)).thenReturn(40.0);
        given(basicMath.add(20.0, 20.0)).willReturn(40.0);

        // When
//        advancedMath.squareOfSum(20.0, 20.0);
        Assert.assertEquals(advancedMath.squareOfSum(20.0, 20.0),1600.0, 0);

        // Then
        verify(basicMath, atLeast(2)).add(20.0,20.0);
        verify(basicMath, times(2)).add(20.0,20.0);

    }
    // Test 4
    @Test
    public void testGetPercentage() {
        // Given
//        when(basicMath.divide(50.0, 100.0)).thenReturn(.5);
        given(basicMath.divide(50.0, 100.0)).willReturn(.5);
        doThrow(new ArithmeticException("Division by zero")).when(basicMath).divide(50.0, 0.0);

        // When
        Assert.assertEquals(advancedMath.getPercentage(50.0, 100.0),50.0, 0);

        reset(basicMath);
        Assert.assertEquals(advancedMath.getPercentage(50.0, 100.0),00.0, 0);

        // Then

    }

}
