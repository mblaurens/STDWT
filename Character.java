import java.io.*;
import java.util.*;

public class Character {

	private int stubbornness;
	private int wisdom;
	private int dodge;
	private int health;
	private int defense;
	private int money;
	private int spellDamage;
	private int slipperiness;
	private int xp;
	private int xpToNextLevel;

	public Character() { // constructor method, EDIT
		stubbornness = 0;
		wisdom = 0;
		dodge = 0;
		health = 0;
		defense = 0;
		money = 0;
		spellDamage = 0;
		slipperiness = 0;
		xp = 0;
		xpToNextLevel = 0;
	}
	
	// retrieve info from object
	public int getStubbornness() { return stubbornness; }
	public int getWisdom() { return wisdom; }
	public int getDodge() { return dodge; }
	public int getHealth() { return health; }
	public int getDefense() { return defense; }
	public int getMoney() { return money; }
	public int getSpellDamage() { return spellDamage(); }
	public int getSlipperiness() { return slipperiness; }
	public int getXP() { return xp; }
	public int getXPToNextLevel() { return xpToNextLevel; }
	
	// add to stats, for passive abilities
	public void addStubbornness(int n){ stubbornness += n; }
	public void addWisdom(int n){ wisdom += n; }
	public void addDodge(int n){ dodge += n; }
	public void addHealth(int n){ health += n; }
	public void addDefense(int n){ defense += n; }
	public void addMoney(int n){ money += n; }
	public void addSpellDamage(int n){ spellDamage += n; }
	public void addSlipperiness(int n){ slipperiness += n; }
	
}
