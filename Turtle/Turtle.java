public class Turtle{
    
    private int baseHP,baseMP,curHP,curMP;
    private int hungerCap,thirstCap,hunger,thirst;
    private int baseStr,curStr,baseInt,curInt,baseDex,curDex;
    private String name;
    private int level,talents,curXP,reqXP;
    
    public Turtle(String n){
	name=n;
	level = 0; talents = 0;
	baseHP=10;curHP=10;
	baseMP=10;curMP=10;
	hungerCap=15;hunger=0;
	thirstCap=15;thirst=0;
	baseStr=5;curStr=5;
	baseInt=5;curInt=5;
	baseDex=5;curDex=5;
	curXP = 0;reqXP = 0;
    }

    public Turtle(){
	this("Generic Turtle");
    }

    public String getStats(){
	return name
	    +"\nHP:"+curHP+"/"+baseHP+"\tMP:"+curMP+"/"+baseMP
		+"\nHunger:"+hunger+"/"+hungerCap+"\tThirst:"+thirst+"/"+thirstCap
		+"\nStubornness:"+curStr+"/"+baseStr
		+"\tWisdom:"+curInt+"/"+baseInt
		+"\tSlipperyness:"+curDex+"/"+baseDex;
    }
	public void ding(){
		if (curXP >= reqXP) {
			level++;
			talents++;
			baseHP += 5; curHP = baseHP;   //just a template these numbers might not be balanced 
			baseMP += 5; curMP = baseMP;
			baseStr += 2; curStr =+ 2;
			baseDex += 2; curDex =+ 2;
			baseInt += 2; curInt =+ 2;
			curXP = 0;
			reqXP = 5;  // need leveling up system
		}

	}    
}
   
