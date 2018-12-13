import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game implements Runnable {

	@Override
	public void run() {
		final JFrame frame = new JFrame("TOP LEVEL FRAME");
        frame.setLocation(300, 300);

        // Status panel      
        final JPanel control_panel = new JPanel();//makes a place to put the instructions
        frame.add(control_panel, BorderLayout.NORTH);
        final JButton instructions = new JButton("instructions");
        instructions.addActionListener(//makes the instruction pop up when button is clicked
	        new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                JOptionPane.showMessageDialog(frame, "This game is pac man, The goal of the game is to colect all of the coins.\n If you hit the ghost you loose "
	                		+ "unless you are powered up\n by the potions which alow you to eat the ghosts for a limited time only.\n You can use the arrow keys for the movement of the player. Good luck!!");
	            }
        });
        control_panel.add(instructions);
        frame.add(control_panel,BorderLayout.SOUTH);
 
        
        final JPanel score_panel = new JPanel();
        frame.add(score_panel, BorderLayout.NORTH);//adds the score and the status of the player
        final JLabel score = new JLabel("score: 0");
        score_panel.add(score);
        final JLabel status = new JLabel("Vulnerable");
        score_panel.add(status);
        // Main playing area
        final Maze maze = new Maze(status, score);
        frame.add(maze, BorderLayout.CENTER);//creates the game and state and displays it to the frame
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maze.start();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Game());

	}

}
