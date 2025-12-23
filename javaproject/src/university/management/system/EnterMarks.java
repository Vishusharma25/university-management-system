package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class EnterMarks extends JFrame implements ActionListener {

    Choice crollno;
    JComboBox cbsemester;
    JTextField tfsub1, tfsub2, tfsub3, tfsub4, tfsub5;
    JTextField tfmarks1, tfmarks2, tfmarks3, tfmarks4, tfmarks5;
    JButton cancel, submit;

    EnterMarks() {

        setSize(1000, 500);
        setLocation(300, 150);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 400, 300);
        add(image);

        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50, 70, 150, 20);
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(200, 70, 150, 20);
        add(crollno);

        try {
            Conn c = new Conn();
            if (c.s != null) {
                ResultSet rs = c.s.executeQuery("select * from student");
                while (rs.next()) {
                    crollno.add(rs.getString("rollno"));
                }
            } else {
                crollno.add("15331641 (Demo)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ... GUI Components (Skipping) ...

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                Conn c = new Conn();
                if (c.s != null) {
                    String query1 = "insert into subject values('" + crollno.getSelectedItem() + "', '"
                            + cbsemester.getSelectedItem() + "', '" + tfsub1.getText() + "', '" + tfsub2.getText()
                            + "', '"
                            + tfsub3.getText() + "', '" + tfsub4.getText() + "', '" + tfsub5.getText() + "')";
                    String query2 = "insert into marks values('" + crollno.getSelectedItem() + "', '"
                            + cbsemester.getSelectedItem() + "', '" + tfmarks1.getText() + "', '" + tfmarks2.getText()
                            + "', '" + tfmarks3.getText() + "', '" + tfmarks4.getText() + "', '" + tfmarks5.getText()
                            + "')";

                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Marks Inserted Successfully (Demo Mode)");
                }
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}
