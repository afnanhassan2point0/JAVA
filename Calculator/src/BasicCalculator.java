import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

// THE CLASS : CONTAINS THE GUI OF CALCULATOR
class MyFrame extends JFrame implements ActionListener {
    // instance variables
    boolean keepTrackOfInput = false;
    double number1;
    double number2;
    double numbersAns;

    // instance objects
    JTextField valueBox1;
    JLabel operand;
    JTextField valueBox2;
    JLabel equals; // fixed symbol for =
    JTextField ansBox;

    // button objects
    // operations
    JButton clear;
    JButton ans; // for '=' sign
    JButton add;
    JButton sub;
    JButton mul;
    JButton div;
    JButton sin;
    JButton cos;
    JButton tan;
    JButton cot;
    JButton sec;
    JButton cosec;
    JButton power;
    JButton remainder;
    JButton underHood;
    JButton percentage;
    JButton log10;
    JButton logE;
    // number buttons
    JButton btn0;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton btn5;
    JButton btn6;
    JButton btn7;
    JButton btn8;
    JButton btn9;
    JButton btnMinus;
    JButton btnFloatingPoint;

    MyFrame() {
        setSize(300, 300);
        setTitle("Mini Calculator");
        Container contentPane = this.getContentPane(); // value container pane
        contentPane.setLayout(new FlowLayout());

        // navigation bar "display boxes"

        valueBox1 = new JTextField(6);
        operand = new JLabel(" ");
        valueBox2 = new JTextField(6);
        equals = new JLabel("="); // a fixed answer symbol
        ansBox = new JTextField(6);
        ansBox.setEditable(false);
        operand.setText(" ");
        equals.setText("=");

        // operation buttons

        add = new JButton("+");//
        sub = new JButton("-");//
        mul = new JButton("x");//
        div = new JButton("/");//
        ans = new JButton("=");//
        sin = new JButton("sin");
        cos = new JButton("cos");
        tan = new JButton("tan");
        cot = new JButton("cot");
        sec = new JButton("sec");
        cosec = new JButton("cosec");
        power = new JButton("^");//
        remainder = new JButton("%");//
        underHood = new JButton("root");//
        percentage = new JButton("percent");//
        log10 = new JButton("log10");//
        logE = new JButton("logE");//

        contentPane.add(valueBox1);
        contentPane.add(operand);
        contentPane.add(valueBox2);
        contentPane.add(equals);
        contentPane.add(ansBox);

        contentPane.add(add);
        contentPane.add(sub);
        contentPane.add(mul);
        contentPane.add(div);
        contentPane.add(power);
        contentPane.add(ans); // = operand
        contentPane.add(sin);
        contentPane.add(cos);
        contentPane.add(sec);
        contentPane.add(tan);
        contentPane.add(cot);
        contentPane.add(cosec);
        contentPane.add(logE);
        contentPane.add(log10);
        contentPane.add(remainder);
        contentPane.add(underHood);
        contentPane.add(percentage);

        // number buttons
        btn0 = new JButton("0");
        contentPane.add(btn0);
        btn1 = new JButton("1");
        contentPane.add(btn1);
        btn2 = new JButton("2");
        contentPane.add(btn2);
        btn3 = new JButton("3");
        contentPane.add(btn3);
        btn4 = new JButton("4");
        contentPane.add(btn4);
        btn5 = new JButton("5");
        contentPane.add(btn5);
        btn6 = new JButton("6");
        contentPane.add(btn6);
        btn7 = new JButton("7");
        contentPane.add(btn7);
        btn8 = new JButton("8");
        contentPane.add(btn8);
        btn9 = new JButton("9");
        contentPane.add(btn9);
        btnMinus = new JButton("_ve");
        contentPane.add(btnMinus);
        btnFloatingPoint = new JButton(".");
        contentPane.add(btnFloatingPoint);

        clear = new JButton("Clear");
        contentPane.add(clear);

        // events & actions registration

        valueBox1.addActionListener(this);
        valueBox2.addActionListener(this);
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        ans.addActionListener(this);
        sin.addActionListener(this);
        cos.addActionListener(this);
        tan.addActionListener(this);
        cot.addActionListener(this);
        sec.addActionListener(this);
        cosec.addActionListener(this);
        logE.addActionListener(this);
        log10.addActionListener(this);
        power.addActionListener(this);
        remainder.addActionListener(this);
        underHood.addActionListener(this);
        percentage.addActionListener(this);
        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btnMinus.addActionListener(this);
        btnFloatingPoint.addActionListener(this);
        clear.addActionListener(this);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // event driven response function for answering in textField
    public void actionPerformed(ActionEvent e) // e : event
    {
        String userValue;
        String operation;
        userValue = e.getActionCommand();
        if (userValue.equals("Clear")) // to check if the input button is CLEAR
        {
            valueBox1.setText("");
            valueBox2.setText("");
            ansBox.setText("");
            operand.setText(" ");
            keepTrackOfInput = false;
        }
        // the section of : HOW THE CALCULATIONS ARE IMPLEMENTED
        if (userValue.equals("=")) // when user presses = BUTTON
        {
            if (valueBox1.getText().isBlank() || valueBox2.getText().isBlank() || operand.getText().equals(" ")
                    || operand.getText().isEmpty()) {
                ansBox.setText("Give Inputs");
                valueBox1.setText("");
                valueBox2.setText("");
                keepTrackOfInput = false;
            } else {
                number1 = Double.parseDouble(valueBox1.getText());
                number2 = Double.parseDouble(valueBox2.getText());
                operation = operand.getText();
                switch (operation) {
                    case "+":
                        numbersAns = number1 + number2;
                        break;
                    case "-":
                        numbersAns = number1 - number2;
                        break;
                    case "x":
                        numbersAns = number1 * number2;
                        break;
                    case "/": {
                        if (number2 == 0)
                            numbersAns = 0;
                        else
                            numbersAns = number1 / number2;
                        break;
                    }
                    case "%":
                        numbersAns = number1 % number2;
                        break;
                    case "^": {
                        numbersAns = 1;
                        int baseV = (int) number1;
                        int powerV = (int) number2;
                        for (int i = 0; i < powerV; i++) {
                            numbersAns = numbersAns * baseV;
                        }
                        break;
                    }
                    case "percentage": {
                        numbersAns = (number1 / number2) * 100;
                        break;
                    }
                }
                // DISPLAYING THE FINAL ANSWER IN CALCULATOR
                numbersAns = Double.parseDouble(new DecimalFormat("#.###").format(numbersAns));
                ansBox.setText(String.valueOf(numbersAns));
            }
        }
        // the section of : HOW THE GIVEN INPUTS ARE ADDED INTO BOXES
        if (userValue.equals("0") || userValue.equals("1") || userValue.equals("2") || userValue.equals("3")
                || userValue.equals("4") || userValue.equals("5") || userValue.equals("6") || userValue.equals("7")
                || userValue.equals("8") || userValue.equals("9") || userValue.equals("_ve") || userValue.equals(".")) {
            if (!keepTrackOfInput) {
                String value1 = valueBox1.getText();
                if (userValue.equals("_ve"))
                    value1 += "-";
                else
                    value1 += userValue;
                valueBox1.setText(value1);
            }
            if (keepTrackOfInput) {
                String value2 = valueBox2.getText();
                if (userValue.equals("_ve"))
                    value2 += "-";
                else
                    value2 += userValue;
                valueBox2.setText(value2);
            }
        }
        // the section of : HOW THE GIVEN OPERATION WILL BE SHOWN IN THE CALCULATOR
        if (userValue.equals("+")) {
            operand.setText("+");
            valueBox2.setEditable(true);
            keepTrackOfInput = true;
        }
        if (userValue.equals("-")) {
            operand.setText("-");
            valueBox2.setEditable(true);
            keepTrackOfInput = true;
        }
        if (userValue.equals("x")) {
            operand.setText("x");
            valueBox2.setEditable(true);
            keepTrackOfInput = true;
        }
        if (userValue.equals("/")) {
            operand.setText("/");
            valueBox2.setEditable(true);
            keepTrackOfInput = true;
        }
        if (userValue.equals("%")) {
            operand.setText("%");
            valueBox2.setEditable(true);
            keepTrackOfInput = true;
        }
        if (userValue.equals("^")) {
            operand.setText("^");
            valueBox2.setEditable(true);
            keepTrackOfInput = true;
        }
        if (userValue.equals("root")) {
            valueBox2.setText("   ROOT");
            number1 = Double.parseDouble(valueBox1.getText());
            number1 = Math.sqrt(number1);
            number1 = Double.parseDouble(new DecimalFormat("#.###").format(number1));
            valueBox2.setEditable(false);
            ansBox.setText(String.valueOf(number1));
        }
        if (userValue.equals("percent")) {
            operand.setText("%age");
            valueBox2.setEditable(true);
            keepTrackOfInput = true;
        }
        if (userValue.equals("log10")) {
            valueBox2.setText(" LOG 10");
            number1 = Double.parseDouble(valueBox1.getText());
            number1 = Math.log10(number1);
            number1 = Double.parseDouble(new DecimalFormat("#.###").format(number1));
            valueBox2.setEditable(false);
            ansBox.setText(String.valueOf(number1));
        }
        if (userValue.equals("logE")) {
            valueBox2.setText(" LOG E");
            number1 = Double.parseDouble(valueBox1.getText());
            number1 = Math.log(number1);
            number1 = Double.parseDouble(new DecimalFormat("#.###").format(number1));
            valueBox2.setEditable(false);
            ansBox.setText(String.valueOf(number1));
        }
        if (userValue.equals("sin")) {
            valueBox2.setText("   SIN");
            number1 = Double.parseDouble(valueBox1.getText());
            number1 = Math.sin(Math.toRadians(number1));
            number1 = Double.parseDouble(new DecimalFormat("#.###").format(number1));
            valueBox2.setEditable(false);
            ansBox.setText(String.valueOf(number1));
        }
        if (userValue.equals("cos")) {
            valueBox2.setText("   COS");
            number1 = Double.parseDouble(valueBox1.getText());
            number1 = Math.cos(Math.toRadians(number1));
            number1 = Double.parseDouble(new DecimalFormat("#.###").format(number1));
            valueBox2.setEditable(false);
            ansBox.setText(String.valueOf(number1));
        }
        if (userValue.equals("sec")) {
            valueBox2.setText("   SEC");
            number1 = Double.parseDouble(valueBox1.getText());
            number1 = 1 / (Math.cos(Math.toRadians(number1)));
            number1 = Double.parseDouble(new DecimalFormat("#.###").format(number1));
            valueBox2.setEditable(false);
            ansBox.setText(String.valueOf(number1));
        }
        if (userValue.equals("tan")) {
            valueBox2.setText("   TAN");
            number1 = Double.parseDouble(valueBox1.getText());
            number1 = Math.tan(Math.toRadians(number1));
            number1 = Double.parseDouble(new DecimalFormat("#.###").format(number1));
            ansBox.setText(String.valueOf(number1));
            valueBox2.setEditable(false);
        }
        if (userValue.equals("cot")) {
            valueBox2.setText("   COT");
            number1 = Double.parseDouble(valueBox1.getText());
            number1 = 1 / (Math.tan(Math.toRadians(number1)));
            number1 = Double.parseDouble(new DecimalFormat("#.###").format(number1));
            ansBox.setText(String.valueOf(number1));
            valueBox2.setEditable(false);
        }
        if (userValue.equals("cosec")) {
            valueBox2.setText("  COSEC");
            number1 = Double.parseDouble(valueBox1.getText());
            number1 = 1 / (Math.sin(Math.toRadians(number1)));
            number1 = Double.parseDouble(new DecimalFormat("#.###").format(number1));
            ansBox.setText(String.valueOf(number1));
            valueBox2.setEditable(false);
        }
    }
}

public class BasicCalculator {
    public static void main(String[] args) {
        MyFrame mf = new MyFrame();
    }
}
