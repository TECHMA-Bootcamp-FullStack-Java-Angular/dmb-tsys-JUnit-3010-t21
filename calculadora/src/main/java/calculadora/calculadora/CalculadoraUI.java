package calculadora.calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraUI {
	
	public JFrame frame;
	public  JTextField textField;
	public double num1;
	public char operator;

	public CalculadoraUI() {
		
	        frame = new JFrame("Calculadora");
	        frame.setResizable(false);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(260, 360);
	        frame.setLocationRelativeTo(null);
	        JPanel panel = new JPanel(new GridLayout(5, 5));

	        textField = new JTextField();
	        textField.setForeground(Color.YELLOW);
	        textField.setBackground(Color.BLACK);
	        textField.setText("");
	        textField.setFont(new Font("Agency FB", Font.BOLD, 50));
	        textField.setHorizontalAlignment(JTextField.RIGHT);
	        frame.getContentPane().add(textField, BorderLayout.NORTH);

	        String[] buttonLabels = {
	            "1", "2", "3", "+",
	            "4", "5", "6", "-",
	            "7", "8", "9", "*",
	            "-/+", "0", ".", "/",
	            "Del", "C", "" ,"="
	        };

	        for (String label : buttonLabels) {
	            JButton button = new JButton(label);
	            button.setBackground(new Color(73, 94, 87));
	            button.setForeground(Color.WHITE);
	            
	            if (label.equals("-") || label.equals("*") || label.equals("/")|| label.equals("+")) {
	                button.setBackground(new Color(174, 222, 252));
	                button.setForeground(Color.BLACK);
	            }
	            
	            if (label.equals("=")) {
	            	button.setBackground(new Color(174, 195, 174));
	            	button.setForeground(Color.BLACK);
	            }
	            if (label.equals("Del") || label.equals("C") ) {
	            	button.setBackground(new Color(255, 135, 178));
	            	button.setForeground(Color.BLACK);
	            }
	            
	            panel.add(button);
	            button.addActionListener(new ButtonClickListener());
	        }

	        frame.getContentPane().add(panel, BorderLayout.CENTER);

	        

	    }

	private class ButtonClickListener implements ActionListener {
		private CalculadoraController cal;
		
	    public void actionPerformed(ActionEvent e) {
	    	 cal = new CalculadoraController(CalculadoraUI.this);
	    	
	        JButton source = (JButton) e.getSource();
	        String buttonText = source.getText();
	        switch (buttonText) {
	            case "C":
	            case "AC":
	            	cal.handleClearButton();
	                break;
	            case "+":
	            case "-":
	            case "*":
	            case "/":
	            	cal.handleOperatorButton(buttonText);
	                break;
	            case "=":
	            	cal.handleEqualsButton();
	                break;
	            case "Del":
	            	cal.handleDeleteButton();
	                break;
	            case "-/+":
	            	cal.handleSignChange();
	                break;
	            default:
	            	cal.handleNumberButton(buttonText);
	                break;
	        }
	    }

	}

}
