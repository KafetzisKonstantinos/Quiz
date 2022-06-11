import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JPanel implements ActionListener {

    String[] questions=     {
                            "What is OTP?",
                            "What is SAML?",
                            "What is SSH?",
                            "What is Blueprint in Python?"
                            };

    String[][] options=     {
                            {"One Time Password","I don't know","One Time Performance","One Time Print"},
                            {"Security Access Markup Language","Single Authentication Method Language ","Security Assertion Markup Language","I don't know"},
                            {"Secure Shell History","Single Sign History","Secure Shell Html","Secure Socket Shell"},
                            {"Blue letters","Collection of views and templates","Blue background","Blue foreground"}
                            };

    char[] answers=         {
                            'A',
                            'C',
                            'D',
                            'B'
                            };
    int index;
    int seconds=10;
    int total_questions=questions.length;
    int percent;
    int correct_guess;
    char answer;

    JTextField questionNum=new JTextField();
    JTextArea question=new JTextArea();
    JButton buttonA=new JButton();
    JButton buttonB=new JButton();
    JButton buttonC=new JButton();
    JButton buttonD=new JButton();
    JButton startButton=new JButton();
    JLabel labelA=new JLabel();
    JLabel labelB=new JLabel();
    JLabel labelC=new JLabel();
    JLabel labelD=new JLabel();
    JLabel labelBottom=new JLabel();
    JLabel timeLeft=new JLabel();
    JLabel results=new JLabel();
    JLabel percentage=new JLabel();
    Timer  timer=new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            timeLeft.setText("Time Left: "+ String.valueOf(seconds)+ " Sec");
            if(seconds<=0){
                displayAnswer();
            }
        }
    });

    Quiz(){
        this.setSize(650,650);
        this.setLocation(0,0);
        this.setBackground(new Color(50,50,50));
        this.setLayout(null);

        questionNum.setBounds(0,0,650,50);
        questionNum.setBackground(new Color(86, 101, 115 ));
        questionNum.setForeground(Color.WHITE);
        questionNum.setEditable(false);
        questionNum.setBorder(null);
        questionNum.setFont(new Font("Arial",Font.BOLD,25));
        questionNum.setHorizontalAlignment(JTextField.CENTER);
        questionNum.setBorder(BorderFactory.createSoftBevelBorder(3));
        questionNum.setText("Quiz Game");

        question.setBounds(0,50,650,40);
        question.setBackground(new Color(41, 128, 185 ));
        question.setForeground(Color.WHITE);
        question.setFont(new Font("Arial", Font.PLAIN,35));
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setBorder(BorderFactory.createSoftBevelBorder(3));
        question.setText("Ready to Play?");
        question.setEditable(false);
        question.setOpaque(true);

        buttonA.setBounds(5,130,80,80);
        buttonA.setFont(new Font("Arial",Font.PLAIN,35));
        buttonA.setBackground(new Color(174, 214, 241 ));
        buttonA.setText("A");
        buttonA.setFocusable(false);
        buttonA.setOpaque(true);
        buttonA.setBorder(null);
        buttonA.setEnabled(false);
        buttonA.addActionListener(this);

        labelA.setBounds(85,130,560,80);
        labelA.setBackground(new Color(214, 219, 223));
        labelA.setFont(new Font("Arial",Font.PLAIN,25));
        labelA.setOpaque(true);
        labelA.setBorder(null);

        buttonB.setBounds(5,230,80,80);
        buttonB.setFont(new Font("Arial",Font.PLAIN,35));
        buttonB.setBackground(new Color(174, 214, 241 ));
        buttonB.setText("B");
        buttonB.setFocusable(false);
        buttonB.setOpaque(true);
        buttonB.setBorder(null);
        buttonB.setEnabled(false);
        buttonB.addActionListener(this);

        labelB.setBounds(85,230,560,80);
        labelB.setBackground(new Color(214, 219, 223));
        labelB.setFont(new Font("Arial",Font.PLAIN,25));
        labelB.setOpaque(true);
        labelB.setBorder(null);

        buttonC.setBounds(5,330,80,80);
        buttonC.setFont(new Font("Arial",Font.PLAIN,35));
        buttonC.setBackground(new Color(174, 214, 241 ));
        buttonC.setText("C");
        buttonC.setFocusable(false);
        buttonC.setOpaque(true);
        buttonC.setBorder(null);
        buttonC.setEnabled(false);
        buttonC.addActionListener(this);

        labelC.setBounds(85,330,560,80);
        labelC.setBackground(new Color(214, 219, 223));
        labelC.setFont(new Font("Arial",Font.PLAIN,25));
        labelC.setOpaque(true);
        labelC.setBorder(null);

        buttonD.setBounds(5,430,80,80);
        buttonD.setFont(new Font("Arial",Font.PLAIN,35));
        buttonD.setBackground(new Color(174, 214, 241 ));
        buttonD.setText("D");
        buttonD.setFocusable(false);
        buttonD.setOpaque(true);
        buttonD.setBorder(null);
        buttonD.setEnabled(false);
        buttonD.addActionListener(this);

        labelD.setBounds(85,430,560,80);
        labelD.setBackground(new Color(214, 219, 223));
        labelD.setFont(new Font("Arial",Font.PLAIN,25));
        labelD.setOpaque(true);
        labelD.setBorder(null);

        labelBottom.setBounds(0,550,650,80);
        labelBottom.setBackground(new Color(30,129,176));
        labelBottom.setOpaque(true);

        startButton.setBounds(260,560,120,50);
        startButton.setText("Start");
        startButton.setFont(new Font("Arial",Font.BOLD,15));
        startButton.setForeground(new Color(93, 109, 126));
        startButton.setFocusable(false);
        startButton.addActionListener(e-> nextQuestion());


        timeLeft.setBounds(500,560,120,50);
        timeLeft.setForeground(Color.WHITE);
        timeLeft.setFont(new Font("Arial",Font.BOLD,15));
        timeLeft.setVisible(false);

        results.setBounds(5,250,500,50);
        results.setBackground(new Color(75,172,205,255));
        results.setForeground(Color.WHITE);
        results.setFont(new Font("Arial",Font.PLAIN,30));
        results.setHorizontalAlignment(JTextField.CENTER);
        results.setOpaque(true);
        results.setVisible(false);

        percentage.setBounds(5,350,500,50);
        percentage.setBackground(new Color(75,172,205,255));
        percentage.setForeground(Color.WHITE);
        percentage.setFont(new Font("Arial",Font.PLAIN,30));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setOpaque(true);
        percentage.setVisible(false);

        this.add(percentage);
        this.add(results);
        this.add(timeLeft);
        this.add(startButton);
        this.add(labelBottom);
        this.add(labelD);
        this.add(buttonD);
        this.add(labelC);
        this.add(buttonC);
        this.add(labelB);
        this.add(buttonB);
        this.add(labelA);
        this.add(buttonA);
        this.add(questionNum);
        this.add(question);
        this.setVisible(true);

    }

    public void nextQuestion(){

        if(index>=total_questions){
            results();

        }
        else{
            timeLeft.setVisible(true);
            buttonA.setEnabled(true);
            buttonB.setEnabled(true);
            buttonC.setEnabled(true);
            buttonD.setEnabled(true);
            timeLeft.setVisible(true);
            startButton.setVisible(false);
            questionNum.setText("Question Num: "+ (index+1));
            question.setText(questions[index]);
            labelA.setText(options[index][0]);
            labelB.setText(options[index][1]);
            labelC.setText(options[index][2]);
            labelD.setText(options[index][3]);
            timer.start();
        }

    }
    public void displayAnswer(){
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(answers[index]=='A'){
            labelA.setBackground(Color.GREEN);
        }

        if(answers[index]=='B'){
            labelB.setBackground(Color.GREEN);
        }
        if(answers[index]=='C'){
            labelC.setBackground(Color.GREEN);
        }
        if(answers[index]=='D'){
            labelD.setBackground(Color.GREEN);
        }

        Timer pause=new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelA.setBackground(new Color(214, 219, 223));
                labelB.setBackground(new Color(214, 219, 223));
                labelC.setBackground(new Color(214, 219, 223));
                labelD.setBackground(new Color(214, 219, 223));
                answer=' ';
                seconds=10;
                timeLeft.setText("Time Left: "+ String.valueOf(seconds)+ " Sec");
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();

    }
    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        buttonA.setVisible(false);
        buttonB.setVisible(false);
        buttonC.setVisible(false);
        buttonD.setVisible(false);

        labelA.setVisible(false);
        labelB.setVisible(false);
        labelC.setVisible(false);
        labelD.setVisible(false);

        timeLeft.setVisible(false);

        questionNum.setText("Quiz Game");
        question.setText("Results");

        percent=(int)((correct_guess/(double)total_questions)*100);
        results.setText("Correct Answers: "+correct_guess+"/"+total_questions);
        percentage.setText("Percentage: "+ percent+"%");
        results.setVisible(true);
        percentage.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(e.getSource()==buttonA){
            answer='A';
            if(answers[index]==answer){
                correct_guess++;
            }
        }

        if(e.getSource()==buttonB){
            answer='B';
            if(answers[index]==answer){
                correct_guess++;
            }
        }

        if(e.getSource()==buttonC){
            answer='C';
            if(answers[index]==answer){
                correct_guess++;
            }
        }

        if(e.getSource()==buttonD){
            answer='D';
            if(answers[index]==answer){
                correct_guess++;
            }
        }
        displayAnswer();
    }
}
