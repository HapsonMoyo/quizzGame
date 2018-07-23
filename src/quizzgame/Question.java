/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizzgame;

import java.awt.Container;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
public class Question extends JPanel implements ActionListener {
int correctAns;
Quiz quiz;
int selected;
boolean used;
//questions
JTextArea jtxtDisplay = new JTextArea();

//answers
JPanel aPanel = new JPanel();
JRadioButton[] responses;
ButtonGroup group= new ButtonGroup();
//button
JPanel botPanel = new JPanel();
JButton next = new JButton("Next");
JButton finish = new JButton("Finish");

public Question(String q,String[]options, int ans,Quiz quiz){
    this.quiz= quiz;
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    correctAns = ans;
    //question
    jtxtDisplay.add(new JTextArea(q));
    add(jtxtDisplay);
    //answer
    responses = new JRadioButton[options.length];
    for(int i=0; i<options.length; i++ ){
        responses[i]= new JRadioButton(options[i]);
        responses[i].addActionListener(this);
        group.add(responses[i]);
        aPanel.add(responses[i]);
    }
    add(aPanel);
    //bottom
    next.addActionListener(this);
    finish.addActionListener(this);
    botPanel.add(next);
    botPanel.add(finish);
    add(botPanel);
}

public void actionPerformed(ActionEvent e){
   Object src = e.getSource();
   //next button
   if(src.equals(next)){
       showResult();
       if(selected == correctAns ){
           used = true;
           quiz.next();
       }
   }
   //finish button
   if(src.equals(finish)){
       quiz.showSummary();
   }
   //radio button
   for(int i = 0; i<responses.length; i++){
       if(src == responses[i]){
           selected = i;
       }
   }
       
   } 
public void showResult() {
    String text =responses[selected].getText();
    quiz.totals++;
    if(selected == correctAns){
        JOptionPane.showMessageDialog(null,text+"\t Correct press OK ");
    }else{
        quiz.wrongs++;
        JOptionPane.showMessageDialog(null,text + "Sorry Wrong Answer press next");
    }
}

}
