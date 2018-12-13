import java.awt.image.BufferedImage;

public class PathTile extends Tile {
	//base path tile 
	protected BufferedImage img;
	
	public PathTile(int x, int y,String filePath) {
		super(x, y, filePath);
	}
}
