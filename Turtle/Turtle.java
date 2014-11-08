public class Turtle{
    
    private int baseHP,baseMP,curHP,curMP;
    private int hungerCap,thirstCap,hunger,thirst;
    private int baseStr,curStr,baseInt,curInt,baseDex,curDex;
    private String name;
    
    public Turtle(String n){
	name=n;
	baseHP=10;curHP=10;
	baseMP=10;curMP=10;
	hungerCap=15;hunger=0;
	thirstCap=15;thirst=0;
	baseStr=5;curStr=5;
	baseInt=5;curInt=5;
	baseDex=5;curDex=5;
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
    
}
   
