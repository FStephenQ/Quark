package net.mercuryq.quark;



public class Player extends LivingThing{
	
	public Player(String pName, Location loc){	
		this.name = pName;
		this.myLoc = loc;
		maxHp = 20;
		maxMp = 20;
		ac = 2;
		level = 1;
		hp = 20;
		mp = 20;
		isDead = false;
	}
	
	public void updateLoc(Location change){
		this.myLoc = change;
	}

	@Override
	public Location move() {
		return null;
	}

	@Override
	public void gainLevel() {
		this.level++;
		this.maxMp += 15;
		this.maxHp += 10;
		
	}
}
