package core;

import java.util.Observable;

import gui.DemonFarmCalculatorGUI;

public class DemonFarmCalculator extends Observable {
	
	public DemonFarmCalculator(DemonFarmCalculatorGUI observer) {
		this.addObserver(observer);
	}
	
	public void getStackSizes(int creatureHitpoints, int pitlords) {
		int maxDemons = ((pitlords * 50) / 35);
		int creatureStackSize = 0;
		if (creatureHitpoints >= 35) {
			creatureStackSize = maxDemons;
		} else {
			creatureStackSize = (int) Math.ceil((maxDemons * 35.0) / creatureHitpoints);
		}
		int demonStackSize = Math.min((int)(Math.min(creatureStackSize * creatureHitpoints, pitlords *50)/35), creatureStackSize);
		setChanged();
		notifyObservers("demons;" + demonStackSize + ";" + creatureStackSize);
	}
	
	private float getMultiplier(SkillLevel firstAidLevel, int heroLevel) {
		float multi = 0.00f;
		switch (firstAidLevel) {
			case BASIC:
				multi = 0.05f;
				break;
			case ADVANCED:
				multi = 0.1f;
				break;
			case EXPERT:
				multi = 0.15f;
				break;
			default:
				break;
		}
		if (heroLevel > 0) {
			multi *= 1 + 0.05 * heroLevel;
		}
		return multi + 1;
	}
	
	public int calculateCreatureHP(boolean isOverride, int creatureHP, boolean hasElixir, boolean hasRingOfLife, boolean hasRingOfVitality, boolean hasVialOfLifeblood, SkillLevel firstAidLevel, int heroLevel) {
		if (isOverride) {
			return creatureHP;
		}
		float multi = this.getMultiplier(firstAidLevel, heroLevel);
		if (hasElixir) {
			creatureHP = (int) (creatureHP * (multi + 0.25f));
			creatureHP += 4;
			setChanged();
			notifyObservers("hp;" + creatureHP);
			return creatureHP;	
		}
		creatureHP = (int) (creatureHP * multi);
		if (hasRingOfLife) {
			creatureHP += 1;
		}
		if (hasRingOfVitality) {
			creatureHP += 1;
		}
		if (hasVialOfLifeblood) {
			creatureHP += 2;
		}
		setChanged();
		notifyObservers("hp;" + creatureHP);
		return creatureHP;
	}
}
