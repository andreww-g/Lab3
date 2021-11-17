package lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyWindow extends JFrame implements ActionListener {
    List<User> user = new ArrayList<User>();
    JLabel success = new JLabel();
    JLabel failure = new JLabel();
    JPanel contentPanel;
    JButton signUp, clear;
    JTextField userLogin;
    JPasswordField userPassword;

    public void run(){ contentPanel = new JPanel();
    ImageIcon image = new ImageIcon("smile.png");
    this.setTitle("Sign up");
    this.setSize(280,210);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
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
    userPassword = new JPasswordField(10);
    userPassword.setBounds(120,60,80,20);
    contentPanel.add(userPassword);


    signUp = new JButton("Sign up ");
    signUp.setBounds(10,110,80,20);
    signUp.addActionListener(this);
    clear = new JButton("Clear all ");
    clear.setBounds(120,110,100,22);
    clear.addActionListener(this);
    contentPanel.add(signUp);
    contentPanel.add(clear);

    success.setBounds(20, 140,200,20);
    contentPanel.add(success);
    failure.setBounds(20,140,200,20);
    contentPanel.add(failure);

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
            for(User user : user){
                if(Objects.equals(userLogin.getText(),user.getLogin())){
                    if(Objects.equals(String.valueOf(userPassword.getPassword()), user.getPassword())){
                        signUp.setBackground(Color.GREEN);
                        success.setText("You have successfully signed up!");
                    } else {signUp.setBackground(Color.red);
                    failure.setText("Something went wrong..Try again");}
                }
            }




        } else if (e.getSource() == clear){
            userLogin.setText(null);
            userPassword.setText(null);
            signUp.setBackground(null);
            success.setText(null);
            failure.setText(null);
        }
    }

}