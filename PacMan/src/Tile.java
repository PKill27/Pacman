import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Tile {
	protected BufferedImage img;
	protected int x;
	protected int y;
	protected int Tile_Size = 16;
	//creates a tile class that no instances can be made of because each tile has special atributes
	public Tile(int x, int y, String filePath){
		try {
			img = ImageIO.read(new File(filePath));
	    } catch (IOException e) {
	        System.out.println("Internal Error:" + e.getMessage());
	    }
		this.x = x;
		this.y = y;
	}
	public void interact(Player p){
		
	}
	public void draw(Graphics g){
		g.drawImage(img, x*Tile_Size,y*Tile_Size,Tile_Size,Tile_Size,null);
	}
}
