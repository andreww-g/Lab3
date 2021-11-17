package lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MyWindow extends JFrame implements ActionListener {
    List<User> user = new ArrayList<User>();
    JPanel contentPanel;
    JLabel success, failure;
    JButton signUp, clear;
    JTextField userPassword, userLogin;

    public void run(){ contentPanel = new JPanel();
    ImageIcon image = new ImageIcon("smile.png");
    this.setTitle("Sign up");
    this.setSize(260,210);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setIconImage(image.getImage());
    this.add(contentPanel);


    contentPanel.setLayout(null);
    JLabel label1 = new JLabel("User");
    label1.setBounds(35,20,60,20);
    contentPanel.add(label1);
    userLogin = new JTextField(10);
    userLogin.setBounds(120,20,80,20);
    contentPanel.add(userLogin);


    JLabel label2 = new JLabel("Password");
    label2.setBounds(35,60,60,20);
    contentPanel.add(label2);
    userPassword = new JTextField(10);
    userPassword.setBounds(120,60,80,20);
    contentPanel.add(userPassword);


    signUp = new JButton("Sign up ");
    signUp.setBounds(10,110,80,20);
    signUp.addActionListener(this);
    clear = new JButton("Clear all ");
    clear.setBounds(120,110,80,20);
    clear.addActionListener(this);
    contentPanel.add(signUp);
    contentPanel.add(clear);

        user.add(new User("Zhukov","262701"));
        user.add(new User("Pochelov","390210"));
        user.add(new User("Gwiazda","211234"));
        user.add(new User("Duda","325678"));
        user.add(new User("Kloc","413425"));

        this.setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        String clickedButton = e.getActionCommand();
        System.out.println("Button " + clickedButton + "clicked");
        if(e.getSource() == signUp){



            signUp.setBackground(Color.GREEN);
        } else if (e.getSource() == clear){
            userLogin.setText(null);
            userPassword.setText(null);
            signUp.setBackground(null);
        }
    }

}