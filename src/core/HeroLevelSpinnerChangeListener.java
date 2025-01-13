package core;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gui.DemonFarmCalculatorGUI;

public class HeroLevelSpinnerChangeListener implements ChangeListener {
	
	DemonFarmCalculatorGUI gui;
	
	
	public HeroLevelSpinnerChangeListener(DemonFarmCalculatorGUI gui) {
		this.gui = gui;
	}


	@Override
	public void stateChanged(ChangeEvent e) {
		int creatureHitpoints = gui.getCalculator().calculateCreatureHP(gui.textField_creatureHitPoints.isEditable(), ((Creature)gui.comboBox_creature.getSelectedItem()).getHitpoints(), gui.chckbxElixirOfLife.isSelected(), gui.chckbxRingOfLife.isSelected(), gui.chckbxRingOfVitality.isSelected(), gui.chckbxVialOfLifeblood.isSelected(), (SkillLevel) gui.comboBox_FirstAid.getSelectedItem(), (int) gui.spinner_HeroLevel.getValue());
		int pitLordStack = Integer.parseInt(gui.textField_pitlordStack.getText());
		gui.calculate(creatureHitpoints, pitLordStack);

	}

}
