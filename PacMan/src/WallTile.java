import java.awt.image.BufferedImage;

public class WallTile extends Tile {
	private String filePath = "/Users/porterkillian/Documents/Cis120/PacMan/files/wall.pngs";
	private BufferedImage img;
	//creates a wall tile which a moveable cannot go through
	public WallTile(int x, int y,String filePath) {
		super(x, y, filePath);
	}
}
