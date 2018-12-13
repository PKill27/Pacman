import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CoinTile extends PathTile {
	private String filePath = "/Users/porterkillian/Documents/Cis120/PacMan/files/path.png";
	private BufferedImage imgPath;
	private String fileCoin = "/Users/porterkillian/Documents/Cis120/PacMan/files/coin.png";
	private BufferedImage imgCoin;
	//creates a coin file that has a pick up able coin overlaid on a path tile
	public CoinTile(int x, int y,String filePath) {
		super(x, y, filePath);
		try {
			imgPath = ImageIO.read(new File(this.filePath));
			imgCoin = ImageIO.read(new File(this.fileCoin));
	    } catch (IOException e) {
	        System.out.println("Internal Error:" + e.getMessage());
	    }
	}
	public void interact(Player p){
		
	}
	@Override 
	public void draw(Graphics g){
		g.drawImage(imgPath, x*Tile_Size,y*Tile_Size,Tile_Size,Tile_Size,null);
		g.drawImage(imgCoin, x*Tile_Size,y*Tile_Size,Tile_Size,Tile_Size,null);
	}
}
