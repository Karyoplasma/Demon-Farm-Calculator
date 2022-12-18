package core;

public enum Creature {
	
	OVERRIDE			(-1),
	Imp					(4),
	Familiar			(4),
	Gog					(13),
	Magog				(13),
	Hellhound			(25),
	Cerberus			(30),
	BattleDwarf			(20),
	Centaur				(8),
	CentaurCaptain		(10),
	CrewMate			(15),
	Dwarf				(20),
	Gnoll				(6),
	GnollMarauder		(6),
	Goblin				(5),
	Gremlin				(4),
	Halberdier			(10),
	Harpy				(6),
	HarpyHag			(9),
	Hobgoblin			(5),
	InfernalTroglodyte	(5),
	Lizardman			(14),
	LizardWarrior		(15),
	MasterGremlin		(4),
	Nymph				(4),
	Oceanid				(4),
	Pikeman				(10),
	Pixie				(3),
	Seaman				(15),
	Sprite				(3),
	Troglodyte			(4),
	WolfRaider			(10),
	WolfRider			(10);
	
	private int hitpoints;
	
	private Creature(int hitpoints) {
		this.hitpoints = hitpoints;
	}
	
	public int getHitpoints() {
		return this.hitpoints;
	}
}
