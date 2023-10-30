package calculadora.calculadora;


public class CalculadoraController {
    private CalculadoraUI calWin;

    public CalculadoraController(CalculadoraUI calWin) {
        this.calWin = calWin;
    }

	

	public  void handleClearButton() {	
		
		calWin.num1 = 0;
		calWin.operator = ' ';
		calWin.textField.setText("");
	}
	
	
	/**
	*  Almacena este operador en la variable estática para su posterior uso en cálculos.
	*  Luego, limpia el campo de texto de la calculadora para que el usuario pueda ingresar el siguiente número.
	*
	* @param buttonText El texto del botón de operador presionado que se utilizará para realizar operaciones.
	*/
	public void handleOperatorButton(String buttonText) {
		
		calWin.operator = buttonText.charAt(0);
		System.out.println(calWin.operator);
		calWin.num1 = Double.parseDouble( calWin.textField.getText());
		
		calWin.textField.setText("");
	}

	/**
	 * Realiza el cálculo y muestra el resultado de la operación pendiente en la calculadora.
	*/
	public  void handleEqualsButton() {
		double num2 = Double.parseDouble( calWin.textField.getText());
		double result = 0;
		switch ( calWin.operator) {
		case '+':
			result =  calWin.num1 + num2;
			break;
		case '-':
			result =  calWin.num1 - num2;
			break;
		case '*':
			result =  calWin.num1 * num2;
			break;
		case '/':
			result =  calWin.num1 / num2;
			break;
		}
		calWin.textField.setText(String.valueOf(result));
		calWin.operator = ' ';
	}

	/**
	 * Borra el último carácter del texto en el campo de texto de la calculadora.
	 */
	public  void handleDeleteButton() {
		String currentText =  calWin.textField.getText();
		if (!currentText.isEmpty()) {
			calWin.textField.setText(currentText.substring(0, currentText.length() - 1));
		}
	}

	/**
	* Cambia el signo del número actualmente en el campo de texto de la calculadora.
	*/
	public  void handleSignChange() {
		
		String currentText =  calWin.textField.getText();
		if (!currentText.isEmpty()) {
			double currentNumber = Double.parseDouble(currentText);
			currentNumber *= -1;
			calWin.textField.setText(String.valueOf(currentNumber));
		}
	}

	/**
	* Este método toma el texto del botón numérico presionado y lo agrega al campo de texto de la calculadora, 
	* lo que permite que el usuario ingrese números para realizar cálculos.
	*
	* @param buttonText El texto del botón numérico presionado que se debe agregar al campo de texto.
	*/
	public void handleNumberButton(String buttonText) {
		calWin.textField.setText( calWin.textField.getText() + buttonText);
	}

}
