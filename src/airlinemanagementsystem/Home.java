
package airlinemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener {
    
    public Home()
    {
        setLayout(null);
        
//        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/plane1.png"));
//        JLabel image=new JLabel(i1);
//        image.setBounds(0,0,1600,800);
//        add(image);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/plane2.png"));
        Image i2 = i1.getImage().getScaledInstance(1600, 800, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(0,0,1600,800);
        add(lblimage);
        
        JLabel heading=new JLabel("<html>WELCOME<br>TO<br>CLOUD9 AIRLINES</html>");
        heading.setBounds(50,40,1000,300);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Times New Roman",Font.BOLD,68));
        lblimage.add(heading);
        
        JLabel subheading = new JLabel("Where Comfort Meets the Sky !!!");
        subheading.setBounds(900, 550, 1000, 30);
        subheading.setFont(new Font("Cosmic sans ms", Font.ITALIC, 30));
        subheading.setForeground(Color.black);
        lblimage.add(subheading);
        
        JMenuBar menubar=new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details=new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails=new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails=new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem bookFlight=new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem journeyDetails=new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        JMenuItem ticketCancellation=new JMenuItem("Cancel Ticket");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
       JMenu ticket=new JMenu("Ticket");
        menubar.add(ticket);
        
        JMenuItem boardingPass=new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(this);
        ticket.add(boardingPass);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);  //open the frame in full screen
        setLocation(600,250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String text=ae.getActionCommand();
        if (text.equals("Add Customer Details"))
        {
            new AddCustomer();
        } else if (text.equals("Flight Details")) 
        {
            new FlightInfo();
        } else if (text.equals("Book Flight")) 
        {
            new BookFlight();
        } else if (text.equals("Journey Details")) 
        {
            new JourneyDetails();
        } else if (text.equals("Cancel Ticket")) 
        {
            new Cancel();
        }
        else if (text.equals("Boarding Pass")) 
        {
            new BoardingPass();
        }
    }
    
    public static void main(String args[])
    {
        new Home();
    }
    
}

