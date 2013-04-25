import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class snlboard{
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				JFrame frame = new snboard ();
				//frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

