import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
//
public class GUI
{
    private javax.swing.Timer myTimer1;
    public static final int ONE_SEC = 1000;   //time step in milliseconds
    public static final int TENTH_SEC = 100;
    private Font myClockFont = new Font("Serif", Font.PLAIN, 50);
    private JPanel topPanel, bottomPanel;
    private int clockTick = 0;     //number of clock ticks; tick can be 1.0 s or 0.1 s
    private double clockTime = ((double)clockTick)/10.0;;   //time in seconds
    private String clockTimeString = new Double(clockTime).toString();
    private JLabel timeLbl = new JLabel(clockTimeString);
    public static void main(String[] args)
    {
        JFrame frame= new JFrame();
        frame.setSize(200, 100); frame.setTitle("Kakooma"); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        JButton newGame5= new JButton("New Game(5)"); newGame5.setBackground(Color.gray); 
            newGame5.setOpaque(true); newGame5.setEnabled(true);
        JButton newGame6= new JButton("New Game(6)"); newGame6.setBackground(Color.gray);
            newGame6.setOpaque(true); newGame6.setEnabled(true);
        //
        JBox body= JBox.vbox(newGame5, newGame6);
        //
        frame.add(body); frame.setVisible(true);
        //
        JEventQueue events= new JEventQueue(); events.listenTo(newGame5, "wasNewGamePentagonButtonPressed"); 
            events.listenTo(newGame6, "wasNewGameHexagonButtonPressed");
        while(true)
        {
            EventObject event=events.waitEvent(); String name=events.getName(event);
            if (name.equals("wasNewGamePentagonButtonPressed"))
            {
                JProgressBar initNewGame = new JProgressBar();
                initNewGame.setStringPainted(true); initNewGame.setBorderPainted(true);
                JFrame saveFrame= new JFrame();
                saveFrame.setSize(200, 200); saveFrame.setTitle("Starting New Game...");
                saveFrame.add(JBox.vbox(JBox.vglue(), initNewGame, JBox.vglue())); saveFrame.setVisible(true);
                for (int k=0; k<=100; k++)
                {
                    initNewGame.setValue(k);
                    try
                    {
                        Thread.sleep(10);                 //1000 milliseconds is one second.
                    }
                    catch(InterruptedException e)
                    {
                        Thread.currentThread().interrupt();
                    }
                }
                GUI adb = new GUI();
                adb.showGUI(5); saveFrame.dispose();
            }
            else if (name.equals("wasNewGameHexagonButtonPressed"))
            {
                JProgressBar initNewGame = new JProgressBar();
                initNewGame.setStringPainted(true); initNewGame.setBorderPainted(true);
                JFrame saveFrame= new JFrame();
                saveFrame.setSize(200, 200); saveFrame.setTitle("Starting New Game...");
                saveFrame.add(JBox.vbox(JBox.vglue(), initNewGame, JBox.vglue())); saveFrame.setVisible(true);
                for (int k=0; k<=100; k++)
                {
                    initNewGame.setValue(k);
                    try
                    {
                        Thread.sleep(10);                 //1000 milliseconds is one second.
                    }
                    catch(InterruptedException e)
                    {
                        Thread.currentThread().interrupt();
                    }
                }
                GUI adb = new GUI();
                adb.showGUI(6); saveFrame.dispose();
            }
        }
    }
    public void showGUI(int n)
    {
        if (n==5)
        {
            JFrame game= new JFrame();
            game.setSize(600, 200);
            AdditionSet adb= new AdditionSet(5);
            int[][] numbers= adb.getNumbers();
            int[] answers= adb.getAnswers();
            //
            JButton newGame = new JButton("New Game");
            newGame.setOpaque(true);
            newGame.setEnabled(true);
            newGame.setBackground(Color.BLACK);
            //
            myTimer1 = new javax.swing.Timer(TENTH_SEC, new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    clockTick++;
                    clockTime = ((double)clockTick)/10.0;
                    clockTimeString = new Double(clockTime).toString();
                    timeLbl.setText(clockTimeString);
                    //System.out.println(clockTime);
                }
            });
            newGame.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    clockTick = 0;
                    clockTime = ((double)clockTick)/10.0;
                    clockTimeString = new Double(clockTime).toString();
                    timeLbl.setText(clockTimeString);
                    myTimer1.start();
                }
            });
            
            
            JButton one = new JButton(""+numbers[0][0]); one.setOpaque(true);
                one.setEnabled(true); one.setBackground(Color.RED);
            JButton two= new JButton(""+numbers[0][1]); two.setOpaque(true);
                two.setEnabled(true); two.setBackground(Color.RED);
            JButton three= new JButton(""+numbers[0][2]); three.setOpaque(true);
                three.setEnabled(true); three.setBackground(Color.RED);
            JButton four= new JButton(""+numbers[0][3]); four.setOpaque(true);
                four.setEnabled(true); four.setBackground(Color.RED);
            JButton five= new JButton(""+numbers[0][4]); five.setOpaque(true);
                five.setEnabled(true); five.setBackground(Color.RED);
                //
            JButton six= new JButton(""+numbers[1][0]); six.setOpaque(true);
                six.setEnabled(true); six.setBackground(Color.BLUE);
            JButton seven= new JButton(""+numbers[1][1]); seven.setOpaque(true);
                seven.setEnabled(true); seven.setBackground(Color.BLUE);
            JButton eight= new JButton(""+numbers[1][2]); eight.setOpaque(true);
                eight.setEnabled(true); eight.setBackground(Color.BLUE);
            JButton nine= new JButton(""+numbers[1][3]); nine.setOpaque(true);
                nine.setEnabled(true); nine.setBackground(Color.BLUE);
            JButton ten= new JButton(""+numbers[1][4]); ten.setOpaque(true);
                ten.setEnabled(true); ten.setBackground(Color.BLUE);
                //
            JButton eleven= new JButton(""+numbers[2][0]); eleven.setOpaque(true);
                eleven.setEnabled(true); eleven.setBackground(Color.GREEN);
            JButton twelve= new JButton(""+numbers[2][1]); twelve.setOpaque(true);
                twelve.setEnabled(true); twelve.setBackground(Color.GREEN);
            JButton one3= new JButton(""+numbers[2][2]); one3.setOpaque(true);
                one3.setEnabled(true); one3.setBackground(Color.GREEN);
            JButton one4= new JButton(""+numbers[2][3]); one4.setOpaque(true);
                one4.setEnabled(true); one4.setBackground(Color.GREEN);
            JButton one5= new JButton(""+numbers[2][4]); one5.setOpaque(true);
                one5.setEnabled(true); one5.setBackground(Color.GREEN);
                //
            JButton one6= new JButton(""+numbers[3][0]); one6.setOpaque(true);
                one6.setEnabled(true); one6.setBackground(Color.WHITE);
            JButton one7= new JButton(""+numbers[3][1]); one7.setOpaque(true);
                one7.setEnabled(true); one7.setBackground(Color.WHITE);
            JButton one8= new JButton(""+numbers[3][2]); one8.setOpaque(true);
                one8.setEnabled(true); one8.setBackground(Color.WHITE);
            JButton one9= new JButton(""+numbers[3][3]); one9.setOpaque(true);
                one9.setEnabled(true); one9.setBackground(Color.WHITE);
            JButton two0= new JButton(""+numbers[3][4]); two0.setOpaque(true);
                two0.setEnabled(true); two0.setBackground(Color.WHITE);
                //
            JButton two1= new JButton(""+numbers[4][0]); two1.setOpaque(true);
                two1.setEnabled(true); two1.setBackground(Color.YELLOW);
            JButton two2= new JButton(""+numbers[4][1]); two2.setOpaque(true);
                two2.setEnabled(true); two2.setBackground(Color.YELLOW);
            JButton two3= new JButton(""+numbers[4][2]); two3.setOpaque(true);
                two3.setEnabled(true); two3.setBackground(Color.YELLOW);
            JButton two4= new JButton(""+numbers[4][3]); two4.setOpaque(true);
                two4.setEnabled(true); two4.setBackground(Color.YELLOW);
            JButton two5= new JButton(""+numbers[4][4]); two5.setOpaque(true);
                two5.setEnabled(true); two5.setBackground(Color.YELLOW);
            //
            JButton answer1= new JButton(); answer1.setOpaque(true);
                answer1.setEnabled(false); answer1.setBackground(Color.BLUE);
                int pos1=0;
            JButton answer2= new JButton(); answer2.setOpaque(true);
                answer2.setEnabled(false); answer2.setBackground(Color.BLUE);
                int pos2=0;
            JButton answer3= new JButton(); answer3.setOpaque(true);
                answer3.setEnabled(false); answer3.setBackground(Color.BLUE);
                int pos3=0;
            JButton answer4= new JButton(); answer4.setOpaque(true);
                answer4.setEnabled(false); answer4.setBackground(Color.BLUE);
                int pos4=0;
            JButton answer5= new JButton(); answer5.setOpaque(true);
                answer5.setEnabled(false); answer5.setBackground(Color.BLUE);
                int pos5=0;
            //
            //
            JBox buttons= JBox.vbox(JBox.hbox(
                JBox.vbox(one, two, three, four, five, answer1),
                JBox.vbox(six, seven, eight, nine, ten, answer2),
                JBox.vbox(eleven, twelve, one3, one4, one5, answer3),
                JBox.vbox(one6, one7, one8, one9, two0, answer4),
                JBox.vbox(two1, two2, two3, two4, two5, answer5),
                JBox.vbox(timeLbl, newGame)
                ));
            game.add(buttons);
            //
            game.setVisible(true);
            //
            JEventQueue events= new JEventQueue();
                events.listenTo(one, "1");
                events.listenTo(two, "2");
                events.listenTo(three, "3");
                events.listenTo(four, "4");
                events.listenTo(five, "5");
                events.listenTo(six, "6");
                events.listenTo(seven, "7");
                events.listenTo(eight, "8");
                events.listenTo(nine, "9");
                events.listenTo(ten, "10");
                events.listenTo(eleven, "11");
                events.listenTo(twelve, "12");
                events.listenTo(one3, "13");
                events.listenTo(one4, "14");
                events.listenTo(one5, "15");
                events.listenTo(one6, "16");
                events.listenTo(one7, "17");
                events.listenTo(one8, "18");
                events.listenTo(one9, "19");
                events.listenTo(two0, "20");
                events.listenTo(two1, "21");
                events.listenTo(two2, "22");
                events.listenTo(two3, "23");
                events.listenTo(two4, "24");
                events.listenTo(two5, "25");
                events.listenTo(answer1, "answer1");
                events.listenTo(answer2, "answer2");
                events.listenTo(answer3, "answer3");
                events.listenTo(answer4, "answer4");
                events.listenTo(answer5, "answer5");
                events.listenTo(newGame, "newGame");
            while(true)
            {
                EventObject event=events.waitEvent();
                String name=events.getName(event);
                if (name.equals("newGame")) {
                    game.setVisible(false);
                    game.dispose();
                    showGUI(n);
                    break;
                }
                if(name.equals("1"))
                {
                    if (numbers[0][0]==answers[0])
                    {
                        two.setEnabled(false);
                        two.setBackground(Color.BLACK);
                        three.setEnabled(false);
                        three.setBackground(Color.BLACK);
                        four.setEnabled(false);
                        four.setBackground(Color.BLACK);
                        five.setEnabled(false);
                        five.setBackground(Color.BLACK);
                        pos1=numbers[0][0];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("2"))
                {
                    if (numbers[0][1]==answers[0])
                    {
                        one.setEnabled(false);
                        one.setBackground(Color.BLACK);
                        three.setEnabled(false);
                        three.setBackground(Color.BLACK);
                        four.setEnabled(false);
                        four.setBackground(Color.BLACK);
                        five.setEnabled(false);
                        five.setBackground(Color.BLACK);
                        pos1=numbers[0][1];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("3"))
                {
                    if (numbers[0][2]==answers[0])
                    {
                        two.setEnabled(false);
                        two.setBackground(Color.BLACK);
                        one.setEnabled(false);
                        one.setBackground(Color.BLACK);
                        four.setEnabled(false);
                        four.setBackground(Color.BLACK);
                        five.setEnabled(false);
                        five.setBackground(Color.BLACK);
                        pos1=numbers[0][2];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("4"))
                {
                    if (numbers[0][3]==answers[0])
                    {
                        two.setEnabled(false);
                        two.setBackground(Color.BLACK);
                        three.setEnabled(false);
                        three.setBackground(Color.BLACK);
                        one.setEnabled(false);
                        one.setBackground(Color.BLACK);
                        five.setEnabled(false);
                        five.setBackground(Color.BLACK);
                        pos1=numbers[0][3];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("5"))
                {
                    if (numbers[0][4]==answers[0])
                    {
                        two.setEnabled(false);
                        two.setBackground(Color.BLACK);
                        three.setEnabled(false);
                        three.setBackground(Color.BLACK);
                        four.setEnabled(false);
                        four.setBackground(Color.BLACK);
                        one.setEnabled(false);
                        one.setBackground(Color.BLACK);
                        pos1=numbers[0][4];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                //
                //
                if(name.equals("6"))
                {
                    if (numbers[1][0]==answers[1])
                    {
                        seven.setEnabled(false);
                        seven.setBackground(Color.BLACK);
                        eight.setEnabled(false);
                        eight.setBackground(Color.BLACK);
                        nine.setEnabled(false);
                        nine.setBackground(Color.BLACK);
                        ten.setEnabled(false);
                        ten.setBackground(Color.BLACK);
                        pos2=numbers[1][0];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("7"))
                {
                    if (numbers[1][1]==answers[1])
                    {
                        eight.setEnabled(false);
                        eight.setBackground(Color.BLACK);
                        nine.setEnabled(false);
                        nine.setBackground(Color.BLACK);
                        ten.setEnabled(false);
                        ten.setBackground(Color.BLACK);
                        six.setEnabled(false);
                        six.setBackground(Color.BLACK);
                        pos2=numbers[1][1];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("8"))
                {
                    if (numbers[1][2]==answers[1])
                    {
                        nine.setEnabled(false);
                        nine.setBackground(Color.BLACK);
                        ten.setEnabled(false);
                        ten.setBackground(Color.BLACK);
                        six.setEnabled(false);
                        six.setBackground(Color.BLACK);
                        seven.setEnabled(false);
                        seven.setBackground(Color.BLACK);
                        pos3=numbers[1][2];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("9"))
                {
                    if (numbers[1][3]==answers[1])
                    {
                        ten.setEnabled(false);
                        ten.setBackground(Color.BLACK);
                        six.setEnabled(false);
                        six.setBackground(Color.BLACK);
                        seven.setEnabled(false);
                        seven.setBackground(Color.BLACK);
                        eight.setEnabled(false);
                        eight.setBackground(Color.BLACK);
                        pos2=numbers[1][3];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("10"))
                {
                    if (numbers[1][4]==answers[1])
                    {
                        nine.setEnabled(false);
                        nine.setBackground(Color.BLACK);
                        eight.setEnabled(false);
                        eight.setBackground(Color.BLACK);
                        seven.setEnabled(false);
                        seven.setBackground(Color.BLACK);
                        six.setEnabled(false);
                        six.setBackground(Color.BLACK);
                        pos2=numbers[1][4];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                //
                //
                if(name.equals("11"))
                {
                    if (numbers[2][0]==answers[2])
                    {
                        twelve.setEnabled(false);
                        twelve.setBackground(Color.BLACK);
                        one3.setEnabled(false);
                        one3.setBackground(Color.BLACK);
                        one4.setEnabled(false);
                        one4.setBackground(Color.BLACK);
                        one5.setEnabled(false);
                        one5.setBackground(Color.BLACK);
                        pos3=numbers[2][0];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("12"))
                {
                    if (numbers[2][1]==answers[2])
                    {
                        eleven.setEnabled(false);
                        eleven.setBackground(Color.BLACK);
                        one3.setEnabled(false);
                        one3.setBackground(Color.BLACK);
                        one4.setEnabled(false);
                        one4.setBackground(Color.BLACK);
                        one5.setEnabled(false);
                        one5.setBackground(Color.BLACK);
                        pos3=numbers[2][1];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("13"))
                {
                    if (numbers[2][2]==answers[2])
                    {
                        eleven.setEnabled(false);
                        eleven.setBackground(Color.BLACK);
                        twelve.setEnabled(false);
                        twelve.setBackground(Color.BLACK);
                        one4.setEnabled(false);
                        one4.setBackground(Color.BLACK);
                        one5.setEnabled(false);
                        one5.setBackground(Color.BLACK);
                        pos3=numbers[2][2];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("14"))
                {
                    if (numbers[2][3]==answers[2])
                    {
                        eleven.setEnabled(false);
                        eleven.setBackground(Color.BLACK);
                        twelve.setEnabled(false);
                        twelve.setBackground(Color.BLACK);
                        one3.setEnabled(false);
                        one3.setBackground(Color.BLACK);
                        one5.setEnabled(false);
                        one5.setBackground(Color.BLACK);
                        pos3=numbers[2][3];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("15"))
                {
                    if (numbers[2][4]==answers[2])
                    {
                        eleven.setEnabled(false);
                        eleven.setBackground(Color.BLACK);
                        twelve.setEnabled(false);
                        twelve.setBackground(Color.BLACK);
                        one3.setEnabled(false);
                        one3.setBackground(Color.BLACK);
                        one4.setEnabled(false);
                        one4.setBackground(Color.BLACK);
                        pos3=numbers[2][4];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                //
                //
                if(name.equals("16"))
                {
                    if (numbers[3][0]==answers[3])
                    {
                        one7.setEnabled(false);
                        one7.setBackground(Color.BLACK);
                        one8.setEnabled(false);
                        one8.setBackground(Color.BLACK);
                        one9.setEnabled(false);
                        one9.setBackground(Color.BLACK);
                        two0.setEnabled(false);
                        two0.setBackground(Color.BLACK);
                        pos4=numbers[3][0];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("17"))
                {
                    if (numbers[3][1]==answers[3])
                    {
                        one6.setEnabled(false);
                        one6.setBackground(Color.BLACK);
                        one8.setEnabled(false);
                        one8.setBackground(Color.BLACK);
                        one9.setEnabled(false);
                        one9.setBackground(Color.BLACK);
                        two0.setEnabled(false);
                        two0.setBackground(Color.BLACK);
                        pos4=numbers[3][1];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("18"))
                {
                    if (numbers[3][2]==answers[3])
                    {
                        one6.setEnabled(false);
                        one6.setBackground(Color.BLACK);
                        one7.setEnabled(false);
                        one7.setBackground(Color.BLACK);
                        one9.setEnabled(false);
                        one9.setBackground(Color.BLACK);
                        two0.setEnabled(false);
                        two0.setBackground(Color.BLACK);
                        pos4=numbers[3][2];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("19"))
                {
                    if (numbers[3][3]==answers[3])
                    {
                        one6.setEnabled(false);
                        one6.setBackground(Color.BLACK);
                        one7.setEnabled(false);
                        one7.setBackground(Color.BLACK);
                        one8.setEnabled(false);
                        one8.setBackground(Color.BLACK);
                        two0.setEnabled(false);
                        two0.setBackground(Color.BLACK);
                        pos4=numbers[3][3];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("20"))
                {
                    if (numbers[3][4]==answers[3])
                    {
                        one6.setEnabled(false);
                        one6.setBackground(Color.BLACK);
                        one7.setEnabled(false);
                        one7.setBackground(Color.BLACK);
                        one8.setEnabled(false);
                        one8.setBackground(Color.BLACK);
                        one9.setEnabled(false);
                        one9.setBackground(Color.BLACK);
                        pos4=numbers[3][4];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                //
                //
                if(name.equals("21"))
                {
                    if (numbers[4][0]==answers[4])
                    {
                        two2.setEnabled(false);
                        two2.setBackground(Color.BLACK);
                        two3.setEnabled(false);
                        two3.setBackground(Color.BLACK);
                        two4.setEnabled(false);
                        two4.setBackground(Color.BLACK);
                        two5.setEnabled(false);
                        two5.setBackground(Color.BLACK);
                        answer1.setEnabled(true);
                        answer2.setEnabled(true);
                        answer3.setEnabled(true);
                        answer4.setEnabled(true);
                        answer5.setEnabled(true);
                        pos5=numbers[4][0];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("22"))
                {
                    if (numbers[4][1]==answers[4])
                    {
                        two1.setEnabled(false);
                        two1.setBackground(Color.BLACK);
                        two5.setEnabled(false);
                        two5.setBackground(Color.BLACK);
                        two3.setEnabled(false);
                        two3.setBackground(Color.BLACK);
                        two4.setEnabled(false);
                        two4.setBackground(Color.BLACK);
                        answer5.setEnabled(true);
                        answer4.setEnabled(true);
                        answer3.setEnabled(true);
                        answer2.setEnabled(true);
                        answer1.setEnabled(true);
                        pos5=numbers[4][1];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("23"))
                {
                    if (numbers[4][2]==answers[4])
                    {
                        two1.setEnabled(false);
                        two1.setBackground(Color.BLACK);
                        two2.setEnabled(false);
                        two2.setBackground(Color.BLACK);
                        two4.setEnabled(false);
                        two4.setBackground(Color.BLACK);
                        two5.setEnabled(false);
                        two5.setBackground(Color.BLACK);
                        answer5.setEnabled(true);
                        answer4.setEnabled(true);
                        answer3.setEnabled(true);
                        answer2.setEnabled(true);
                        answer1.setEnabled(true);
                        pos5=numbers[4][2];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("24"))
                {
                    if (numbers[4][3]==answers[4])
                    {
                        two1.setEnabled(false);
                        two1.setBackground(Color.BLACK);
                        two2.setEnabled(false);
                        two2.setBackground(Color.BLACK);
                        two3.setEnabled(false);
                        two3.setBackground(Color.BLACK);
                        two5.setEnabled(false);
                        two5.setBackground(Color.BLACK);
                        answer5.setEnabled(true);
                        answer4.setEnabled(true);
                        answer3.setEnabled(true);
                        answer2.setEnabled(true);
                        answer1.setEnabled(true);
                        pos5=numbers[4][3];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("25"))
                {
                    if (numbers[4][4]==answers[4])
                    {
                        two1.setEnabled(false);
                        two1.setBackground(Color.BLACK);
                        two2.setEnabled(false);
                        two2.setBackground(Color.BLACK);
                        two3.setEnabled(false);
                        two3.setBackground(Color.BLACK);
                        two4.setEnabled(false);
                        two4.setBackground(Color.BLACK);
                        answer5.setEnabled(true);
                        answer4.setEnabled(true);
                        answer3.setEnabled(true);
                        answer2.setEnabled(true);
                        answer1.setEnabled(true);
                        pos5=numbers[4][4];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if (name.equals("answer1"))
                {
                    if (pos1==answers[5])
                    {
                        myTimer1.stop();
                        timeLbl.setVisible(false);
                        JFrame result = new JFrame();
                        result.setSize(200, 200); result.setTitle("Kakooma"); result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
                        JLabel time = new JLabel(new String(timeLbl.getText()));
                        time.setFont(new Font("Serif", Font.PLAIN, 50));
                        result.add(time, BorderLayout.CENTER);
                        result.setVisible(true);
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if (name.equals("answer2"))
                {
                    if (pos2==answers[5])
                    {
                        myTimer1.stop();
                        timeLbl.setVisible(false);
                        JFrame result = new JFrame();
                        result.setSize(200, 200); result.setTitle("Kakooma"); result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
                        JLabel time = new JLabel(new String(timeLbl.getText()));
                        time.setFont(new Font("Serif", Font.PLAIN, 50));
                        result.add(time, BorderLayout.CENTER);
                        result.setVisible(true);
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if (name.equals("answer3"))
                {
                    if (pos3==answers[5])
                    {
                        myTimer1.stop();
                        timeLbl.setVisible(false);
                        JFrame result = new JFrame();
                        result.setSize(200, 200); result.setTitle("Kakooma"); result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
                        JLabel time = new JLabel(new String(timeLbl.getText()));
                        time.setFont(new Font("Serif", Font.PLAIN, 50));
                        result.add(time, BorderLayout.CENTER);
                        result.setVisible(true);
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if (name.equals("answer4"))
                {
                    if (pos4==answers[5])
                    {
                        myTimer1.stop();
                        timeLbl.setVisible(false);
                        JFrame result = new JFrame();
                        result.setSize(200, 200); result.setTitle("Kakooma"); result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
                        JLabel time = new JLabel(new String(timeLbl.getText()));
                        time.setFont(new Font("Serif", Font.PLAIN, 50));
                        result.add(time, BorderLayout.CENTER);
                        result.setVisible(true);
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if (name.equals("answer5"))
                {
                    if (pos5==answers[5])
                    {
                        myTimer1.stop();
                        timeLbl.setVisible(false);
                        JFrame result = new JFrame();
                        result.setSize(200, 200); result.setTitle("Kakooma"); result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
                        JLabel time = new JLabel(new String(timeLbl.getText()));
                        time.setFont(new Font("Serif", Font.PLAIN, 50));
                        result.add(time, BorderLayout.CENTER);
                        result.setVisible(true);
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
            }
        }
        else if (n==6)
        {
            JFrame game= new JFrame();
            game.setSize(600, 300);
            AdditionSet adb= new AdditionSet(6);
            int[][] numbers= adb.getNumbers();
            int[] answers= adb.getAnswers();
            //
            JButton newGame = new JButton("New Game");
                newGame.setOpaque(true);
                newGame.setEnabled(true);
                newGame.setBackground(Color.BLACK);
            //
            myTimer1 = new javax.swing.Timer(TENTH_SEC, new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    clockTick++;
                    clockTime = ((double)clockTick)/10.0;
                    clockTimeString = new Double(clockTime).toString();
                    timeLbl.setText(clockTimeString);
                    //System.out.println(clockTime);
                }
            });
            newGame.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    clockTick = 0;
                    clockTime = ((double)clockTick)/10.0;
                    clockTimeString = new Double(clockTime).toString();
                    timeLbl.setText(clockTimeString);
                    myTimer1.start();
                }
            });
            
            
            JButton one = new JButton(""+numbers[0][0]); one.setOpaque(true);
                one.setEnabled(true); one.setBackground(Color.RED);
            JButton two= new JButton(""+numbers[0][1]); two.setOpaque(true);
                two.setEnabled(true); two.setBackground(Color.RED);
            JButton three= new JButton(""+numbers[0][2]); three.setOpaque(true);
                three.setEnabled(true); three.setBackground(Color.RED);
            JButton four= new JButton(""+numbers[0][3]); four.setOpaque(true);
                four.setEnabled(true); four.setBackground(Color.RED);
            JButton five= new JButton(""+numbers[0][4]); five.setOpaque(true);
                five.setEnabled(true); five.setBackground(Color.RED);
            JButton six= new JButton(""+numbers[0][5]); six.setOpaque(true);
                six.setEnabled(true); six.setBackground(Color.RED);
                //
            JButton seven= new JButton(""+numbers[1][0]); seven.setOpaque(true);
                seven.setEnabled(true); seven.setBackground(Color.BLUE);
            JButton eight= new JButton(""+numbers[1][1]); eight.setOpaque(true);
                eight.setEnabled(true); eight.setBackground(Color.BLUE);
            JButton nine= new JButton(""+numbers[1][2]); nine.setOpaque(true);
                nine.setEnabled(true); nine.setBackground(Color.BLUE);
            JButton ten= new JButton(""+numbers[1][3]); ten.setOpaque(true);
                ten.setEnabled(true); ten.setBackground(Color.BLUE);
            JButton eleven= new JButton(""+numbers[1][4]); eleven.setOpaque(true);
                eleven.setEnabled(true); eleven.setBackground(Color.BLUE);
            JButton twelve= new JButton(""+numbers[1][5]); twelve.setOpaque(true);
                twelve.setEnabled(true); twelve.setBackground(Color.BLUE);
                //
            JButton one3= new JButton(""+numbers[2][0]); one3.setOpaque(true);
                one3.setEnabled(true); one3.setBackground(Color.GREEN);
            JButton one4= new JButton(""+numbers[2][1]); one4.setOpaque(true);
                one4.setEnabled(true); one4.setBackground(Color.GREEN);
            JButton one5= new JButton(""+numbers[2][2]); one5.setOpaque(true);
                one5.setEnabled(true); one5.setBackground(Color.GREEN);
            JButton one6= new JButton(""+numbers[2][3]); one6.setOpaque(true);
                one6.setEnabled(true); one6.setBackground(Color.GREEN);
            JButton one7= new JButton(""+numbers[2][4]); one7.setOpaque(true);
                one7.setEnabled(true); one7.setBackground(Color.GREEN);
            JButton one8= new JButton(""+numbers[2][5]); one8.setOpaque(true);
                one8.setEnabled(true); one8.setBackground(Color.GREEN);
                //
            JButton one9= new JButton(""+numbers[3][0]); one9.setOpaque(true);
                one9.setEnabled(true); one9.setBackground(Color.WHITE);
            JButton two0= new JButton(""+numbers[3][1]); two0.setOpaque(true);
                two0.setEnabled(true); two0.setBackground(Color.WHITE);
            JButton two1= new JButton(""+numbers[3][2]); two1.setOpaque(true);
                two1.setEnabled(true); two1.setBackground(Color.WHITE);
            JButton two2= new JButton(""+numbers[3][3]); two2.setOpaque(true);
                two2.setEnabled(true); two2.setBackground(Color.WHITE);
            JButton two3= new JButton(""+numbers[3][4]); two3.setOpaque(true);
                two3.setEnabled(true); two3.setBackground(Color.WHITE);
            JButton two4= new JButton(""+numbers[3][5]); two4.setOpaque(true);
                two4.setEnabled(true); two4.setBackground(Color.WHITE);
                //
            JButton two5= new JButton(""+numbers[4][0]); two5.setOpaque(true);
                two5.setEnabled(true); two5.setBackground(Color.YELLOW);
            JButton two6= new JButton(""+numbers[4][1]); two6.setOpaque(true);
                two6.setEnabled(true); two6.setBackground(Color.YELLOW);
            JButton two7= new JButton(""+numbers[4][2]); two7.setOpaque(true);
                two7.setEnabled(true); two7.setBackground(Color.YELLOW);
            JButton two8= new JButton(""+numbers[4][3]); two8.setOpaque(true);
                two8.setEnabled(true); two8.setBackground(Color.YELLOW);
            JButton two9= new JButton(""+numbers[4][4]); two9.setOpaque(true);
                two9.setEnabled(true); two9.setBackground(Color.YELLOW);
            JButton three0= new JButton(""+numbers[4][5]); three0.setOpaque(true);
                three0.setEnabled(true); three0.setBackground(Color.YELLOW);
                //
            JButton three1= new JButton(""+numbers[5][0]); three1.setOpaque(true);
                three1.setEnabled(true); three1.setBackground(Color.ORANGE);
            JButton three2= new JButton(""+numbers[5][1]); three2.setOpaque(true);
                three2.setEnabled(true); three2.setBackground(Color.ORANGE);
            JButton three3= new JButton(""+numbers[5][2]); three3.setOpaque(true);
                three3.setEnabled(true); three3.setBackground(Color.ORANGE);
            JButton three4= new JButton(""+numbers[5][3]); three4.setOpaque(true);
                three4.setEnabled(true); three4.setBackground(Color.ORANGE);
            JButton three5= new JButton(""+numbers[5][4]); three5.setOpaque(true);
                three5.setEnabled(true); three5.setBackground(Color.ORANGE);
            JButton three6= new JButton(""+numbers[5][5]); three6.setOpaque(true);
                three6.setEnabled(true); three6.setBackground(Color.ORANGE);
            //
            JButton answer1= new JButton(); answer1.setOpaque(true);
                answer1.setEnabled(false); answer1.setBackground(Color.BLUE);
                int pos1=0;
            JButton answer2= new JButton(); answer2.setOpaque(true);
                answer2.setEnabled(false); answer2.setBackground(Color.BLUE);
                int pos2=0;
            JButton answer3= new JButton(); answer3.setOpaque(true);
                answer3.setEnabled(false); answer3.setBackground(Color.BLUE);
                int pos3=0;
            JButton answer4= new JButton(); answer4.setOpaque(true);
                answer4.setEnabled(false); answer4.setBackground(Color.BLUE);
                int pos4=0;
            JButton answer5= new JButton(); answer5.setOpaque(true);
                answer5.setEnabled(false); answer5.setBackground(Color.BLUE);
                int pos5=0;
            JButton answer6= new JButton(); answer6.setOpaque(true);
                answer6.setEnabled(false); answer6.setBackground(Color.BLUE);
                int pos6=0;
            //
            //
            JBox buttons= JBox.vbox(JBox.hbox(
                JBox.vbox(one, two, three, four, five, six, answer1),
                JBox.vbox(seven, eight, nine, ten, eleven, twelve, answer2),
                JBox.vbox(one3, one4, one5, one6, one7, one8, answer3),
                JBox.vbox(one9, two0, two1, two2, two3, two4, answer4),
                JBox.vbox(two5, two6, two7, two8, two9, three0, answer5),
                JBox.vbox(three1, three2, three3, three4, three5, three6, answer6),
                JBox.vbox(timeLbl, newGame)
                ));
            game.add(buttons);
            //
            game.setVisible(true);
            //
            JEventQueue events= new JEventQueue();
                events.listenTo(one, "1");
                events.listenTo(two, "2");
                events.listenTo(three, "3");
                events.listenTo(four, "4");
                events.listenTo(five, "5");
                events.listenTo(six, "6");
                events.listenTo(seven, "7");
                events.listenTo(eight, "8");
                events.listenTo(nine, "9");
                events.listenTo(ten, "10");
                events.listenTo(eleven, "11");
                events.listenTo(twelve, "12");
                events.listenTo(one3, "13");
                events.listenTo(one4, "14");
                events.listenTo(one5, "15");
                events.listenTo(one6, "16");
                events.listenTo(one7, "17");
                events.listenTo(one8, "18");
                events.listenTo(one9, "19");
                events.listenTo(two0, "20");
                events.listenTo(two1, "21");
                events.listenTo(two2, "22");
                events.listenTo(two3, "23");
                events.listenTo(two4, "24");
                events.listenTo(two5, "25");
                events.listenTo(two6, "26");
                events.listenTo(two7, "27");
                events.listenTo(two8, "28");
                events.listenTo(two9, "29");
                events.listenTo(three0, "30");
                events.listenTo(three1, "31");
                events.listenTo(three2, "32");
                events.listenTo(three3, "33");
                events.listenTo(three4, "34");
                events.listenTo(three5, "35");
                events.listenTo(three6, "36");
                events.listenTo(answer1, "answer1");
                events.listenTo(answer2, "answer2");
                events.listenTo(answer3, "answer3");
                events.listenTo(answer4, "answer4");
                events.listenTo(answer5, "answer5");
                events.listenTo(answer6, "answer6");
                events.listenTo(newGame, "newGame");
            while(true)
            {
                EventObject event=events.waitEvent();
                String name=events.getName(event);
                if (name.equals("newGame")) {
                    game.setVisible(false);
                    game.dispose();
                    showGUI(n);
                    break;
                }
                if(name.equals("1"))
                {
                    if (numbers[0][0]==answers[0])
                    {
                        two.setEnabled(false);
                        two.setBackground(Color.BLACK);
                        three.setEnabled(false);
                        three.setBackground(Color.BLACK);
                        four.setEnabled(false);
                        four.setBackground(Color.BLACK);
                        five.setEnabled(false);
                        five.setBackground(Color.BLACK);
                        six.setEnabled(false);
                        six.setBackground(Color.BLACK);
                        pos1=numbers[0][0];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("2"))
                {
                    if (numbers[0][1]==answers[0])
                    {
                        one.setEnabled(false);
                        one.setBackground(Color.BLACK);
                        three.setEnabled(false);
                        three.setBackground(Color.BLACK);
                        four.setEnabled(false);
                        four.setBackground(Color.BLACK);
                        five.setEnabled(false);
                        five.setBackground(Color.BLACK);
                        six.setEnabled(false);
                        six.setBackground(Color.BLACK);
                        pos1=numbers[0][1];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("3"))
                {
                    if (numbers[0][2]==answers[0])
                    {
                        two.setEnabled(false);
                        two.setBackground(Color.BLACK);
                        one.setEnabled(false);
                        one.setBackground(Color.BLACK);
                        four.setEnabled(false);
                        four.setBackground(Color.BLACK);
                        five.setEnabled(false);
                        five.setBackground(Color.BLACK);
                        six.setEnabled(false);
                        six.setBackground(Color.BLACK);
                        pos1=numbers[0][2];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("4"))
                {
                    if (numbers[0][3]==answers[0])
                    {
                        two.setEnabled(false);
                        two.setBackground(Color.BLACK);
                        three.setEnabled(false);
                        three.setBackground(Color.BLACK);
                        one.setEnabled(false);
                        one.setBackground(Color.BLACK);
                        five.setEnabled(false);
                        five.setBackground(Color.BLACK);
                        six.setEnabled(false);
                        six.setBackground(Color.BLACK);
                        pos1=numbers[0][3];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("5"))
                {
                    if (numbers[0][4]==answers[0])
                    {
                        two.setEnabled(false);
                        two.setBackground(Color.BLACK);
                        three.setEnabled(false);
                        three.setBackground(Color.BLACK);
                        four.setEnabled(false);
                        four.setBackground(Color.BLACK);
                        one.setEnabled(false);
                        one.setBackground(Color.BLACK);
                        six.setEnabled(false);
                        six.setBackground(Color.BLACK);
                        pos1=numbers[0][4];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("6"))
                {
                    if (numbers[0][5]==answers[0])
                    {
                        two.setEnabled(false);
                        two.setBackground(Color.BLACK);
                        three.setEnabled(false);
                        three.setBackground(Color.BLACK);
                        four.setEnabled(false);
                        four.setBackground(Color.BLACK);
                        one.setEnabled(false);
                        one.setBackground(Color.BLACK);
                        five.setEnabled(false);
                        five.setBackground(Color.BLACK);
                        pos1=numbers[0][5];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("7"))
                {
                    if (numbers[1][0]==answers[1])
                    {
                        eight.setEnabled(false);
                        eight.setBackground(Color.BLACK);
                        nine.setEnabled(false);
                        nine.setBackground(Color.BLACK);
                        ten.setEnabled(false);
                        ten.setBackground(Color.BLACK);
                        eleven.setEnabled(false);
                        eleven.setBackground(Color.BLACK);
                        twelve.setEnabled(false);
                        twelve.setBackground(Color.BLACK);
                        pos2=numbers[1][0];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("8"))
                {
                    if (numbers[1][1]==answers[1])
                    {
                        nine.setEnabled(false);
                        nine.setBackground(Color.BLACK);
                        ten.setEnabled(false);
                        ten.setBackground(Color.BLACK);
                        twelve.setEnabled(false);
                        twelve.setBackground(Color.BLACK);
                        seven.setEnabled(false);
                        seven.setBackground(Color.BLACK);
                        eleven.setEnabled(false);
                        eleven.setBackground(Color.BLACK);
                        pos2=numbers[1][1];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("9"))
                {
                    if (numbers[1][2]==answers[1])
                    {
                        ten.setEnabled(false);
                        ten.setBackground(Color.BLACK);
                        twelve.setEnabled(false);
                        twelve.setBackground(Color.BLACK);
                        seven.setEnabled(false);
                        seven.setBackground(Color.BLACK);
                        eight.setEnabled(false);
                        eight.setBackground(Color.BLACK);
                        eleven.setEnabled(false);
                        eleven.setBackground(Color.BLACK);
                        pos2=numbers[1][2];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("10"))
                {
                    if (numbers[1][3]==answers[1])
                    {
                        nine.setEnabled(false);
                        nine.setBackground(Color.BLACK);
                        eight.setEnabled(false);
                        eight.setBackground(Color.BLACK);
                        seven.setEnabled(false);
                        seven.setBackground(Color.BLACK);
                        twelve.setEnabled(false);
                        twelve.setBackground(Color.BLACK);
                        eleven.setEnabled(false);
                        eleven.setBackground(Color.BLACK);
                        pos2=numbers[1][3];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("11"))
                {
                    if (numbers[1][4]==answers[1])
                    {
                        nine.setEnabled(false);
                        nine.setBackground(Color.BLACK);
                        eight.setEnabled(false);
                        eight.setBackground(Color.BLACK);
                        seven.setEnabled(false);
                        seven.setBackground(Color.BLACK);
                        twelve.setEnabled(false);
                        twelve.setBackground(Color.BLACK);
                        ten.setEnabled(false);
                        ten.setBackground(Color.BLACK);
                        pos2=numbers[1][4];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("12"))
                {
                    if (numbers[1][5]==answers[1])
                    {
                        nine.setEnabled(false);
                        nine.setBackground(Color.BLACK);
                        seven.setEnabled(false);
                        seven.setBackground(Color.BLACK);
                        eight.setEnabled(false);
                        eight.setBackground(Color.BLACK);
                        ten.setEnabled(false);
                        ten.setBackground(Color.BLACK);
                        eleven.setEnabled(false);
                        eleven.setBackground(Color.BLACK);
                        pos2=numbers[1][5];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("13"))
                {
                    if (numbers[2][0]==answers[2])
                    {
                        one7.setEnabled(false);
                        one7.setBackground(Color.BLACK);
                        one8.setEnabled(false);
                        one8.setBackground(Color.BLACK);
                        one4.setEnabled(false);
                        one4.setBackground(Color.BLACK);
                        one5.setEnabled(false);
                        one5.setBackground(Color.BLACK);
                        one6.setEnabled(false);
                        one6.setBackground(Color.BLACK);
                        pos3=numbers[2][0];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("14"))
                {
                    if (numbers[2][1]==answers[2])
                    {
                        one6.setEnabled(false);
                        one6.setBackground(Color.BLACK);
                        one8.setEnabled(false);
                        one8.setBackground(Color.BLACK);
                        one3.setEnabled(false);
                        one3.setBackground(Color.BLACK);
                        one5.setEnabled(false);
                        one5.setBackground(Color.BLACK);
                        one7.setEnabled(false);
                        one7.setBackground(Color.BLACK);
                        pos3=numbers[2][1];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("15"))
                {
                    if (numbers[2][2]==answers[2])
                    {
                        one3.setEnabled(false);
                        one3.setBackground(Color.BLACK);
                        one8.setEnabled(false);
                        one8.setBackground(Color.BLACK);
                        one7.setEnabled(false);
                        one7.setBackground(Color.BLACK);
                        one4.setEnabled(false);
                        one4.setBackground(Color.BLACK);
                        one6.setEnabled(false);
                        one6.setBackground(Color.BLACK);
                        pos3=numbers[2][2];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("16"))
                {
                    if (numbers[2][3]==answers[2])
                    {
                        one7.setEnabled(false);
                        one7.setBackground(Color.BLACK);
                        one5.setEnabled(false);
                        one5.setBackground(Color.BLACK);
                        one4.setEnabled(false);
                        one4.setBackground(Color.BLACK);
                        one3.setEnabled(false);
                        one3.setBackground(Color.BLACK);
                        one8.setEnabled(false);
                        one8.setBackground(Color.BLACK);
                        pos3=numbers[2][3];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("17"))
                {
                    if (numbers[2][4]==answers[2])
                    {
                        one8.setEnabled(false);
                        one8.setBackground(Color.BLACK);
                        one5.setEnabled(false);
                        one5.setBackground(Color.BLACK);
                        one4.setEnabled(false);
                        one4.setBackground(Color.BLACK);
                        one3.setEnabled(false);
                        one3.setBackground(Color.BLACK);
                        one6.setEnabled(false);
                        one6.setBackground(Color.BLACK);
                        pos3=numbers[2][4];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("18"))
                {
                    if (numbers[2][5]==answers[2])
                    {
                        one6.setEnabled(false);
                        one6.setBackground(Color.BLACK);
                        one5.setEnabled(false);
                        one5.setBackground(Color.BLACK);
                        one7.setEnabled(false);
                        one7.setBackground(Color.BLACK);
                        twelve.setEnabled(false);
                        twelve.setBackground(Color.BLACK);
                        one3.setEnabled(false);
                        one3.setBackground(Color.BLACK);
                        pos3=numbers[2][5];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("19"))
                {
                    if (numbers[3][0]==answers[3])
                    {
                        two0.setEnabled(false);
                        two0.setBackground(Color.BLACK);
                        two1.setEnabled(false);
                        two1.setBackground(Color.BLACK);
                        two2.setEnabled(false);
                        two2.setBackground(Color.BLACK);
                        two3.setEnabled(false);
                        two3.setBackground(Color.BLACK);
                        two4.setEnabled(false);
                        two4.setBackground(Color.BLACK);
                        pos4=numbers[3][0];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("20"))
                {
                    if (numbers[3][1]==answers[3])
                    {
                        two1.setEnabled(false);
                        two1.setBackground(Color.BLACK);
                        one9.setEnabled(false);
                        one9.setBackground(Color.BLACK);
                        two2.setEnabled(false);
                        two2.setBackground(Color.BLACK);
                        two3.setEnabled(false);
                        two3.setBackground(Color.BLACK);
                        two4.setEnabled(false);
                        two4.setBackground(Color.BLACK);
                        pos4=numbers[3][1];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("21"))
                {
                    if (numbers[3][2]==answers[3])
                    {
                        one9.setEnabled(false);
                        one9.setBackground(Color.BLACK);
                        two0.setEnabled(false);
                        two0.setBackground(Color.BLACK);
                        two2.setEnabled(false);
                        two2.setBackground(Color.BLACK);
                        two3.setEnabled(false);
                        two3.setBackground(Color.BLACK);
                        two4.setEnabled(false);
                        two4.setBackground(Color.BLACK);
                        pos4=numbers[3][2];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("22"))
                {
                    if (numbers[3][3]==answers[3])
                    {
                        one9.setEnabled(false);
                        one9.setBackground(Color.BLACK);
                        two0.setEnabled(false);
                        two0.setBackground(Color.BLACK);
                        two1.setEnabled(false);
                        two1.setBackground(Color.BLACK);
                        two3.setEnabled(false);
                        two3.setBackground(Color.BLACK);
                        two4.setEnabled(false);
                        two4.setBackground(Color.BLACK);
                        pos4=numbers[3][3];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("23"))
                {
                    if (numbers[3][4]==answers[3])
                    {
                        two1.setEnabled(false);
                        two1.setBackground(Color.BLACK);
                        two2.setEnabled(false);
                        two2.setBackground(Color.BLACK);
                        two4.setEnabled(false);
                        two4.setBackground(Color.BLACK);
                        two0.setEnabled(false);
                        two0.setBackground(Color.BLACK);
                        one9.setEnabled(false);
                        one9.setBackground(Color.BLACK);
                        pos4=numbers[3][4];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("24"))
                {
                    if (numbers[3][5]==answers[3])
                    {
                        two1.setEnabled(false);
                        two1.setBackground(Color.BLACK);
                        two2.setEnabled(false);
                        two2.setBackground(Color.BLACK);
                        two3.setEnabled(false);
                        two3.setBackground(Color.BLACK);
                        two0.setEnabled(false);
                        two0.setBackground(Color.BLACK);
                        one9.setEnabled(false);
                        one9.setBackground(Color.BLACK);
                        pos4=numbers[3][5];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("25"))
                {
                    if (numbers[4][0]==answers[4])
                    {
                        two6.setEnabled(false);
                        two6.setBackground(Color.BLACK);
                        two7.setEnabled(false);
                        two7.setBackground(Color.BLACK);
                        two8.setEnabled(false);
                        two8.setBackground(Color.BLACK);
                        two9.setEnabled(false);
                        two9.setBackground(Color.BLACK);
                        three0.setEnabled(false);
                        three0.setBackground(Color.BLACK);
                        pos5=numbers[4][0];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("26"))
                {
                    if (numbers[4][1]==answers[4])
                    {
                        two5.setEnabled(false);
                        two5.setBackground(Color.BLACK);
                        three0.setEnabled(false);
                        three0.setBackground(Color.BLACK);
                        two7.setEnabled(false);
                        two7.setBackground(Color.BLACK);
                        two8.setEnabled(false);
                        two8.setBackground(Color.BLACK);
                        two9.setEnabled(false);
                        two9.setBackground(Color.BLACK);
                        pos5=numbers[4][1];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("27"))
                {
                    if (numbers[4][2]==answers[4])
                    {
                        two5.setEnabled(false);
                        two5.setBackground(Color.BLACK);
                        three0.setEnabled(false);
                        three0.setBackground(Color.BLACK);
                        two9.setEnabled(false);
                        two9.setBackground(Color.BLACK);
                        two6.setEnabled(false);
                        two6.setBackground(Color.BLACK);
                        two8.setEnabled(false);
                        two8.setBackground(Color.BLACK);
                        pos5=numbers[4][2];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("28"))
                {
                    if (numbers[4][3]==answers[4])
                    {
                        two5.setEnabled(false);
                        two5.setBackground(Color.BLACK);
                        three0.setEnabled(false);
                        three0.setBackground(Color.BLACK);
                        two9.setEnabled(false);
                        two9.setBackground(Color.BLACK);
                        two6.setEnabled(false);
                        two6.setBackground(Color.BLACK);
                        two7.setEnabled(false);
                        two7.setBackground(Color.BLACK);
                        pos5=numbers[4][3];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("29"))
                {
                    if (numbers[4][4]==answers[4])
                    {
                        two5.setEnabled(false);
                        two5.setBackground(Color.BLACK);
                        three0.setEnabled(false);
                        three0.setBackground(Color.BLACK);
                        two6.setEnabled(false);
                        two6.setBackground(Color.BLACK);
                        two7.setEnabled(false);
                        two7.setBackground(Color.BLACK);
                        two8.setEnabled(false);
                        two8.setBackground(Color.BLACK);
                        pos5=numbers[4][4];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("30"))
                {
                    if (numbers[4][5]==answers[4])
                    {
                        two5.setEnabled(false);
                        two5.setBackground(Color.BLACK);
                        two7.setEnabled(false);
                        two7.setBackground(Color.BLACK);
                        two9.setEnabled(false);
                        two9.setBackground(Color.BLACK);
                        two6.setEnabled(false);
                        two6.setBackground(Color.BLACK);
                        two8.setEnabled(false);
                        two8.setBackground(Color.BLACK);
                        pos5=numbers[4][5];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("31"))
                {
                    if (numbers[5][0]==answers[5])
                    {
                        three6.setEnabled(false);
                        three6.setBackground(Color.BLACK);
                        three3.setEnabled(false);
                        three3.setBackground(Color.BLACK);
                        three2.setEnabled(false);
                        three2.setBackground(Color.BLACK);
                        three4.setEnabled(false);
                        three4.setBackground(Color.BLACK);
                        three5.setEnabled(false);
                        three5.setBackground(Color.BLACK);
                        answer1.setEnabled(true);
                        answer2.setEnabled(true);
                        answer3.setEnabled(true);
                        answer4.setEnabled(true);
                        answer5.setEnabled(true);
                        answer6.setEnabled(true);
                        pos6=numbers[5][0];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("32"))
                {
                    if (numbers[5][1]==answers[5])
                    {
                        three6.setEnabled(false);
                        three6.setBackground(Color.BLACK);
                        three3.setEnabled(false);
                        three3.setBackground(Color.BLACK);
                        three1.setEnabled(false);
                        three1.setBackground(Color.BLACK);
                        three4.setEnabled(false);
                        three4.setBackground(Color.BLACK);
                        three5.setEnabled(false);
                        three5.setBackground(Color.BLACK);
                        answer1.setEnabled(true);
                        answer2.setEnabled(true);
                        answer3.setEnabled(true);
                        answer4.setEnabled(true);
                        answer5.setEnabled(true);
                        answer6.setEnabled(true);
                        pos6=numbers[5][1];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("33"))
                {
                    if (numbers[5][2]==answers[5])
                    {
                        three6.setEnabled(false);
                        three6.setBackground(Color.BLACK);
                        three1.setEnabled(false);
                        three1.setBackground(Color.BLACK);
                        three2.setEnabled(false);
                        three2.setBackground(Color.BLACK);
                        three4.setEnabled(false);
                        three4.setBackground(Color.BLACK);
                        three5.setEnabled(false);
                        three5.setBackground(Color.BLACK);
                        answer1.setEnabled(true);
                        answer2.setEnabled(true);
                        answer3.setEnabled(true);
                        answer4.setEnabled(true);
                        answer5.setEnabled(true);
                        answer6.setEnabled(true);
                        pos6=numbers[5][2];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("34"))
                {
                    if (numbers[5][3]==answers[5])
                    {
                        three6.setEnabled(false);
                        three6.setBackground(Color.BLACK);
                        three3.setEnabled(false);
                        three3.setBackground(Color.BLACK);
                        three2.setEnabled(false);
                        three2.setBackground(Color.BLACK);
                        three1.setEnabled(false);
                        three1.setBackground(Color.BLACK);
                        three5.setEnabled(false);
                        three5.setBackground(Color.BLACK);
                        answer1.setEnabled(true);
                        answer2.setEnabled(true);
                        answer3.setEnabled(true);
                        answer4.setEnabled(true);
                        answer5.setEnabled(true);
                        answer6.setEnabled(true);
                        pos6=numbers[5][3];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("35"))
                {
                    if (numbers[5][4]==answers[5])
                    {
                        three6.setEnabled(false);
                        three6.setBackground(Color.BLACK);
                        three3.setEnabled(false);
                        three3.setBackground(Color.BLACK);
                        three2.setEnabled(false);
                        three2.setBackground(Color.BLACK);
                        three4.setEnabled(false);
                        three4.setBackground(Color.BLACK);
                        three1.setEnabled(false);
                        three1.setBackground(Color.BLACK);
                        answer1.setEnabled(true);
                        answer2.setEnabled(true);
                        answer3.setEnabled(true);
                        answer4.setEnabled(true);
                        answer5.setEnabled(true);
                        answer6.setEnabled(true);
                        pos6=numbers[5][4];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if(name.equals("36"))
                {
                    if (numbers[5][5]==answers[5])
                    {
                        three1.setEnabled(false);
                        three1.setBackground(Color.BLACK);
                        three3.setEnabled(false);
                        three3.setBackground(Color.BLACK);
                        three2.setEnabled(false);
                        three2.setBackground(Color.BLACK);
                        three4.setEnabled(false);
                        three4.setBackground(Color.BLACK);
                        three5.setEnabled(false);
                        three5.setBackground(Color.BLACK);
                        answer1.setEnabled(true);
                        answer2.setEnabled(true);
                        answer3.setEnabled(true);
                        answer4.setEnabled(true);
                        answer5.setEnabled(true);
                        answer6.setEnabled(true);
                        pos6=numbers[5][5];
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if (name.equals("answer1"))
                {
                    if (pos1==answers[6])
                    {
                        myTimer1.stop();
                        timeLbl.setVisible(false);
                        JFrame result = new JFrame();
                        result.setSize(200, 200); result.setTitle("Kakooma"); result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
                        JLabel time = new JLabel(new String(timeLbl.getText()));
                        time.setFont(new Font("Serif", Font.PLAIN, 50));
                        result.add(time, BorderLayout.CENTER);
                        result.setVisible(true);
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if (name.equals("answer2"))
                {
                    if (pos2==answers[6])
                    {
                        myTimer1.stop();
                        timeLbl.setVisible(false);
                        JFrame result = new JFrame();
                        result.setSize(200, 200); result.setTitle("Kakooma"); result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
                        JLabel time = new JLabel(new String(timeLbl.getText()));
                        time.setFont(new Font("Serif", Font.PLAIN, 50));
                        result.add(time, BorderLayout.CENTER);
                        result.setVisible(true);
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if (name.equals("answer3"))
                {
                    if (pos3==answers[6])
                    {
                        myTimer1.stop();
                        timeLbl.setVisible(false);
                        JFrame result = new JFrame();
                        result.setSize(200, 200); result.setTitle("Kakooma"); result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
                        JLabel time = new JLabel(new String(timeLbl.getText()));
                        time.setFont(new Font("Serif", Font.PLAIN, 50));
                        result.add(time, BorderLayout.CENTER);
                        result.setVisible(true);
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if (name.equals("answer4"))
                {
                    if (pos4==answers[6])
                    {
                        myTimer1.stop();
                        timeLbl.setVisible(false);
                        JFrame result = new JFrame();
                        result.setSize(200, 200); result.setTitle("Kakooma"); result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
                        JLabel time = new JLabel(new String(timeLbl.getText()));
                        time.setFont(new Font("Serif", Font.PLAIN, 50));
                        result.add(time, BorderLayout.CENTER);
                        result.setVisible(true);
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if (name.equals("answer5"))
                {
                    if (pos5==answers[6])
                    {
                        myTimer1.stop();
                        timeLbl.setVisible(false);
                        JFrame result = new JFrame();
                        result.setSize(200, 200); result.setTitle("Kakooma"); result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
                        JLabel time = new JLabel(new String(timeLbl.getText()));
                        time.setFont(new Font("Serif", Font.PLAIN, 50));
                        result.add(time, BorderLayout.CENTER);
                        result.setVisible(true);
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
                if (name.equals("answer6"))
                {
                    if (pos1==answers[6])
                    {
                        myTimer1.stop();
                        timeLbl.setVisible(false);
                        JFrame result = new JFrame();
                        result.setSize(200, 200); result.setTitle("Kakooma"); result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
                        JLabel time = new JLabel(new String(timeLbl.getText()));
                        time.setFont(new Font("Serif", Font.PLAIN, 50));
                        result.add(time, BorderLayout.CENTER);
                        result.setVisible(true);
                    }
                    else
                    {
                        clockTick += 50;
                        clockTime = ((double)clockTick)/10.0;
                        clockTimeString = new Double(clockTime).toString();
                        timeLbl.setText(clockTimeString);
                        //add 5 seconds to "Timer"
                    }
                }
            }
        }
    }
}