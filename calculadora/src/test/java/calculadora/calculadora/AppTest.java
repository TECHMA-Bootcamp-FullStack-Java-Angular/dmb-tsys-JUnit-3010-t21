package calculadora.calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    private CalculadoraController calculator;
    private CalculadoraUI calWin;

    @BeforeEach
    public void setUp() {
        calWin = new CalculadoraUI(); // 
        calculator = new CalculadoraController(calWin); 
    }

    @Test
    public void testHandleClearButton() {  
        calWin.num1 = 10;
        calWin.operator = '+';
        calWin.textField.setText("5");
        calculator.handleClearButton(); 
        assertEquals(0, calWin.num1);
        assertEquals(' ', calWin.operator);
        assertEquals("", calWin.textField.getText());
    }

    @Test
    public void testHandleOperatorButton() {
    	calWin.textField.setText("5");
        calculator.handleOperatorButton("-");    
         assertEquals('-', calWin.operator);
         assertEquals(5.0, calWin.num1);
         assertEquals("", calWin.textField.getText());
    }

    @Test
    public void testHandleEqualsButton() {
        calWin.operator = '+';
        calWin.num1 = 10;
        calWin.textField.setText("5");
        calculator.handleEqualsButton();

        assertEquals(15, Double.parseDouble(calWin.textField.getText()));
        assertEquals(' ', calWin.operator);
    }

    @Test
    public void testHandleDeleteButton() {
        calWin.textField.setText("12345");
        calculator.handleDeleteButton();
        assertEquals("1234", calWin.textField.getText());
    }

    @Test
    public void testHandleSignChange() {
        calWin.textField.setText("5");
        calculator.handleSignChange();
        assertEquals("-5.0", calWin.textField.getText());
    }

    @Test
    public void testHandleNumberButton() {
        calWin.textField.setText("5");
        calculator.handleNumberButton("7");
        assertEquals("57", calWin.textField.getText());
    }  
    
}

