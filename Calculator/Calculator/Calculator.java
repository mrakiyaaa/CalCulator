import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;

    Font myFont = new Font("Poppins", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    String operator;

    Calculator() {


        //Define Colors
        Color darkblueFade = new Color(32,37,45);
        Color IceBlue = new Color(202,233,255);
        Color BgColor = new Color(13,16,22);

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        frame.getContentPane().setBackground(BgColor); //background color

        // Resizable frame
        frame.setResizable(false);

        //customize the window decorations
        frame.setUndecorated(false);
        // frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setBackground(darkblueFade);
        textField.setForeground(IceBlue);
        frame.add(textField);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;


        // Apply custom colors to specific function buttons as an example
        addButton.setBackground(darkblueFade);
        subButton.setBackground(darkblueFade);
        mulButton.setBackground(darkblueFade);
        divButton.setBackground(darkblueFade);
        decButton.setBackground(darkblueFade);
        equButton.setBackground(darkblueFade);
        delButton.setBackground(darkblueFade);
        clrButton.setBackground(darkblueFade);

        // Apply text color to specific function buttons
        addButton.setForeground(IceBlue);
        subButton.setForeground(IceBlue);
        mulButton.setForeground(IceBlue);
        divButton.setForeground(IceBlue);
        decButton.setForeground(IceBlue);
        equButton.setForeground(IceBlue);
        delButton.setForeground(IceBlue);
        clrButton.setForeground(IceBlue);

        
        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(darkblueFade);
            functionButtons[i].setForeground(IceBlue);

        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(darkblueFade);
            numberButtons[i].setForeground(IceBlue);
        }

        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        frame.add(delButton);
        frame.add(clrButton);
        frame.setVisible(true);
        
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4, 4, 10, 10)); 

        panel.setBackground(BgColor);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);

        panel.add(mulButton);
        panel.add(decButton);

        panel.add(numberButtons[0]);

        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         
        for(int i=0; i<10; i++){
            if (e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }



        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = "+";
            textField.setText("");
        }

        if (e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = "-";
            textField.setText("");
        }

        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = "x";
            textField.setText("");
        }

        if (e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = "/";
            textField.setText("");
        }

        if (e.getSource() == equButton){
            
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;

                case "-":
                    result = num1 - num2;
                    break;

                case "x":
                    result = num1 * num2;
                    break;

                case "/":
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrButton){
            textField.setText("");
        }

        if (e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i < string.length() - 1; i++){
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
    }

}
    

