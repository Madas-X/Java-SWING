/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//import java.util.EventObject;
/**
 *
 * @author student
 */
public class JavaApplication3 extends JFrame implements ActionListener,ItemListener,ChangeListener
{
    String Gender;
    Container contener = this.getContentPane();
    JLabel name = new JLabel("Imię:");
    JLabel surname = new JLabel("Nazwisko:");
    JLabel gender = new JLabel("Płeć:");
    JLabel wiek = new JLabel("Wiek:");
    JLabel zwierz = new JLabel("Wybierz zwierzęta, które posiadasz w domu:");
    JTextField field = new JTextField(10);
    JTextField sur_filed = new JTextField(10);
    JSpinner age = new JSpinner();
    JRadioButton gend = new JRadioButton();
    JRadioButton men,women;
    String dane[]={"kot","pist","papuga","malpa","bober"};
    JList zwierzaki = new JList(dane);
    JScrollPane listScr = new JScrollPane(zwierzaki);
    JPanel myPanel = new JPanel();
    JButton b1,b2,b3;
    JavaApplication3(String tytul_okna){
        super(tytul_okna);
        SpringLayout kontener = new SpringLayout();
        contener.setBackground(new Color(130,206,235));
        contener.setLayout(kontener);
        gend.setLayout(new BoxLayout(gend,BoxLayout.X_AXIS));
        gend.setSize(280, 30);
            men = new JRadioButton("Mężczyzna",false);
            women = new JRadioButton("Kobieta",false);
            gend.add(men);
            gend.add(women);
        zwierzaki.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        zwierzaki.setVisibleRowCount(3);
        zwierzaki.setLayoutOrientation(JList.VERTICAL_WRAP);
        zwierzaki.setVisible(false);
        listScr.setPreferredSize(new Dimension(170,50));
        myPanel.setLayout(new BoxLayout(myPanel,BoxLayout.X_AXIS));
        myPanel.setSize(280, 30);
                b1 = new JButton("Zatwierdz");
                b2 = new JButton("Anuluj");
                b3 = new JButton("Sprawdz");
                myPanel.add(b1);
                myPanel.add(b2);
                myPanel.add(b3);
        kontener.putConstraint(SpringLayout.WEST, name, 20,SpringLayout.WEST, contener);
        kontener.putConstraint(SpringLayout.NORTH, name, 10,SpringLayout.NORTH, contener);
        kontener.putConstraint(SpringLayout.WEST, surname, 20,SpringLayout.WEST, contener);
        kontener.putConstraint(SpringLayout.NORTH, surname, 30,SpringLayout.NORTH, name);
        kontener.putConstraint(SpringLayout.WEST, gender, 20,SpringLayout.WEST, contener);
        kontener.putConstraint(SpringLayout.NORTH, gender, 30,SpringLayout.NORTH, surname);
        kontener.putConstraint(SpringLayout.WEST, wiek, 20,SpringLayout.WEST, contener);
        kontener.putConstraint(SpringLayout.NORTH, wiek, 35,SpringLayout.NORTH, gender);
        kontener.putConstraint(SpringLayout.WEST, zwierz, 20,SpringLayout.WEST, contener);
        kontener.putConstraint(SpringLayout.NORTH, zwierz, 30,SpringLayout.NORTH, wiek);
        kontener.putConstraint(SpringLayout.WEST, field, 80,SpringLayout.WEST, name);
        kontener.putConstraint(SpringLayout.NORTH, field, 10,SpringLayout.NORTH, contener);
        kontener.putConstraint(SpringLayout.WEST, sur_filed, 80,SpringLayout.WEST, surname);
        kontener.putConstraint(SpringLayout.NORTH, sur_filed, 30,SpringLayout.NORTH, field);
        kontener.putConstraint(SpringLayout.WEST, age, 60,SpringLayout.WEST, wiek);
        kontener.putConstraint(SpringLayout.NORTH, age, 35,SpringLayout.NORTH, gender);
        kontener.putConstraint(SpringLayout.WEST, gend, 60,SpringLayout.WEST, gender);
        kontener.putConstraint(SpringLayout.NORTH, gend, 30,SpringLayout.NORTH, surname);
        kontener.putConstraint(SpringLayout.WEST, listScr, 20,SpringLayout.WEST, contener);
        kontener.putConstraint(SpringLayout.NORTH, listScr, 50,SpringLayout.NORTH, zwierz);
        kontener.putConstraint(SpringLayout.WEST, myPanel,50,SpringLayout.WEST, contener);
        kontener.putConstraint(SpringLayout.NORTH, myPanel,15,SpringLayout.SOUTH, listScr);
        add(age);
        add(name);
        add(surname);
        add(wiek);
        add(gender);
        add(sur_filed);
        add(field);
        add(zwierz);
        add(gend);
        add(listScr);
        add(myPanel);
        b3.addActionListener(this);
        b2.addActionListener(this);
        b1.addActionListener(this);
        sur_filed.addActionListener(this);
        men.addItemListener(this);
        women.addItemListener(this);
        age.addChangeListener(this);
        sur_filed.setEditable(true);
        field.setEditable(true);
        age.setEnabled(false);   
        men.setEnabled(false);
        women.setEnabled(false);
        zwierzaki.setEnabled(false);
        setSize(400,400);
        this.setVisible(true);
       
    }
    @Override
     public void actionPerformed(ActionEvent e){

          if(e.getSource().equals(b3)){
              if(field.getText().equals("") || sur_filed.getText().equals("")){
                 JOptionPane.showMessageDialog(null, "Wprowadz dane", "Błąd walidacji", JOptionPane.ERROR_MESSAGE);
              }
              else{  
                    men.setEnabled(true);
                    women.setEnabled(true);
              }
          }
          if(e.getSource().equals(b2)){
             JOptionPane.showMessageDialog(null, "Operacja anulowana nastąpi zamknięcie programu", "Błąd walidacji", JOptionPane.ERROR_MESSAGE);
             System.exit(0);
          } 
          if(e.getSource().equals(b1)){
             JOptionPane.showMessageDialog(null, "Imie: "+field.getText()+" Nazwisko: "+sur_filed.getText()+" płeć: "+Gender+" wiek: "+age.getValue()+
                     " zwierze: "+zwierzaki.getToolTipText(), "Wprowadzone dane", JOptionPane.ERROR_MESSAGE);
          } 
     }
     @Override
     public void itemStateChanged(ItemEvent e){
         if (e.getStateChange() == ItemEvent.SELECTED) {
             if(men.hasFocus()){
             Gender="Męzczyzna";
             }
             if(women.hasFocus()){
             Gender = "Kobieta";
             }
            men.setEnabled(false);
            women.setEnabled(false);
            age.setEnabled(true); 
            zwierzaki.setVisible(true);
        } else {
             JOptionPane.showMessageDialog(null, "Wybierz płeć", "Błąd walidacji", JOptionPane.ERROR_MESSAGE);
        }
    }
      @Override
      public void stateChanged(ChangeEvent e) {
          //if(e.equals(b1)){
            zwierzaki.setEnabled(true);
          //}
      }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JavaApplication3 World = new JavaApplication3("Aplikacja");
        
    }
    
}
