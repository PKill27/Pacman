import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PotionTile extends PathTile {
	private String filePath = "/Users/porterkillian/Documents/Cis120/PacMan/files/path.png";
	private BufferedImage imgPath;
	private String filePotion = "/Users/porterkillian/Documents/Cis120/PacMan/files/potion.png";
	private BufferedImage imgPotion;
	//creates a potion tile that allows the user to eat the ghosts
	public PotionTile(int x, int y,String filePath) {
		super(x, y, filePath);
		try {
			imgPath = ImageIO.read(new File(this.filePath));
			imgPotion = ImageIO.read(new File(this.filePotion));
	    } catch (IOException e) {
	        System.out.println("Internal Error:" + e.getMessage());
	    }
	}
	public void interact(Player p){
		p.setEatMode(true);
	}
	@Override
	public void draw(Graphics g){
		g.drawImage(imgPath, x*Tile_Size,y*Tile_Size,Tile_Size,Tile_Size,null);
		g.drawImage(imgPotion, x*Tile_Size,y*Tile_Size,Tile_Size,Tile_Size,null);
	}
	

}
