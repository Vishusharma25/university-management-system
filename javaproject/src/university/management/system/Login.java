package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, cancel;
    JTextField tfusername, tfpassword;

    Login() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 20);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 20);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 20);
        add(tfpassword);

        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
            Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(350, 0, 200, 200);
            add(image);
        } catch (Exception e) {
            // If image is missing, just ignore
        }

        JLabel hint = new JLabel("Default: admin / 12345");
        hint.setBounds(40, 180, 200, 20);
        hint.setForeground(Color.RED);
        hint.setFont(new Font("Tahoma", Font.ITALIC, 12));
        add(hint);

        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = tfusername.getText();
            String password = tfpassword.getText();

            try {
                Conn c = new Conn();
                // If DB connection failed (missing jar), c.s will be null.
                if (c.s == null) {
                    if (username.equals("admin") && password.equals("12345")) {
                        setVisible(false);
                        new Project();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                    }
                } else {
                    String query = "select * from login where username='" + username + "' and password='" + password
                            + "'";
                    try {
                        ResultSet rs = c.s.executeQuery(query);
                        if (rs.next()) {
                            setVisible(false);
                            new Project();
                        } else {
                            // Fallback if DB connects but table empty/invalid
                            if (username.equals("admin") && password.equals("12345")) {
                                setVisible(false);
                                new Project();
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid username or password");
                            }
                        }
                    } catch (Exception e) {
                        // If query errors (e.g. table missing)
                        if (username.equals("admin") && password.equals("12345")) {
                            setVisible(false);
                            new Project();
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid username or password");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                // Fallback if query fails
                if (username.equals("admin") && password.equals("12345")) {
                    setVisible(false);
                    new Project();
                }
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
