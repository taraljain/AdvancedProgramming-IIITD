package APRefresher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    static JFrame f;
    static JTextField l;
    String s0,s1,s2;

    Calculator(){
        s0=s1=s2="";
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.'){ // Input is a Number
            if(!s1.equals("")){
                s2=s2+s;
            }
            else{
                s0=s0+s;
            }
            l.setText(s0+s1+s2);
        }
        else if(s.charAt(0)=='='){ // Input is EqualTo sign
            double te=evaluator();
            l.setText(s0 + s1 + s2 + "=" + te);
            s0 = Double.toString(te);
            s1 = s2 = "";
        }
        else { // Input is an Operator
            /* Two Cases:
               (i) No Operator (ii) Operator
               (i) Initial: 2+ , then you enter another operator e.g. +, -, *, / ; replace with new
                   or, Initial: 2, then you enter operator; simply make s1 equal to operator */
            if (s1.equals("") || s2.equals("")) {
                s1 = s;
            }
            else { // (ii) Initial: 2+3, then you enter another operator; evaluate and make s0=evaluated value, s1=operator, s2=empty
                double te=evaluator();
                s0 = Double.toString(te);
                s1 = s;
                s2 = "";
            }
            l.setText(s0 + s1 + s2); // (2+3+) will look like (5+)
        }
    }

    public double evaluator(){
        double te;
        switch (s1) {
            case "+":
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                break;
            case "-":
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                break;
            case "/":
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                break;
            default:
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));
                break;
        }
        return te;
    }

    public static void main(String[] args) {
        f = new JFrame("Calculator");
        Calculator c = new Calculator();
        l = new JTextField(16);
        l.setEditable(false);

        String[] buttons = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2","3","-","0",".","=", "+",};
        JPanel p = new JPanel(); p.add(l);
        for (String i : buttons) {
            JButton button = new JButton(i);
            button.addActionListener(c);
            p.add(button);
        }

        p.setBackground(Color.BLUE); f.add(p);
        f.setSize(200,200);
        f.show();
    }
}