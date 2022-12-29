//User data code starts
package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

class data
        extends JFrame
        implements ActionListener{

    private Container f;
    private JLabel l;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JLabel l5;
    private JLabel l6;
    private JLabel date;
    private JTextField t1;
    private JTextField t2;
    private JTextField t4;
    private JTextField t3;
    private JTextField t5;
    private JComboBox city;
    private JComboBox time;
    private JComboBox clock;
    private Button next1;
    private String[] citys = {"Hyderabad", "Chennai", "Bangalore", "Vijayawada", "Ongole"};
    private String times[] = {"1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00",
            "8:00", "9:00", "10:00", "11:00", "12:00"};
    private String clocks[] = {"AM", "PM"};

    public data()
    {
        setTitle("User data");
        setBounds(300, 90, 600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        f = getContentPane();
        f.setLayout(null);

        l = new JLabel("Welcome to UBER Services ");
        l.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        l.setBounds(120, 20, 350, 40);
        f.add(l);

        l2 = new JLabel("Contact number           : ");
        l2.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        l2.setBounds(50, 100, 210, 20);
        t2 = new JTextField();
        t2.setBounds(250, 100, 250, 25);
        f.add(l2);
        f.add(t2);


        l3 = new JLabel("Conform your Email id : ");
        l3.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        l3.setBounds(50, 150, 210, 20);
        t3 = new JTextField();
        t3.setBounds(250, 150, 250, 25);
        f.add(l3);
        f.add(t3);

        l6 = new JLabel("Select City                : ");
        l6.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        l6.setBounds(50, 200, 210, 20);
        city = new JComboBox(citys);
        city .setBounds(250, 200, 250, 30);
        city.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        f.add(l6);
        f.add(city );

        l4 = new JLabel("Pickup location       : ");
        l4.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        l4.setBounds(50, 280, 210, 20);
        t4 = new JTextField();
        t4.setSize(250, 75);
        t4.setLocation(250, 250);
        f.add(l4);
        f.add(t4);

        l5 = new JLabel("Destination location  : ");
        l5.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        l5.setBounds(50, 370, 210, 20);
        t5 = new JTextField();
        t5.setBounds(250, 350, 250, 80);
        f.add(l5);
        f.add(t5);

        date = new JLabel("Pickup Time : ");
        date.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        date.setBounds(130, 450, 150, 30);
        f.add(date);

        time = new JComboBox(times);
        time.setBounds(270, 450, 65, 30);
        time.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        f.add(time);

        clock = new JComboBox(clocks);
        clock.setBounds(340, 450, 65, 30);
        clock.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        f.add(clock);

        next1 = new Button("Next");
        next1.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        next1.setBounds(235, 500, 100, 50);
        f.add(next1);
        next1.addActionListener(this);
        f.setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("src/userimg.jpg"));
        f.add(background);
        f.setVisible(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == next1) {
            String con = t2.getText();
            String aad = t3.getText();
            String pick = t4.getText();
            String dest = t5.getText();
            Component frame = null;
            int i1 = String.valueOf(con).length();
            int i2 = String.valueOf(aad).length();
            int i4 = String.valueOf(pick).length();
            int i5 = String.valueOf(dest).length();

            if ((i1 == 10) && (i2 != 0)  && (i4 != 0) && (i5 != 0))
            {
                JOptionPane.showMessageDialog(null, "< Your details are sucessfully saved >");
                setVisible(false);
                new vehframe();

            } else {
                JOptionPane.showMessageDialog(null, "# Please enter the details");
            }
        }
        else{
            setVisible(false);
        }

    }
}
class user {

    public static void main(String[] args) throws Exception
    {
        com.company.MyFrame f = new com.company.MyFrame();
    }
}


