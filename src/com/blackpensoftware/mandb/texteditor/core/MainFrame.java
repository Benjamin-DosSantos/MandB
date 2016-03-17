package com.blackpensoftware.mandb.texteditor.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainFrame {
	 public static void main(String args[]){
		 // Colors //
		 Color mainpanel_bgcolor = Color.DARK_GRAY;
		 
		 // Integers //
		 int mainframe_xSize = 800,
		     mainframe_ySize = 600,
		     mainframe_xPos = 0,
		     mainframe_yPos = 0;
		 
		 int textfield_xSize = mainframe_xSize - 35,
		     textfield_ySize = mainframe_ySize - 120, 
		     textfield_xPos = 10,
		     textfield_yPos = 70,
		     textfield_rows = 32,
		     textfield_columns = 70;
		 
		 
		 int savebutton_xSize = 100,
		     savebutton_ySize = 100,
		     savebutton_xPos = 0,
		     savebutton_yPos = 0;
		 
		 int loadbutton_xSize = 100,
			 loadbutton_ySize = 100,
			 loadbutton_xPos = 150,
			 loadbutton_yPos = 0;
		 
		 // Strings //
		 String mainframe_name = "Text Editor";
		 String savebutton_text = "Save";
		 String loadbutton_text = "Load";
		 
		 // JFrames //  
		 final JFrame mainframe = new JFrame(mainframe_name);
		 
		 // JPanels //
		 final JPanel mainpanel = new JPanel();	
		 
		 // JTextArea // 
		 final JTextArea maintextarea = new JTextArea(null, textfield_rows, textfield_columns);
		 
		 // JButton // 
		 JButton savebutton = new JButton(savebutton_text);
		 JButton loadbutton = new JButton(loadbutton_text);
		 
		 // Implementation //
		 
		 // All JFrames // 
		 JFrame.setDefaultLookAndFeelDecorated(true);
		 
		 // JScrollPane // 
		 //JScrollPane scrollpane = new JScrollPane(maintextarea);
         		 
		 // MainPanel // 
		 mainpanel.setBackground(mainpanel_bgcolor);
		 mainpanel.setLayout(new FlowLayout());
		 
		 // JButton // 
    	 savebutton.setBounds(savebutton_xSize, savebutton_ySize, savebutton_xPos, savebutton_yPos);
		 savebutton.setVisible(true);
		 savebutton.setVerticalTextPosition(AbstractButton.CENTER);
         savebutton.setToolTipText("Click This Button To Save.");
         
         loadbutton.setBounds(loadbutton_xSize, loadbutton_ySize, loadbutton_xPos, loadbutton_yPos);
         loadbutton.setVisible(true);
         loadbutton.setVerticalTextPosition(AbstractButton.CENTER);
         loadbutton.setToolTipText("Click This Button To Load A File.");
         
         savebutton.addActionListener(new ActionListener() {
        	 
             public void actionPerformed(ActionEvent e)
             {
            	 FileWriter pw = null;
            	 String fileName = "default";
            	 
            	 fileName = JOptionPane.showInputDialog("Please enter a file name and extention."); 
            	 
				try {
					pw = new FileWriter (fileName);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
     		    try {
					maintextarea.write(pw);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} //Object of JTextArea
             }
         });      

         
        loadbutton.addActionListener(new ActionListener() {
        	 
             public void actionPerformed(ActionEvent e)
             {

            	 final JFileChooser fc = new JFileChooser();
                 fc.showOpenDialog(mainframe);
                 BufferedReader in = null;
                 try {
                     in = new BufferedReader(new FileReader(fc.toString()));
                     String str;
                     while ((str = in.readLine()) != null) {
                         maintextarea.append(str);
                     }
                 } catch (IOException e1) {
                 } finally {
                     try { in.close(); } catch (Exception ex) { }
                 }
               
             }
         });      
         
         // JTextArea// 
		 maintextarea.setLineWrap(true);
		 maintextarea.setVisible(true);
		 maintextarea.setWrapStyleWord(true);
		 
		 mainpanel.add(savebutton);
		 mainpanel.add(loadbutton);
		 mainpanel.add(maintextarea);
		// mainpanel.add(scrollpane);
		 
		 // MainFrame // 
		 mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 mainframe.setAlwaysOnTop(false);
		 mainframe.setVisible(true);
		 mainframe.add(mainpanel);
		 mainframe.setSize(new Dimension(mainframe_xSize, mainframe_ySize));
		 mainframe.setLocation(new Point(mainframe_xPos, mainframe_yPos));
 
	 }// End of main method 
}// End of class
