package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import core.Creature;
import core.DemonFarmCalculator;
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

public class DemonFarmCalculatorGUI implements ActionListener, Observer {

	private JFrame frmDemonFarmCalculator;
	private JTextField textField_pitlordStack;
	private JTextField textField_demonStack;
	private JTextField textField_creatureStackSize;
	private JComboBox<Creature> comboBox_creature;
	private JCheckBox chckbxRingOfLife;
	private JCheckBox chckbxRingOfVitality;
	private JCheckBox chckbxVialOfLifeblood;
	private JCheckBox chckbxElixirOfLife;
	private DemonFarmCalculator calculator;
	private JLabel lblCreatureHitPoints;
	private JTextField textField_creatureHitPoints;
	private JPanel panelFirstAid;
	private JLabel lblFirstAid;
	private JComboBox<SkillLevel> comboBox_FirstAid;
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
		frmDemonFarmCalculator.setBounds(100, 100, 685, 194);
		frmDemonFarmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDemonFarmCalculator.getContentPane().setLayout(new MigLayout("", "[][grow][grow]", "[][][][][grow]"));
		
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
		
		JLabel lblResultingDemonStack = new JLabel("Resulting Demon stack size:");
		lblResultingDemonStack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmDemonFarmCalculator.getContentPane().add(lblResultingDemonStack, "cell 0 3,alignx right,growy");
		
		textField_demonStack = new JTextField();
		textField_demonStack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_demonStack.setEditable(false);
		frmDemonFarmCalculator.getContentPane().add(textField_demonStack, "cell 1 3,growx");
		textField_demonStack.setColumns(10);
		
		chckbxElixirOfLife = new JCheckBox("Elixir of Life");
		chckbxElixirOfLife.addActionListener(this);
		frmDemonFarmCalculator.getContentPane().add(chckbxElixirOfLife, "cell 2 3");
		
		JLabel lblNeededStackSize = new JLabel("Needed stack size of creature:");
		lblNeededStackSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmDemonFarmCalculator.getContentPane().add(lblNeededStackSize, "cell 0 4,alignx right,growy");
		
		textField_creatureStackSize = new JTextField();
		textField_creatureStackSize.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_creatureStackSize.setEditable(false);
		frmDemonFarmCalculator.getContentPane().add(textField_creatureStackSize, "cell 1 4,growx");
		textField_creatureStackSize.setColumns(10);
		
		panelFirstAid = new JPanel();
		frmDemonFarmCalculator.getContentPane().add(panelFirstAid, "cell 2 4,grow");
		panelFirstAid.setLayout(new MigLayout("", "[][grow]", "[]"));
		
		lblFirstAid = new JLabel("First Aid:");
		panelFirstAid.add(lblFirstAid, "cell 0 0,alignx trailing");
		
		comboBox_FirstAid = new JComboBox<SkillLevel>(SkillLevel.values());
		comboBox_FirstAid.addActionListener(this);
		panelFirstAid.add(comboBox_FirstAid, "cell 1 0,growx");
		
		calculator = new DemonFarmCalculator(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		String[] in = arg.toString().split(";");
		if (in[0].equals("demons")) {
			textField_demonStack.setText(in[1]);
		}
		if (in[0].equals("creatures")) {
			textField_creatureStackSize.setText(in[1]);
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
			int creatureHitpoints = this.calculateCreatureHP();
			int pitLordStack = Integer.parseInt(textField_pitlordStack.getText());
			this.calculate(creatureHitpoints, pitLordStack);
		}
		if (e.getSource() == textField_pitlordStack) {
			if (Integer.parseInt(textField_pitlordStack.getText()) > 0) {
				int creatureHitpoints = this.calculateCreatureHP();
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
			int creatureHitpoints = this.calculateCreatureHP();
			int pitLordStack = Integer.parseInt(textField_pitlordStack.getText());
			this.calculate(creatureHitpoints, pitLordStack);
		}
		if (e.getSource() == textField_creatureHitPoints) {
			int creatureHitpoints = this.calculateCreatureHP();
			int pitLordStack = Integer.parseInt(textField_pitlordStack.getText());
			this.calculate(creatureHitpoints, pitLordStack);
		}
		if (e.getSource() == comboBox_FirstAid) {
			int creatureHitpoints = this.calculateCreatureHP();
			int pitLordStack = Integer.parseInt(textField_pitlordStack.getText());
			this.calculate(creatureHitpoints, pitLordStack);
		}
	}
	
	private int calculateCreatureHP() {
		if (textField_creatureHitPoints.isEditable()) {
			return Integer.parseInt(textField_creatureHitPoints.getText());
		}
		int creatureHP = ((Creature)comboBox_creature.getSelectedItem()).getHitpoints();
		float multi = 1.00f;
		switch ((SkillLevel) comboBox_FirstAid.getSelectedItem()) {
			case BASIC:
				multi = 1.05f;
				break;
			case ADVANCED:
				multi = 1.1f;
				break;
			case EXPERT:
				multi = 1.15f;
				break;
			default:
				break;
		}
		if (chckbxElixirOfLife.isSelected()) {
			creatureHP = (int) (creatureHP * (multi + 0.25f));
			creatureHP += 4;
			textField_creatureHitPoints.setText(Integer.toString(creatureHP));
			return creatureHP;	
		}
		creatureHP = (int) (creatureHP * multi);
		if (chckbxRingOfLife.isSelected()) {
			creatureHP += 1;
		}
		if (chckbxRingOfVitality.isSelected()) {
			creatureHP += 1;
		}
		if (chckbxVialOfLifeblood.isSelected()) {
			creatureHP += 2;
		}
		textField_creatureHitPoints.setText(Integer.toString(creatureHP));
		return creatureHP;
	}

	private void calculate(int creatureHitpoints, int pitLordStack) {
		if (pitLordStack <= 0) {
			return;
		}
		calculator.getDemonStackSize(pitLordStack);
		calculator.getCreatureStackSize(creatureHitpoints, pitLordStack);
	}
}
