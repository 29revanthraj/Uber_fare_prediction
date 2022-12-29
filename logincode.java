//Login page start
package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class LoginFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel,passwordLabel,l;
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton registerButton = new JButton("REGISTER");
    JCheckBox showPassword = new JCheckBox("Show Password");


    LoginFrame() throws IOException {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {

        container.setLayout(null);
    }

    public void setLocationAndSize()  {
        l  = new JLabel("WELCOME TO UBER LOGIN");
        l.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        l.setBounds(50, 50, 480, 40);

        userLabel = new JLabel("USERNAME :");
        userLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        userLabel.setBounds(100, 150, 130, 30);

        passwordLabel = new JLabel("PASSWORD :");
        passwordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        passwordLabel.setBounds(100, 220, 130, 30);

        userTextField.setBounds(240, 150, 200, 30);
        passwordField.setBounds(240, 220, 200, 30);

        showPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        showPassword.setBounds(260, 250, 150, 30);

        loginButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        loginButton.setBounds(110, 300, 150, 30);

        registerButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        registerButton.setBounds(280, 300, 150, 30);
        setVisible(true);
    }

    public void addComponentsToContainer() {
        container.add(l);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(registerButton);
        container.setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("src/loginimg.jpg"));
        container.add(background);
    }
    public void addActionEvent() {
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("test@gmail.com") && pwdText.equalsIgnoreCase("12345")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                setVisible(false);
                new data();


            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        if (e.getSource() == registerButton) {
            setVisible(false);
            new MyFrame();
            //MyFrame.setVisible(true);


        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }

}
class Login {
    public static void main(String[] a) throws IOException {
        LoginFrame frame = new LoginFrame();
        frame.setTitle("Team Uber");
        frame.setVisible(true);
        frame.setBounds(10, 10, 600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }

}
