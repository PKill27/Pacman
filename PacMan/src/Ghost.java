import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Ghost extends Moveable{
	private BufferedImage img;
	private int Tile_Size =16;
	private boolean killed;
	public Ghost(int x, int y, String filePath) {
		super(x, y, filePath);
		
	}
	public int getXTile(){
		return xPos/Tile_Size;
	}
	public int getYTile(){
		return yPos/Tile_Size;
	}
	public int moveCount = 12;
	public boolean newTileEntered(){
		if(moveCount == 16){
			moveCount=0;
			return true;
		}else{
			return false;
		}
	}
	
	public void move(Map m){
		Tile tile = m.getNextTile(this);
			if(tile instanceof WallTile){
				changeDirectionWall(m);
			}else{
				if(newTileEntered()&&!(tile instanceof WallTile)){
					changeDirection(m);
				}
				if(direction == Direction.DOWN){//moves the ghost
					yPos = Math.min(Tile_Size*28, yPos+4);
					moveCount +=4;
				}else if(direction == Direction.UP){
					yPos = Math.max(Tile_Size, yPos-4);
					moveCount +=4;
				}else if(direction == Direction.LEFT){
					xPos = Math.max(Tile_Size, xPos-4);
					moveCount +=4;
				}else if(direction == Direction.RIGHT){
					xPos = Math.min(Tile_Size*30, xPos+4);
					moveCount +=4;
				}
			}
	}
	
	public void changeDirectionWall(Map map){//if the ghost hits a wall then it changes direction randomly
		int wallsChecked = (int)(Math.random() * ((3) + 1));
		if(wallsChecked == 0){
			direction = Direction.LEFT;
		}else if(wallsChecked == 1){
			direction = Direction.RIGHT;
		}else if(wallsChecked == 2){
			direction = Direction.DOWN;
		}else if(wallsChecked == 3){
			direction = Direction.UP;
		}
		
	}
	public void changeDirection(Map map){//changes the direction by finding the posible paths and choosing one randomly
		ArrayList<Direction> d = map.hasNewPath(this);
		System.out.println(d);
		int rand = (int)(Math.random() * ((d.size()-1) + 1));
		if((d.get(rand)==Direction.UP && this.direction!=Direction.DOWN)||(d.get(rand)==Direction.DOWN && this.direction!=Direction.UP)||
		(d.get(rand)==Direction.LEFT && this.direction!=Direction.RIGHT)||(d.get(rand)==Direction.RIGHT && this.direction!=Direction.LEFT)){
				System.out.println(d.get(rand));
				this.direction = d.get(rand);
		}if(d.get(rand)==Direction.RIGHT&&d.size()==1){
            this.direction = Direction.RIGHT;
        }if(d.get(rand)==Direction.LEFT&&d.size()==1){
            this.direction = Direction.LEFT;
        }
	}
	public void setToKilled(){//resets the ghost 
		killed = true;
		direction = Direction.RIGHT;
		xPos = 16;
		yPos = 16*15;
	}
}
