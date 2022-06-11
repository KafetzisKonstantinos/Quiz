import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QuizFrame extends JFrame{

    Quiz quiz;

    QuizFrame(){
        this.setSize(650,650);
        this.setTitle("Quiz");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(50,50,50));
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        quiz=new Quiz();


        this.add(quiz);
        this.setVisible(true);
    }


}
