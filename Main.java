import java.util.*;
import java.io.*;
//import java.lang.*;

public class Main {

	// character setup
	Character charac = new Character(); // GET THIS WORKING??

	// owned ability lists
	ArrayList<String[]> OwnedActiveAbilities = new ArrayList<String[]>();
	ArrayList<String[]> OwnedPassiveAbilities = new ArrayList<String[]>();

	// full ability lists
	ArrayList<String[]> FullPassiveAbilities = new ArrayList<String[]>()
	ArrayList<String[]> FullActiveAbilities = new ArrayList<String[]>();
	ArrayList<String[]> FullAbilityList = new ArrayList<String[]>();

	// ** FOLLOWING TWO METHODS DIVIDE ABILITIES INTO AL<STRING[]>S
	
	public ArrayList<String[]> getAllAbilities() { //retrieve AL of all abilities
		BufferedReader br = new BufferedReader(new FileReader("file.txt"));
			try {
				ArrayList<String[]> al = new ArrayList<String>();
				String line = br.readLine();
				
				while (line != null) {
					al.add(line.split(","));
					line = br.readLine();
				}
			} finally {
				br.close();
			}
		FullAbilityList = al;
		return al;
	}
	
	public void divideAbilities (ArrayList<String[]> abilities) { //divide abilities into active + passive
		for (int x=0; i<abilities.size();i++){
			for (String[] x : abilities.get(i)){
				if(x[1].equals("passive"){
					FullPassiveAbilities.add(abilities.get(i);}
				else if(x[1].equals("active"){
					FullActiveAbilities.add(abilities.get(i);}
			}
		}
	}
	
	//**CHOOSE WHICH 