// generic ability class, for all abilities
// to be held in ArrayList

public class Ability {

	private int baseDamage; // damage is calculated by a base damage + scaling bonus damage
	private int scaling;
	private String name; // name of ability, for reference

	public Ability (int baseDamage, int scaling, String name) { // basic constructor
		this.baseDamage = baseDamage;
		this.scaling = scaling;
		this.name = name;
	}
	
	public int getDamage ( int stubbornness ) { // retrieve damage
		return baseDamage + ( stubbornness * scaling ); }
	
	public int getName() {
		return name; }

}
		
		