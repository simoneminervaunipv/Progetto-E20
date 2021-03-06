package it.unipv.ingsw.progettoe20.server.admin.view;

import static it.unipv.ingsw.progettoe20.server.admin.model.AdministratorConstants.CONFIRM_BUTTON;
import static it.unipv.ingsw.progettoe20.server.admin.model.AdministratorConstants.HOME_BUTTON;
import static it.unipv.ingsw.progettoe20.server.admin.model.AdministratorConstants.PARKINGLOTS_ADD;
import static it.unipv.ingsw.progettoe20.server.admin.model.AdministratorConstants.PARKINGLOTS_MANAGEMENT;
import static it.unipv.ingsw.progettoe20.server.admin.model.AdministratorConstants.PARKINGLOTS_REMOVE;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.unipv.ingsw.progettoe20.server.admin.controller.ParkingLotsListener;

/**
 * Classe per la gestione del parcheggi. Si può modificare il numero di
 * parcheggi disponibili nella struttura.
 */

public class ParkingLotsManagementGUI extends AbstractGUI {

	private JComboBox<String> combo;
	private JTextField levelname, parkinglots;
	private JLabel title, inserthereLevel, insertherePLots;
	private JPanel panel, panel2, panel3;
	private JButton confirm, home;

	/**
	 * Inizializza una nuova istanza di ParkingManagementGUI.
	 */
	public ParkingLotsManagementGUI() {
		super();
	}

	/**
	 * Restituisce la combo box
	 *
	 * @return combo box
	 */
	public JComboBox<String> getCombo() {
		return combo;
	}

	/**
	 * Restituisce il bottone di home.
	 *
	 * @return il bottone
	 */
	public JButton getHome() {
		return home;
	}

	/**
	 * Restituisce il nome del livello.
	 *
	 * @return nome del livello
	 */
	public JTextField getLevelName() {
		return levelname;
	}

	/**
	 * Restituisce il numero di posti auto.
	 *
	 * @return numero di posti auto.
	 */
	public JTextField getParkingLots() {
		return parkinglots;
	}

	/**
	 * Restituisce il bottone di conferma.
	 *
	 * @return il bottone
	 */
	public JButton getConfirm() {
		return confirm;
	}

	@Override
	public void initComponents() {
		panel = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		title = new JLabel(PARKINGLOTS_MANAGEMENT);
		inserthereLevel = new JLabel("Level name:  ");
		insertherePLots = new JLabel("Parking lots:");
		levelname = new JTextField(10);
		parkinglots = new JTextField(10);
		confirm = new JButton(CONFIRM_BUTTON);
		home = new JButton(HOME_BUTTON);

		String[] items = { PARKINGLOTS_ADD, PARKINGLOTS_REMOVE };
		combo = new JComboBox<>(items);

		// frame settings
		getContentPane().add(panel);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setTitle(PARKINGLOTS_MANAGEMENT);

		// panel settings
		panel.setBackground(new Color(30, 30, 30));
		panel.setLayout(null);

		// panel2 settings
		panel2.setBackground(new Color(30, 30, 30));
		panel2.setLayout(new FlowLayout());

		// panel3 settings
		panel3.setBackground(new Color(30, 30, 30));
		panel3.setLayout(new FlowLayout());

		// title settings
		title.setFont(new Font(Font.MONOSPACED, 3, 30));
		title.setForeground(new Color(196, 10, 255));

		// inserthere1 settings
		inserthereLevel.setFont(new Font(Font.MONOSPACED, 1, 16));
		inserthereLevel.setForeground(new Color(196, 10, 255));
		inserthereLevel.setAlignmentX(LEFT_ALIGNMENT);

		// inserthere2 settings
		insertherePLots.setFont(new Font(Font.MONOSPACED, 1, 16));
		insertherePLots.setForeground(new Color(196, 10, 255));
		insertherePLots.setAlignmentX(LEFT_ALIGNMENT);

		// confirm settings
		confirm.setFont(new Font(Font.MONOSPACED, 1, 20));
		confirm.setBackground(new Color(222, 177, 255));

		// home settings
		home.setFont(new Font(Font.MONOSPACED, 0, 10));
		home.setBackground(new Color(222, 177, 255));

		// field1 settings
		levelname.setFont(new Font(Font.MONOSPACED, 0, 12));
		levelname.setAlignmentX(RIGHT_ALIGNMENT);
		levelname.setForeground(new Color(196, 10, 255));

		// field2 settings
		parkinglots.setFont(new Font(Font.MONOSPACED, 0, 12));
		parkinglots.setAlignmentX(RIGHT_ALIGNMENT);
		parkinglots.setForeground(new Color(196, 10, 255));

		// combobox settings
		combo.setFont(new Font(Font.MONOSPACED, 0, 16));

		// locations settings
		title.setBounds(180, 10, 500, 40);
		confirm.setBounds(190, 250, 200, 40);
		panel2.setBounds(140, 150, 300, 30);
		panel3.setBounds(140, 200, 300, 30);
		combo.setBounds(130, 100, 300, 30);
		home.setBounds(25, 20, 100, 20);

		panel.add(title);
		panel.add(combo);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(confirm);
		panel.add(home);

		panel2.add(inserthereLevel);
		panel2.add(levelname);

		panel3.add(insertherePLots);
		panel3.add(parkinglots);

	}

	@Override
	public void initListener() {
		listener = new ParkingLotsListener(this);
		confirm.addActionListener(listener);
		home.addActionListener(listener);

	}

}
