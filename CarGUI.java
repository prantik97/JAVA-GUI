package PrantikGhosh;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class CarGUI extends JFrame implements ActionListener,Serializable {
    JLabel jl1, jl2, jl3, jl4, jl5, msg,hint,jl6,jl7,jl8,jl9,jl10;
    JTextField tf1, tf2, tf3, tf4, tf5;
    JButton button1, button2, button3, button4;
    JTextArea ta;

    private int count=0;
    ArrayList<CarDemo> al = new ArrayList<>();


    public String [] brand = new String[3];
    public String [] carModel = new String[3];
    public String [] regNo= new String[3];
    public String [] ownerName= new String[3];
    public String [] mobile= new String[3];


    CarGUI() {
        setTitle("Car Registration");
        setSize(1200, 650);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        jl1 = new JLabel("Brand Name");
        jl1.setBounds(20, 50, 100, 20);
        c.add(jl1);

        tf1 = new JTextField();
        tf1.setBounds(130, 50, 200, 20);
        c.add(tf1);

        jl2 = new JLabel("Model");
        jl2.setBounds(20, 100, 100, 20);
        c.add(jl2);

        tf2 = new JTextField();
        tf2.setBounds(130, 100, 200, 20);
        c.add(tf2);

        jl3 = new JLabel("Registration No.");
        jl3.setBounds(20, 150, 100, 20);
        c.add(jl3);

        tf3 = new JTextField();
        tf3.setBounds(130, 150, 200, 20);
        c.add(tf3);

        jl4 = new JLabel("Owner Name");
        jl4.setBounds(20, 200, 100, 20);
        c.add(jl4);

        tf4 = new JTextField();
        tf4.setBounds(130, 200, 200, 20);
        c.add(tf4);

        jl5 = new JLabel("Owner Mobile");
        jl5.setBounds(20, 250, 100, 20);
        c.add(jl5);

        tf5 = new JTextField();
        tf5.setBounds(130, 250, 200, 20);
        c.add(tf5);

        ta = new JTextArea();
        ta.setBounds(450,50,600,300);
        c.add(ta);

        jl6 = new JLabel("Brand Name");
        jl6.setBounds(450, 10, 120, 20);
        c.add(jl6);

        jl7 = new JLabel("Model");
        jl7.setBounds(570, 10, 120, 20);
        c.add(jl7);

        jl8 = new JLabel("Registration No.");
        jl8.setBounds(690, 10, 120, 20);
        c.add(jl8);

        jl9 = new JLabel("Owner Name");
        jl9.setBounds(810, 10, 120, 20);
        c.add(jl9);

        jl10 = new JLabel("Owner Mobile");
        jl10.setBounds(930, 10, 120, 20);
        c.add(jl10);




        button1 = new JButton("STORE");
        button1.setFocusable(false);
        button1.setBounds(130, 300, 100, 25);
        c.add(button1);

        button1.addActionListener(this);

        button4 = new JButton("RESET");
        button4.setFocusable(false);
        button4.setBounds(130, 330, 100, 25);
        c.add(button4);

        button4.addActionListener(this);

        button2 = new JButton("SHOW");
        button2.setFocusable(false);
        button2.setBounds(330, 300, 100, 25);
        c.add(button2);

        button2.addActionListener(this);

        button3 = new JButton("SUBMIT");
        button3.setFocusable(false);
        button3.setBounds(330, 330, 100, 25);
        c.add(button3);

        button3.addActionListener(this);







        msg = new JLabel("");
        msg.setBounds(20, 350, 250, 20);
        c.add(msg);


        hint = new JLabel("*HINT : 1)Store -- to save the details \t 2)Show-- Show the details and clear the fields\t  3)Submit-- final submit & create the .ser file ");
        hint.setBounds(20, 370, 800, 200);
        c.add(hint);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button2) {
            try {
                FileInputStream input = new FileInputStream("Carinfo2.ser");
                ObjectInputStream in = new ObjectInputStream(input);
                ArrayList al = (ArrayList<CarDemo>)in.readObject();
                Iterator it = al.iterator();
                while(it.hasNext()){
                    CarDemo ce4 = (CarDemo)it.next();
//                    CarDemo ce5 = (CarDemo)it.next();
//                    CarDemo ce6 = (CarDemo)it.next();

                    ta.append(ce4.compName+ "\t\t"+ce4.model + "\t\t"+ ce4.regNo+"\t"+ ce4.ownerName+ "\t"+ ce4.mobile+"\n");//+ce4.compName+ "\t"+ce5.model + "\t "+ ce5.regNo+"\t "+ ce5.ownerName+ "\t "+ ce5.mobile+"\n"+ce6.compName+ "\t "+ce6.model + "\t "+ ce6.regNo+"\t "+ ce6.ownerName+ "\t "+ ce6.mobile+"\n");
                }
                in.close();
            } catch (Exception o) {System.out.println(o);}


        }
        if(e.getSource()==button4){

            tf1.setText(null);
            tf2.setText(null);
            tf3.setText(null);
            tf4.setText(null);
            tf5.setText(null);

        }
        if (e.getSource() == button3) {

            CarDemo ce4 = new CarDemo(brand[0], carModel[0], regNo[0], ownerName[0], mobile[0]);
            CarDemo ce5 = new CarDemo(brand[1], carModel[1], regNo[1], ownerName[1], mobile[1]);
            CarDemo ce6 = new CarDemo(brand[2], carModel[2], regNo[2], ownerName[2], mobile[2]);
            al.add(ce4);
            al.add(ce5);
            al.add(ce6);
            try {
                FileOutputStream fileout = new FileOutputStream("Carinfo2.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileout);
                out.writeObject(al);
                out.flush();
                out.close();
                fileout.close();
            } catch (IOException ee) {
                System.out.println(ee);

            }
//            msg.setText("object info saved !!");
            JOptionPane.showMessageDialog(this,"Objects Are Saved","Success",JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == button1) {
            if (tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty() || tf4.getText().isEmpty() || tf5.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,"Remaining fields can't be empty","Warning!",JOptionPane.WARNING_MESSAGE);

            } else {

                try {
                    brand[count] = tf1.getText();
                    carModel[count] = tf2.getText();
                    regNo[count] = tf3.getText();
                    ownerName[count] = tf4.getText();
                    mobile[count] = tf5.getText();

                    System.out.println(brand[count]);
                    System.out.println(carModel[count]);
                    System.out.println(regNo[count]);
                    System.out.println(ownerName[count]);
                    System.out.println(mobile[count]);
                    count++;

                } catch (ArrayIndexOutOfBoundsException ae) {
                    System.out.println(ae);
                }
            }
        }
    }


    public static void main(String[] args) {
        CarGUI car = new CarGUI();
        System.out.println("Form created!!");
    }

}


class CarDemo implements Serializable {
    public String compName;
    public String model;
    public String regNo;
    public String ownerName;
    public String mobile;

    CarDemo(String compName, String model, String regNo, String ownerName, String mobile) {
        this.compName = compName;
        this.model = model;
        this.regNo = regNo;
        this.ownerName = ownerName;
        this.mobile = mobile;

    }


}


