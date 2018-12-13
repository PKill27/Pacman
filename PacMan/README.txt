The game that I made for this project is pacman
The four topics that I implemented in my project are 2d arrays,Collections,FileIO, and Inheritance and subtyping
The majority of my work happens in my map class that stores a 2d-array of the map, it also has methods to check user movement
I used collection to store my ghosts as I have more than one ghost in the game
FileIO was done in my FileIO class and consists of saving and storing a username with a score in the game.
Subtyping was done all through my code as explained by my classes:

	Game: managed the majority of the GUI has the main class and created the original frame the game is played in
	Maze: holds all of the state of the Game is a JFrame that is displayed to the screen, manages what to do on loss and user input
	Map: stores the state of the map along with helpful methods to get tiles that are needed, uses a 2-d array to store state
	Direction: enum that has all of the directions a moveable can have
	Moveable:abstract class makes the methods for a basic movable object
		Player:extends the Moveable class and moves based on input passed by Maze and Map
		Ghost:extend the Moveable class and moves randomly based on information passed by Maze and Map
	Tile:abstract class for a tile which is how the maze is represented
		PathTile:A tile that can be traveled along
		WallTile:A tile that cannot be traveled on
		CoinTile:A path tile that has a pick up able coin on top that adds to the score of the player
		PotionTile:A path tile that has a pick up able potion that allows the player to eat ghosts
	