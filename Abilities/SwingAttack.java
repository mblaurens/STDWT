// ATTACK : SWING, basic attack (1)
// XX DAMAGE

public class SwingAttack {
	
	private boolean unlocked;
	private final int damage;
	private final int AbilityNumber = 1;
	private final String name = "Swing";
	
	public SwingAttack () {
		unlocked = false;
		damage = 0; // CHANGE VALUE
	}
	
	public void unlock () {
		unlocked = true; }
		
	public int getDamage () { 
		return damage; }

	public int getAbilityNumber () {
		return AbilityNumber; }
	
	public String getName() {
		return name;}
		
}