/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Shikha
 */
public class Appframe extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    
    Appframe(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLayout(null);
        
        //now we come to design compressButton
        compressButton=new JButton("select file to compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20,100,200,30);
        
        //now we come to design decompessButton
        decompressButton=new JButton("select file to decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250,100,200,30);
        
        //now i adding these two buttons to our JFrame.
        this.add(compressButton);
        this.add(decompressButton);
        
        // now i set the size of JFrame
        this.setSize(500,200);
        
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
//                System.out.println(file);
                try{
                    Compresser.method(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
//                System.out.println(file);
                
                try{
                    Decompresser.method(file);
                }
                catch(Exception exc){
                    JOptionPane.showMessageDialog(null,exc.toString());
                }
            }
        }
        
    }
}
