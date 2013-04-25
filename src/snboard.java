import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class snboard extends JFrame{
    ImagePanel ipanel;
    JButton p1Button,p2Button;
    JLabel status;

    public snboard(){
        super();
        setTitle("SnakeNLadder");					//Title
        setSize(375,450);
        setLocationByPlatform(true);
        //this.setLayout(new BorderLayout());
        createGUI();

    }

    private void createGUI() {
        ipanel= new ImagePanel(new ImageIcon("snl.jpg").getImage());

        this.add(ipanel,BorderLayout.CENTER);

        p1Button = new JButton("Player 1 Play");
        p1Button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(actionPlay(1)){
                    p2Button.setEnabled(true);
                    p1Button.setEnabled(false);
                }
            }
        });
        p2Button = new JButton("Player 2 Play");
        p2Button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(actionPlay(2)){
                    p1Button.setEnabled(true);
                    p2Button.setEnabled(false);
                }
            }
        });
        p2Button.setEnabled(false);

        status = new JLabel("Start Player 1");

        JPanel bottom = new JPanel();
        bottom.add(p1Button);
        bottom.add(p2Button);
        bottom.add(status);

        this.add(bottom,BorderLayout.SOUTH);
    }

    private boolean actionPlay(int i) {
        boolean ab = true;
        Random rd = new Random();
        int step = rd.nextInt(6);
        step++;
        switch(ipanel.movePos(i, step)){
            case 0 :{
                this.status.setText("OK Moved "+step+" :)");
                break;
            }
            case 1: {
                this.status.setText("Excellent! Moved "+step+" :D");
                break;
            }
            case 2: {
                this.status.setText("Oops! Moved "+step+" :(");
                break;
            }
            case 3: {
                this.status.setText("Player "+i+" Wins!"+" :) :D");
                this.p1Button.setEnabled(false);
                this.p2Button.setEnabled(false);
                ab=false;
                break;
            }
            default:break;
        }
        ipanel.repaint();
        return ab;
    }
}