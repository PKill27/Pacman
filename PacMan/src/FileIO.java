import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FileIO {
	private String file;
	private List<String> fullScore;
	private List<Integer> scores;
	private List<String> users;
	public FileIO(String file) throws FileNotFoundException, UnsupportedEncodingException{
		 users = new ArrayList<String>();
		 this.file = file;
		 readFile();
	}
	public void readFile(){//reads the file
		scores=new ArrayList<Integer>();
		fullScore = new ArrayList<String>();
		
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        String line = reader.readLine();
	        while (line != null)               
	        {
	        	fullScore.add(line);//adds all of the lines to a linked list
	            try {
	            	String[] score = line.split(" ");
	            	scores.add(Integer.parseInt(score[1]));//adds all of the users scores
	            } catch (NumberFormatException e1) {
	                
	            }
	            line = reader.readLine();
	        }
	        reader.close();

	    } catch (IOException ex) {
	        System.err.println("ERROR reading scores from file");
	    }
	}
	
	public void sortScores(){//sorts the scores and also assigns the new sorted scores to a username 
		Collections.sort(scores);
		Collections.reverse(scores);
		System.out.println(fullScore);
		for(int score:scores){
			for(String str: fullScore){
				String[] place = str.split(" ");
            	int sc =Integer.parseInt(place[place.length -1]);   
				if(sc == score){
					users.add(str);
				}
			}
		}
	}
	
    
	
	public void addScore(String userName, int score){
		try {//adds a new score and rewrites the file with the new information
	        BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
	        output.newLine();
	        if(userName == null){
	        	output.append("N/A "+ score);
	        }else{
	        	output.append(userName+" "+ score);
	        }
	        output.close();

	    } catch (IOException ex1) {
	        System.out.printf("ERROR writing score to file: %s\n", ex1);
	    }
	}
	//gets the new sorted scores ready for display
	public List<String> getHighScores(){
		sortScores();
		return users;
	}
	
}
