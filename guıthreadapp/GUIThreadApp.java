
package guıthreadapp;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class GUIThreadApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        JFrame frame = new JFrame("GUI Thread");
        frame.setSize(600, 250);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = frame.getContentPane();   
         
        JPanel panel = new JPanel();
       
        //Arayüz nesneleri
        JTextField text = new JTextField();
        text.setColumns(10);
        panel.add(text);
        
        
        JButton button = new JButton("Test");
        panel.add(button);
        
        
        JLabel label = new JLabel("Please type something...");
        panel.add(label);
        
        JProgressBar bar = new JProgressBar();
        panel.add(bar);
        bar.setValue(0);
       
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Loading...");
                String thetext = text.getText();
                Integer num = Integer.parseInt(thetext);
                
//                try{
//                    Thread.sleep(num*1000);
//                }
//                catch (Exception ex){
//                    System.out.println("Exc: "+ex);
//                }

                Thread t = new Thread( new ExampleClass(num,bar) );
                t.start();
                
                System.out.println("Girilen sayÄ±: "+num);
                
            }
        });
        
        container.add(panel);
        

        
        frame.setVisible(true);
    }
    
}

class ExampleClass implements Runnable
{

    @Override
    public void run(){
        //Agir islem
        
        for (int i = 1; i <= n; i++){
            int progress = (int) (((i * 1.0f) / n)*100.0f);
            bar.setValue(progress);
       
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ExampleClass.class.getName()).log(Level.SEVERE, null, ex);
            }        
        }

        System.out.println("Process has done!");
    }
    
    int n;
    JProgressBar bar;
    public ExampleClass(int n_, JProgressBar bar_){
        n = n_;
        bar = bar_;
    }
    
}