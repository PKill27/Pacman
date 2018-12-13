import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Maze extends JPanel{
	
	 public static final int COURT_WIDTH = 500;
	 public static final int COURT_HEIGHT =500;
	 public static final int INTERVAL = 35;
	 public static JLabel status;
	 public static JLabel score;
	 public static JOptionPane end;
	 private static int scoreVal;
	 private static boolean playing = false;
	 private BufferedImage img;
	 private Player player;
	 private Map map = new Map();
	 private Direction direction;
	 private List<Ghost> ghosts;
	 public  String ghostFile = "/Users/porterkillian/Documents/Cis120/PacMan/files/ghost.png";
	 private JFrame frame;
	 private boolean hittingWall;
	 boolean endGame;
	 
	 public Maze(JLabel status, JLabel score){
		this.score = score;
		this.status = status;
	    setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    Timer timer = new Timer(INTERVAL, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            tick();
	        }
	    });
	    timer.start();
	    start();
	   
	    
	    setFocusable(true);
	    addKeyListener(new KeyAdapter() {//gets the user input and 
	        public void keyPressed(KeyEvent e) {
	            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		            direction = Direction.LEFT;
		            player.setImage("/Users/porterkillian/Documents/Cis120/PacMan/files/playerLeft.png");//animates the player direction
	            }else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	            	direction = Direction.RIGHT;
		            player.setImage("/Users/porterkillian/Documents/Cis120/PacMan/files/player.png");
	            }else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	            	direction = Direction.DOWN;
	            	player.setImage("/Users/porterkillian/Documents/Cis120/PacMan/files/playerDown.png");
	            }else if (e.getKeyCode() == KeyEvent.VK_UP) {
	            	direction = Direction.UP;
	            	player.setImage("/Users/porterkillian/Documents/Cis120/PacMan/files/playerUp.png");
	            }
	           
	        }
	    });
	    
	    
	}
	public int counter=0;
    void tick() {
        if (!endGame) {
        	player.move(direction,map);
        	if(map.getNextTile(player) instanceof CoinTile){//picks up coin
        		map.getNextTile(player).interact(player);
        		map.changeToPath(player);
        		scoreVal = scoreVal + 10;
        		score.setText("Score: "+ scoreVal);
        	}else if(map.getNextTile(player) instanceof PotionTile){//checks to see what tile is coming up on the player and interacts with it
        		map.getNextTile(player).interact(player);
        		map.changeToPath(player);
        		counter =0;
        	}
        	if(player.getEatMode()){
        		status.setText("Invincible");
        	}
        	counter++;
        	if(counter == 200){// runs for 200 times of the tick allows the player to eat the ghosts
        		player.setEatMode(false);
        		status.setText("Vulnerable");
        		counter = 0;
        	}
        		
        	for(Ghost ghost:ghosts){//moves the ghosts
        		ghost.move(map);
        	}
        	
            repaint();
            for(Ghost ghost:ghosts){//checks to see if a ghost anf the player are hitting if they are the game ends
            	if(ghost.getX()/16 == player.getX()/16 && ghost.getY()/16 == player.getY()/16 && !player.getEatMode()){
            		endGame = true;
            	}else if(ghost.getX()/16 == player.getX()/16 && ghost.getY()/16 == player.getY()/16 && player.getEatMode()){
            		ghost.setToKilled();
            		scoreVal = scoreVal+50;
            	}
            	
            }
            if(endGame){//if the game ends
            	playing = false;
            	String name = JOptionPane.showInputDialog(null,"Enter Name: score of "+ scoreVal);//gets user input for name
            	
            	try {
					FileIO highScore = new FileIO("/Users/porterkillian/Documents/Cis120/PacMan/files/highScore.txt");
					highScore.addScore(name, scoreVal);//creates a file reader and adds the score
					highScore.readFile();
					List<String> scores = highScore.getHighScores();//prints the 5 highest scores
					JOptionPane.showMessageDialog(null,"HighScores" +"\n"+ scores.get(0)+"\n"+scores.get(1)+"\n"+scores.get(2)+"\n"+scores.get(3)+"\n"+scores.get(4));  
					
					int playAgain = JOptionPane.showConfirmDialog(null,"play again?");  
				    if(playAgain == JOptionPane.YES_OPTION){ //if the user wants to play again it allows them to 
					      start();
					} 
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
            }
        }
    }
    
    //resets all of the state to the starting state
    public void start(){
    	scoreVal = 0;
    	player = new Player(16,16);
	    hittingWall = false;
	    ghosts = new LinkedList<Ghost>();
	    ghosts.add(new Ghost(16,96,ghostFile));
	    ghosts.add(new Ghost(16,96,ghostFile));
	    ghosts.add(new Ghost(16,96,ghostFile));
	    direction = Direction.RIGHT;
	    map.resetMap();
	    endGame = false;
    	requestFocusInWindow();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        map.draw(g);
        player.draw(g);
        for(Ghost ghost:ghosts){
        	ghost.draw(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }
}

