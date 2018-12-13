import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Map {
	int[][] map = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
			{ 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1 },
			{ 1, 2, 2, 1, 0, 0, 1, 2, 2, 1, 0, 0, 1, 2, 2, 1, 2, 2, 1, 0, 0, 1, 2, 2, 1, 0, 0, 1, 2, 2, 1 },
			{ 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
			{ 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 3, 2, 2, 2, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 3, 2, 2, 2, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 0, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 0, 0, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 0, 0, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 0, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 0, 0, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 0, 0, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
			{ 1, 3, 3, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1 },
			{ 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1 },
			{ 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1 },
			{ 1, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
		//creates the map through representation of integers, that are later converted to tile objects
	private Tile[][] tiles;
	private int Tile_Size = 16;
	private String fileWall = "/Users/porterkillian/Documents/Cis120/PacMan/files/wall.png";
	private String filePath = "/Users/porterkillian/Documents/Cis120/PacMan/files/path.png";
	private String fileCoin = "/Users/porterkillian/Documents/Cis120/PacMan/files/coin.png";
	private String filePotion = "/Users/porterkillian/Documents/Cis120/PacMan/files/potion.png";

	public Map() {
		tiles = new Tile[map.length][map[0].length];
		resetMap();
	}
	//resets the map on a new game
	public void resetMap() {
		tiles = new Tile[map.length][map[0].length];
		for (int i = 0; i < map[0].length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[j][i] == 1) {
					tiles[j][i] = new WallTile(i, j, fileWall);
				} else if (map[j][i] == 0) {
					tiles[j][i] = new PathTile(i, j, filePath);
				} else if (map[j][i] == 2) {
					tiles[j][i] = new CoinTile(i, j, fileCoin);
				} else if (map[j][i] == 3) {
					tiles[j][i] = new PotionTile(i, j, filePotion);
				}
			}
		}
	}
	
	//changes the tile to a path after the item is picked up
	public void changeToPath(Player p) {
		int playerX = p.getX();
		int playerY = p.getY();
		Direction d = p.getDirection();
		// up and left do not work correctly but down and right do
		if (d.equals(Direction.UP)) {
			tiles[(int) (Math.round((playerY + 0.0) / Tile_Size) - 1)][playerX / Tile_Size] = new PathTile(
					playerX / Tile_Size, (int) (Math.round((playerY + 0.0) / Tile_Size) - 1), filePath);
			tiles[(int) (Math.round((playerY + 0.0) / Tile_Size) - 1)][playerX / Tile_Size + 1] = new PathTile(
					playerX / Tile_Size + 1, (int) (Math.round((playerY + 0.0) / Tile_Size) - 1), filePath);
		} else if (d.equals(Direction.DOWN)) {
			tiles[playerY / Tile_Size + 2][playerX / Tile_Size] = new PathTile(playerX / Tile_Size,
					playerY / Tile_Size + 2, filePath);
			tiles[playerY / Tile_Size + 2][playerX / Tile_Size + 1] = new PathTile(playerX / Tile_Size + 1,
					playerY / Tile_Size + 2, filePath);
		} else if (d.equals(Direction.LEFT)) {
			tiles[playerY / Tile_Size][(playerX) / Tile_Size - 1] = new PathTile(playerX / Tile_Size - 1,
					playerY / Tile_Size, filePath);
			tiles[playerY / Tile_Size + 1][(playerX) / Tile_Size - 1] = new PathTile(playerX / Tile_Size - 1,
					playerY / Tile_Size + 1, filePath);
		} else if (d.equals(Direction.RIGHT)) {
			tiles[playerY / Tile_Size][playerX / Tile_Size + 2] = new PathTile(playerX / Tile_Size + 2,
					playerY / Tile_Size, filePath);
			tiles[playerY / Tile_Size + 1][playerX / Tile_Size + 2] = new PathTile(playerX / Tile_Size + 2,
					playerY / Tile_Size + 1, filePath);
		}
	}

	//draws all of the tiles
	public void draw(Graphics g) {
		for (int i = 0; i < map[0].length; i++) {
			for (int j = 0; j < map.length; j++) {
				tiles[j][i].draw(g);
			}
		}
	}

	// gets the next tile for the packman this was very difficult to do and looks awful because I made the path tiles 2 wide
	public Tile getNextTile(Moveable p) {
		int playerX = p.getX();
		int playerY = p.getY();
		Direction d = p.getDirection();
		int size = p.getSize();
		if (d.equals(Direction.UP)) {
			if (tiles[(playerY) / Tile_Size - 1][((playerX) / Tile_Size) + 1].getClass()
					.equals(tiles[(playerY) / Tile_Size - 1][((playerX) / Tile_Size)].getClass())) {
				return tiles[Math.max(1, (playerY - 2) / Tile_Size)][((playerX) / Tile_Size) + 1];
			}
		} else if (d.equals(Direction.DOWN)) {
			if (tiles[(playerY) / Tile_Size + 2][((playerX) / Tile_Size)].getClass()
					.equals(tiles[(playerY) / Tile_Size + 2][((playerX) / Tile_Size) + 1].getClass())) {
				return tiles[(playerY) / Tile_Size + 2][((playerX) / Tile_Size)];
			}
		} else if (d.equals(Direction.LEFT)) {
			if (tiles[(playerY) / Tile_Size][(Math.round((playerX) / Tile_Size)) - 1].getClass()
					.equals(tiles[(playerY) / Tile_Size + 1][((playerX) / Tile_Size) - 1].getClass())) {
				return tiles[(playerY) / Tile_Size][Math.max((playerX - 2) / Tile_Size, 1)];
			}
		} else if (d.equals(Direction.RIGHT)) {
			if (tiles[(playerY) / Tile_Size][((playerX) / Tile_Size) + 2].getClass()
					.equals(tiles[(playerY) / Tile_Size + 1][((playerX) / Tile_Size) + 2].getClass())) {
				return tiles[(playerY) / Tile_Size][((playerX) / Tile_Size) + 2];
			}
		}
		return new WallTile(2, 2, "/Users/porterkillian/Documents/Cis120/PacMan/files/ghost.png");
	}
	public boolean checkIfWin(){
		for (int i = 0; i < tiles[0].length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if(tiles[i][j] instanceof CoinTile){
					return false;
				}
			}
		}
		return true;
	}
	//gets the next tile for the ghost
	public Tile getNextTileForDirection(Moveable p, Direction d) {
		int playerX = p.getX();
		int playerY = p.getY();
		if (d.equals(Direction.UP)) {
			if (tiles[(playerY) / Tile_Size - 1][((playerX) / Tile_Size) + 1] instanceof PathTile
					&& tiles[(playerY) / Tile_Size - 1][((playerX) / Tile_Size)] instanceof PathTile) {
				return tiles[Math.max(1, (playerY) / Tile_Size - 1)][((playerX) / Tile_Size) + 1];
			}
		} else if (d.equals(Direction.DOWN)) {
			if (tiles[(playerY) / Tile_Size + 2][((playerX) / Tile_Size)] instanceof PathTile
					&& tiles[(playerY) / Tile_Size + 2][((playerX) / Tile_Size) + 1] instanceof PathTile) {
				return tiles[(playerY) / Tile_Size + 2][((playerX) / Tile_Size)];
			}
		} else if (d.equals(Direction.LEFT)) {
			if (tiles[(playerY) / Tile_Size][((playerX) / Tile_Size) - 1] instanceof PathTile
					&& tiles[(playerY) / Tile_Size + 1][((playerX) / Tile_Size) - 1] instanceof PathTile) {
				return tiles[(playerY) / Tile_Size][((playerX) / Tile_Size) - 1];
			}
		} else if (d.equals(Direction.RIGHT)) {
			if (tiles[(playerY) / Tile_Size][((playerX) / Tile_Size) + 2] instanceof PathTile
					&& tiles[(playerY) / Tile_Size + 1][((playerX) / Tile_Size) + 2] instanceof PathTile) {
				return tiles[(playerY) / Tile_Size][((playerX) / Tile_Size) + 2];
			}
		}

		return new WallTile(0, 0, "/Users/porterkillian/Documents/Cis120/PacMan/files/ghost.png");
	}

	//gets all of the possible paths for a ghost to take
	public ArrayList<Direction> hasNewPath(Moveable p) {
		ArrayList<Direction> directions = new ArrayList<Direction>();
		if (getNextTileForDirection(p, Direction.UP) instanceof PathTile) {
			directions.add(Direction.UP);
		}
		if (getNextTileForDirection(p, Direction.DOWN) instanceof PathTile) {
			directions.add(Direction.DOWN);
		}
		if (getNextTileForDirection(p, Direction.LEFT) instanceof PathTile) {
			directions.add(Direction.LEFT);
		}
		if (getNextTileForDirection(p, Direction.RIGHT) instanceof PathTile) {
			directions.add(Direction.RIGHT);
		}
		return directions;
	}
}
