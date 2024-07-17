
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;


public class JourneyDetails extends JFrame implements ActionListener
{
    JTable table;
    JTextField pnr;
    JButton show;
    
    public JourneyDetails() {
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        JLabel heading = new JLabel("Journey Details");
        heading.setBounds(250, 20, 500, 35);
        heading.setFont(new Font("Time New Roman", Font.BOLD, 32));
        heading.setForeground(Color.DARK_GRAY);
        add(heading);
        
        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpnr.setBounds(50, 100, 100, 25);
        add(lblpnr);
        
        pnr = new JTextField();
        pnr.setBounds(160, 100, 120, 25);
        add(pnr);
        
        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(290, 100, 120, 25);
        show.addActionListener(this);
        add(show);
        
        table = new JTable();
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 200, 800, 150);
        jsp.setBackground(Color.WHITE);
        add(jsp);
        
        setSize(800, 500);
        setLocation(400, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from reservation where PNR = '"+pnr.getText()+"'");
            
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "No Information Found");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JourneyDetails();
    }
}

