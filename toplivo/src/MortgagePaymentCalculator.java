
 
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.*;
 //начало
public class MortgagePaymentCalculator {
    private JTextField CreditField;
    private JLabel CreditLabel;
    private JLabel rubLabel;
    private JTextField srokField;
    private JLabel srokLabel;
    private JLabel yearsLabel;
    private JTextField stavkaField;
    private JLabel stavkaLabel;
    private JLabel procentLabel;
    private JButton calcButton;
    private JLabel resultLabel;
    private JFrame mainFrame;
    
    MortgagePaymentCalculator() {
    	  CreditLabel = new JLabel("Сумма кредита(не меньше 1000)");
	        CreditField = new JTextField( "0");
	        CreditField.setHorizontalAlignment(JTextField.RIGHT);
	        rubLabel = new JLabel("руб");
	        srokLabel = new JLabel("Срок кредита (в годах)");
	        srokField = new JTextField("0");
	        srokField.setHorizontalAlignment(JTextField.RIGHT);
	        yearsLabel = new JLabel("лет");
	        stavkaLabel = new JLabel("Годовая процентная ставка");
	        stavkaField = new JTextField("0");
	        stavkaField.setHorizontalAlignment(JTextField.RIGHT);
	        procentLabel = new JLabel("%");
	        calcButton = new JButton("Рассчитать");
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double Credit = Double.parseDouble(CreditField.getText());
                    int srok = Integer.parseInt(srokField.getText());
                    double stavka = Double.parseDouble(stavkaField.getText());
                    if(srok <=0 || Credit < 1000 || stavka < 0.01){
                    	resultLabel.setText("Проверьте введённые данные");
                    	
                    }else{
                    stavka /= 100.0;
                	stavka /= 12.0;		
                		srok = srok * 12;    
                		Credit = 	(Credit*stavka) / (1-Math.pow(1+stavka, -srok));		
                		NumberFormat currencyFormat =  	NumberFormat.getCurrencyInstance();
                    
            resultLabel.setText("<html>На срок <font style='color: red; font-weight: bold;'>" + srok + 
           "</font> месяца, ежемесячная выплата составит <font style='color: red; font-weight: bold;'>" +
            		currencyFormat.format(Credit) + "</font> </html>");}
                }
                catch ( NumberFormatException nfe ) {
                    resultLabel.setText("Проверьте введённые данные");
                }
            }
        });
        
        

        
        
        
        resultLabel = new JLabel("Введите данные для рассчёта");
        
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.insets = new Insets(10, 40, 10, 10);
        
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.WEST;//west
        constraints.ipadx = 90;
        constraints.gridy = 0;
        layout.setConstraints(CreditLabel, constraints);
        constraints.gridy = 1;
        layout.setConstraints(srokLabel, constraints);
        constraints.gridy = 2;
        layout.setConstraints(stavkaLabel, constraints);
        
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.ipadx = 50;
        constraints.gridy = 0;
        layout.setConstraints(CreditField, constraints);
        constraints.gridy = 1;
        layout.setConstraints(srokField, constraints);
        constraints.gridy = 2;
        layout.setConstraints(stavkaField, constraints);
        
        constraints.gridx = 2;
        constraints.ipadx = 0;
        constraints.gridy = 0;
        layout.setConstraints(rubLabel, constraints);
        constraints.gridy = 1;
        layout.setConstraints(yearsLabel, constraints);
        constraints.gridy = 2;
        layout.setConstraints(procentLabel, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.anchor = GridBagConstraints.EAST;
        layout.setConstraints(calcButton, constraints);
        
        constraints.gridy = 5;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        layout.setConstraints(resultLabel, constraints);
        
        mainFrame = new JFrame("Кредитный калькулятор");
        mainFrame.setSize(600, 450);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(layout);
        
        mainFrame.add(CreditLabel);
        mainFrame.add(srokLabel);
        mainFrame.add(stavkaLabel);
        mainFrame.add(CreditField);
        mainFrame.add(srokField);
        mainFrame.add(stavkaField);
        mainFrame.add(rubLabel);
        mainFrame.add(yearsLabel);
        mainFrame.add(procentLabel);
        mainFrame.add(calcButton);
        mainFrame.add(resultLabel);
        
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MortgagePaymentCalculator();
            }
        });
    }
 
}