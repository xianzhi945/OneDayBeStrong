import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        Dimension numDim=new Dimension(50,30);
        Dimension addDim=new Dimension(10,30);
        FlowLayout fl = new java.awt.FlowLayout(FlowLayout.LEFT, 10, 10);
        frame.setLayout(fl);
        JTextField num1 = new JTextField();
        num1.setPreferredSize(numDim);
        frame.add(num1);
        JLabel add = new JLabel();
        add.setText("+");
        add.setPreferredSize(addDim);
        frame.add(add);
        JTextField num2 = new JTextField();
        num2.setPreferredSize(numDim);
        frame.add(num2);
        JButton jButton=new JButton("=");

        frame.add(jButton);

        JTextField num3 = new JTextField();
        num3.setPreferredSize(numDim);
        frame.add(num3);
        jButton.addActionListener(e -> {
            String n1=num1.getText();
            String n2=num2.getText();
            int a3=Integer.parseInt(n1)+Integer.parseInt(n2);
            num3.setText(String.valueOf(a3));
        });
        frame.setSize(500,160);
        frame.setVisible(true);
    }
}
