package net.mercuryq.quark;

public abstract class LivingThing {
	String name;
	int maxHp;
	int hp;
	int maxMp;
	int mp;
	int ac;
	int level;
	boolean isDead;
	Location myLoc;
	public abstract Location move();
	public abstract void updateLoc(Location change);
	public abstract void gainLevel();
}
