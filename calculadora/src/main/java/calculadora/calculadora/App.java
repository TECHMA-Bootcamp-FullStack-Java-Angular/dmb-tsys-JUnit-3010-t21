package calculadora.calculadora;

public class App {

	public static void main(String[] args) {

		CalculadoraUI calWin;

		try {
			calWin = new CalculadoraUI();
			calWin.frame.setVisible(true);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
