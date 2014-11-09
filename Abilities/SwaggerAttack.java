// ATTACK : SWAGGER, basic attack (2)
// XX DAMAGE

public class SwaggerAttack {
	
	private boolean unlocked;
	private final int damage;
	private final int AbilityNumber = 2;
	private final String name = "Swagger";
	
	public SwaggerAttack () {
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
		return name; }
}