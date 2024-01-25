package core;

public enum Creature {

	OVERRIDE(-1),
	IMP(4),
	FAMILIAR(4),
	GOG(13),
	MAGOG(13),
	HELLHOUND(25),
	CERBERUS(30),
	BATTLE_DWARF(20),
	CENTAUR(8),
	CENTAUR_CAPTAIN(10),
	CREW_MATE(15),
	DWARF(20),
	GNOLL(6),
	GNOLL_MARAUDER(6),
	GOBLIN(5),
	GREMLIN(4),
	HALBERDIER(10),
	HARPY(6),
	HARPY_HAG(9),
	HOBGOBLIN(5),
	INFERNAL_TROGLODYTE(5),
	LIZARDMAN(14),
	LIZARD_WARRIOR(15),
	MASTER_GREMLIN(4),
	NYMPH(4),
	OCEANID(4),
	PIKEMAN(10),
	PIXIE(3),
	SEAMAN(15),
	SPRITE(3),
	TROGLODYTE(4),
	WOLF_RAIDER(10),
	WOLF_RIDER(10);

	private int hitpoints;

	private Creature(int hitpoints) {
		this.hitpoints = hitpoints;
	}

	public int getHitpoints() {
		return this.hitpoints;
	}

	@Override
	public String toString() {
		if (this == OVERRIDE) {
			return this.name();
		}
		String[] words = this.name().toLowerCase().split("_");
		StringBuilder result = new StringBuilder();

		for (String word : words) {
			result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
		}

		return result.toString().trim();
	}
}
