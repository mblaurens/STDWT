// ATTACK : ARITHMETIC, basic attack (3)
// XX DAMAGE

public class ArithmeticAttack {
	
	boolean unlocked;
	private final int damage;
	private final int AbilityNumber = 3;
	private final String name = "Arithmetic";
	
	public ArithmeticAttack () {
		unlocked = false;
		damage = 0; // CHANGE VALUE
	}
	
	public void unlock () {
		unlocked = true; }
		
	public int getDamage () { 
		return damage; }
		
	public int getAbilityNumber() {
		return AbilityNumber;}
	
	public String getName() {
		return name; }

}