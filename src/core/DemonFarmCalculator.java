package core;

import java.util.Observable;

import gui.DemonFarmCalculatorGUI;

public class DemonFarmCalculator extends Observable {
	
	public DemonFarmCalculator(DemonFarmCalculatorGUI observer) {
		this.addObserver(observer);
	}
	
	public void getCreatureStackSize(int creatureHitpoints, int pitlords) {
		int demonStackMaximumHP = ((pitlords * 50) / 35) * 35;
		int creatureStackSize = demonStackMaximumHP / creatureHitpoints;
		int test =  (int) Math.ceil(((double) demonStackMaximumHP) / creatureHitpoints);
		if ((demonStackMaximumHP % creatureHitpoints) != 0) {
			creatureStackSize++;
		}
		if (test != creatureStackSize) {
			System.out.println("not the same " + test);
		} else {
			System.out.println("same");
		}
		setChanged();
		notifyObservers("creatures;" + creatureStackSize);
	}
	
	public void getDemonStackSize(int pitlords) {
		int demonStackSize = (pitlords * 50) / 35;
		setChanged();
		notifyObservers("demons;" + demonStackSize);
	}
}
