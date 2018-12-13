import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Player extends Moveable{
	private int xPos;
	private int yPos;
	public  String IMG_FILE = "/Users/porterkillian/Documents/Cis120/PacMan/files/player.png";
	private BufferedImage img;
    private Direction direction;
	private int size=30;
	private int Tile_Size=16;
	private boolean eatMode;
	
	//makes a player class that is moveable
	public Player(int x, int y){
		super(x,y,"/Users/porterkillian/Documents/Cis120/PacMan/files/player.png");
		xPos = x;
		yPos = y;
		setImage(IMG_FILE);
		direction = Direction.RIGHT;
	}
	public void move(Direction direction,Map m) {//moves the player 
		this.direction = direction;
		Tile tile = m.getNextTile(this);
		if(!(tile instanceof WallTile)){
			if(direction == Direction.DOWN){
				yPos = Math.min(Tile_Size*28, yPos+4);
			}else if(direction == Direction.UP){
				yPos = Math.max(Tile_Size, yPos-4);
			}else if(direction == Direction.LEFT){
				xPos = Math.max(Tile_Size, xPos-4);
			}else if(direction == Direction.RIGHT){
				xPos = Math.min(Tile_Size*30, xPos+4);
			}
		}
    }
	public int getSize(){
		return size;
	}
	
	public void setImage(String fileName){//alows for changing of the img for animation
		IMG_FILE = fileName;
		try {
			img = ImageIO.read(new File(IMG_FILE));
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
	}
	public int getX(){
		return xPos;
	}
	public int getY(){
		return yPos;
	}
	public Direction getDirection(){
		return direction;
	}
	public void draw(Graphics g) {
		g.drawImage(img, xPos, yPos, size, size, null);
    }
	public void setEatMode(boolean b){
		eatMode = b;
	}
	public boolean getEatMode(){
		return eatMode;
	}
}
