package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import core.Creature;
import core.DemonFarmCalculator;
import core.HeroLevelSpinnerChangeListener;
import core.SkillLevel;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;

public class DemonFarmCalculatorGUI implements ActionListener, Observer {

	private JFrame frmDemonFarmCalculator;
	public JTextField textField_pitlordStack;
	private JTextField textField_demonStack;
	public JTextField textField_creatureStackSize;
	public JComboBox<Creature> comboBox_creature;
	public JCheckBox chckbxRingOfLife;
	public JCheckBox chckbxRingOfVitality;
	public JCheckBox chckbxVialOfLifeblood;
	public JCheckBox chckbxElixirOfLife;
	private DemonFarmCalculator calculator;
	private JLabel lblCreatureHitPoints;
	public JTextField textField_creatureHitPoints;
	private JPanel panelFirstAid;
	private JLabel lblFirstAid;
	public JComboBox<SkillLevel> comboBox_FirstAid;
	private JPanel panelSpecialtyLevel;
	private JLabel lblSpecialtyLevel;
	public JSpinner spinner_HeroLevel;
	private JLabel lblTooltip;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemonFarmCalculatorGUI window = new DemonFarmCalculatorGUI();
					window.frmDemonFarmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DemonFarmCalculatorGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDemonFarmCalculator = new JFrame();
		frmDemonFarmCalculator.setTitle("Demon Farm Calculator");
		frmDemonFarmCalculator.setBounds(100, 100, 685, 250);
		frmDemonFarmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDemonFarmCalculator.getContentPane().setLayout(new MigLayout("", "[][grow][grow]", "[][][][][][grow]"));
		
		comboBox_creature = new JComboBox<Creature>();
		comboBox_creature.setModel(new DefaultComboBoxModel<Creature>(Creature.values()));
		comboBox_creature.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_creature.setSelectedIndex(1);
		comboBox_creature.addActionListener(this);
		frmDemonFarmCalculator.getContentPane().add(comboBox_creature, "cell 0 0 2 1,growx");
		
		chckbxRingOfLife = new JCheckBox("Ring of Life");
		chckbxRingOfLife.addActionListener(this);
		frmDemonFarmCalculator.getContentPane().add(chckbxRingOfLife, "cell 2 0");
		
		chckbxRingOfVitality = new JCheckBox("Ring of Vitality");
		chckbxRingOfVitality.addActionListener(this);
		
		lblCreatureHitPoints = new JLabel("Creature hit points:");
		lblCreatureHitPoints.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreatureHitPoints.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmDemonFarmCalculator.getContentPane().add(lblCreatureHitPoints, "cell 0 1,alignx right,growy");
		
		textField_creatureHitPoints = new JTextField();
		textField_creatureHitPoints.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_creatureHitPoints.setEditable(false);
		frmDemonFarmCalculator.getContentPane().add(textField_creatureHitPoints, "cell 1 1,growx");
		textField_creatureHitPoints.setColumns(10);
		frmDemonFarmCalculator.getContentPane().add(chckbxRingOfVitality, "cell 2 1");
		
		JLabel lblPitLordStack = new JLabel("Pit Lord stack size:");
		lblPitLordStack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmDemonFarmCalculator.getContentPane().add(lblPitLordStack, "cell 0 2,alignx right,growy");
		
		textField_pitlordStack = new JTextField();
		textField_pitlordStack.setText("1");
		textField_pitlordStack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_pitlordStack.addActionListener(this);
		frmDemonFarmCalculator.getContentPane().add(textField_pitlordStack, "cell 1 2,growx");
		textField_pitlordStack.setColumns(10);
		
		chckbxVialOfLifeblood = new JCheckBox("Vial of Lifeblood");
		chckbxVialOfLifeblood.addActionListener(this);
		frmDemonFarmCalculator.getContentPane().add(chckbxVialOfLifeblood, "cell 2 2");
		
		chckbxElixirOfLife = new JCheckBox("Elixir of Life");
		chckbxElixirOfLife.addActionListener(this);
		frmDemonFarmCalculator.getContentPane().add(chckbxElixirOfLife, "cell 2 3");
		
		JLabel lblResultingDemonStack = new JLabel("Resulting Demon stack size:");
		lblResultingDemonStack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmDemonFarmCalculator.getContentPane().add(lblResultingDemonStack, "cell 0 4,alignx right,growy");
		
		textField_demonStack = new JTextField();
		textField_demonStack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_demonStack.setEditable(false);
		frmDemonFarmCalculator.getContentPane().add(textField_demonStack, "cell 1 4,growx");
		textField_demonStack.setColumns(10);
		
		panelFirstAid = new JPanel();
		frmDemonFarmCalculator.getContentPane().add(panelFirstAid, "cell 2 4,grow");
		panelFirstAid.setLayout(new MigLayout("", "[][grow]", "[]"));
		
		lblFirstAid = new JLabel("First Aid:");
		panelFirstAid.add(lblFirstAid, "cell 0 0,alignx leading");
		
		comboBox_FirstAid = new JComboBox<SkillLevel>(SkillLevel.values());
		comboBox_FirstAid.addActionListener(this);
		panelFirstAid.add(comboBox_FirstAid, "cell 1 0,growx");
		
		JLabel lblNeededStackSize = new JLabel("Needed stack size of creature:");
		lblNeededStackSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmDemonFarmCalculator.getContentPane().add(lblNeededStackSize, "cell 0 5,alignx right,growy");
		
		textField_creatureStackSize = new JTextField();
		textField_creatureStackSize.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_creatureStackSize.setEditable(false);
		frmDemonFarmCalculator.getContentPane().add(textField_creatureStackSize, "cell 1 5,growx");
		textField_creatureStackSize.setColumns(10);
		
		panelSpecialtyLevel = new JPanel();
		frmDemonFarmCalculator.getContentPane().add(panelSpecialtyLevel, "cell 2 5,grow");
		panelSpecialtyLevel.setLayout(new MigLayout("", "[][grow][]", "[grow]"));
		
		lblSpecialtyLevel = new JLabel("Level if Specialty:");
		panelSpecialtyLevel.add(lblSpecialtyLevel, "cell 0 0,alignx leading");
		
		spinner_HeroLevel = new JSpinner();
		spinner_HeroLevel.setModel(new SpinnerNumberModel(Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(100), Integer.valueOf(1)));
		spinner_HeroLevel.addChangeListener(new HeroLevelSpinnerChangeListener(this));
		panelSpecialtyLevel.add(spinner_HeroLevel, "cell 1 0,growx");
		
		lblTooltip = new JLabel("?");
		lblTooltip.setToolTipText("The level of your hero if they have First Aid as a specialty. Leave at -1 if not using a specialist.");
		lblTooltip.setForeground(new Color(0, 0, 255));
		lblTooltip.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelSpecialtyLevel.add(lblTooltip, "cell 2 0");
		
		calculator = new DemonFarmCalculator(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		String[] in = arg.toString().split(";");
		if (in[0].equals("demons")) {
			textField_demonStack.setText(in[1]);
			textField_creatureStackSize.setText(in[2]);
		}
		if (in[0].equals("hp")) {
			textField_creatureHitPoints.setText(in[1]);
		}	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboBox_creature) {
			if (comboBox_creature.getSelectedIndex() == 0) {
				textField_creatureHitPoints.setEditable(true);
				textField_creatureHitPoints.addActionListener(this);
				return;
			}
			textField_creatureHitPoints.setEditable(false);
			textField_creatureHitPoints.removeActionListener(this);
			int creatureHitpoints = calculator.calculateCreatureHP(textField_creatureHitPoints.isEditable(), ((Creature)comboBox_creature.getSelectedItem()).getHitpoints(), chckbxElixirOfLife.isSelected(), chckbxRingOfLife.isSelected(), chckbxRingOfVitality.isSelected(), chckbxVialOfLifeblood.isSelected(), (SkillLevel) comboBox_FirstAid.getSelectedItem(), (int) spinner_HeroLevel.getValue());
			int pitLordStack = Integer.parseInt(textField_pitlordStack.getText());
			this.calculate(creatureHitpoints, pitLordStack);
		}
		if (e.getSource() == textField_pitlordStack) {
			if (Integer.parseInt(textField_pitlordStack.getText()) > 0) {
				int creatureHitpoints = calculator.calculateCreatureHP(textField_creatureHitPoints.isEditable(), ((Creature)comboBox_creature.getSelectedItem()).getHitpoints(), chckbxElixirOfLife.isSelected(), chckbxRingOfLife.isSelected(), chckbxRingOfVitality.isSelected(), chckbxVialOfLifeblood.isSelected(), (SkillLevel) comboBox_FirstAid.getSelectedItem(), (int) spinner_HeroLevel.getValue());
				int pitLordStack = Integer.parseInt(textField_pitlordStack.getText());
				this.calculate(creatureHitpoints, pitLordStack);
			}
		}
		if (e.getSource() instanceof JCheckBox) {
			if (e.getSource() == chckbxElixirOfLife) {
				if (chckbxElixirOfLife.isSelected()) {
					chckbxRingOfLife.setSelected(false);
					chckbxRingOfLife.setEnabled(false);
					chckbxRingOfVitality.setSelected(false);
					chckbxRingOfVitality.setEnabled(false);
					chckbxVialOfLifeblood.setSelected(false);
					chckbxVialOfLifeblood.setEnabled(false);
				} else {
					chckbxRingOfLife.setEnabled(true);
					chckbxRingOfVitality.setEnabled(true);
					chckbxVialOfLifeblood.setEnabled(true);
				}
			}
			int creatureHitpoints = calculator.calculateCreatureHP(textField_creatureHitPoints.isEditable(), ((Creature)comboBox_creature.getSelectedItem()).getHitpoints(), chckbxElixirOfLife.isSelected(), chckbxRingOfLife.isSelected(), chckbxRingOfVitality.isSelected(), chckbxVialOfLifeblood.isSelected(), (SkillLevel) comboBox_FirstAid.getSelectedItem(), (int) spinner_HeroLevel.getValue());
			int pitLordStack = Integer.parseInt(textField_pitlordStack.getText());
			this.calculate(creatureHitpoints, pitLordStack);
		}
		if (e.getSource() == textField_creatureHitPoints) {
			int creatureHitpoints = calculator.calculateCreatureHP(textField_creatureHitPoints.isEditable(), ((Creature)comboBox_creature.getSelectedItem()).getHitpoints(), chckbxElixirOfLife.isSelected(), chckbxRingOfLife.isSelected(), chckbxRingOfVitality.isSelected(), chckbxVialOfLifeblood.isSelected(), (SkillLevel) comboBox_FirstAid.getSelectedItem(), (int) spinner_HeroLevel.getValue());
			int pitLordStack = Integer.parseInt(textField_pitlordStack.getText());
			this.calculate(creatureHitpoints, pitLordStack);
		}
		if (e.getSource() == comboBox_FirstAid) {
			int creatureHitpoints = calculator.calculateCreatureHP(textField_creatureHitPoints.isEditable(), ((Creature)comboBox_creature.getSelectedItem()).getHitpoints(), chckbxElixirOfLife.isSelected(), chckbxRingOfLife.isSelected(), chckbxRingOfVitality.isSelected(), chckbxVialOfLifeblood.isSelected(), (SkillLevel) comboBox_FirstAid.getSelectedItem(), (int) spinner_HeroLevel.getValue());
			int pitLordStack = Integer.parseInt(textField_pitlordStack.getText());
			this.calculate(creatureHitpoints, pitLordStack);
		}
	}
		
	public void calculate(int creatureHitpoints, int pitLordStack) {
		if (pitLordStack <= 0) {
			return;
		}
		calculator.getStackSizes(creatureHitpoints, pitLordStack);
	}
	
	public DemonFarmCalculator getCalculator() {
		return this.calculator;
	}
}
