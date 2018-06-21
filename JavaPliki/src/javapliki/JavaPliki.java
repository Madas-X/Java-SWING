/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapliki;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
/**
 *
 * @author student
 */
public class JavaPliki extends JFrame implements ActionListener {
    
    Container container = this.getContentPane();
    SpringLayout springLayout = new SpringLayout();
    JEditorPane TextArea = new JEditorPane();
    JButton open = new JButton("Open");
    JButton save = new JButton("Save");
    public JavaPliki(){
        container.setLayout(springLayout);
        TextArea.setPreferredSize(new Dimension(200,200));
        springLayout.putConstraint(SpringLayout.WEST, TextArea,20,SpringLayout.WEST, container);
        springLayout.putConstraint(SpringLayout.NORTH, TextArea,10,SpringLayout.NORTH, container);
        springLayout.putConstraint(SpringLayout.WEST, open,20,SpringLayout.WEST, container);
        springLayout.putConstraint(SpringLayout.NORTH, open,210,SpringLayout.NORTH, TextArea);
        springLayout.putConstraint(SpringLayout.WEST, save,120,SpringLayout.WEST, open);
        springLayout.putConstraint(SpringLayout.NORTH, save,210,SpringLayout.NORTH, TextArea);
        container.add(open);
        open.addActionListener(this);
        container.add(TextArea);
        container.add(save);
        save.addActionListener(this);
        setVisible(true);
        setSize(300,300);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(open)){
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
            {
                try 
                {
                    File file = fc.getSelectedFile();
                    String path = file.getAbsolutePath();
                    String line, tekst = new String();
                    BufferedReader br = new BufferedReader(new FileReader(path));
                    while ((line = br.readLine()) != null) {
                        tekst += line;
                    }
                    br.close();
                    TextArea.setText(tekst);
                }catch (IOException ex)
                {

                }
            }
        }else
        {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) 
            {
            File file = fc.getSelectedFile();
            String path = file.getAbsolutePath();
               try {
                    BufferedWriter wr = new BufferedWriter(new FileWriter(path));
                    wr.write(TextArea.getText());
                    wr.close();
                } catch (IOException ex) {
                   // Logger.getLogger(WeWy.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JavaPliki pliki =  new JavaPliki();
        
    }
    
}
