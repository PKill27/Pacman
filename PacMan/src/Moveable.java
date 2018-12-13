import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Moveable {
	protected int xPos;
	protected int yPos;
	public  String IMG_FILE = "/Users/porterkillian/Documents/Cis120/PacMan/files/player.png";
	private BufferedImage img;
    protected Direction direction;
    private int size= 32;
    
    //creates an abstract class for moveables like players and ghosts
	public Moveable(int x, int y, String filePath){
		xPos = x;
		yPos = y;
		setImage(filePath);
		direction = Direction.RIGHT;
	}
	public int getSize(){
		return size;
	}
	public void move(Direction direction) {
        this.xPos += 0;
        this.yPos += 0;
        this.direction = direction;
    }
	public void setImage(String fileName){
		IMG_FILE = fileName;
		try {
			img = ImageIO.read(new File(IMG_FILE));
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
	}
	public void setDirection(Direction d){
		direction = d;
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
}
