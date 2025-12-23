package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
// import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class FeeStructure extends JFrame implements ActionListener {

    FeeStructure() {
        setSize(1000, 700);
        setLocation(250, 50);
        setLayout(null);

        // getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50, 10, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JTable table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee");

            // Manual ResultSet to TableModel
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();

            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rsmd.getColumnName(i));
            }

            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 60, 1000, 700);
        jsp.setOpaque(false);
        jsp.getViewport().setOpaque(false);
        add(jsp);

        // Background Image
        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
            Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0, 0, 1000, 700);
            add(image);
        } catch (Exception e) {
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new FeeStructure();
    }
}
