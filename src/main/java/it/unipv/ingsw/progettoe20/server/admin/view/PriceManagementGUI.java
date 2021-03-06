package it.unipv.ingsw.progettoe20.server.admin.view;

import static it.unipv.ingsw.progettoe20.server.admin.model.AdministratorConstants.CONFIRM_BUTTON;
import static it.unipv.ingsw.progettoe20.server.admin.model.AdministratorConstants.HOME_BUTTON;
import static it.unipv.ingsw.progettoe20.server.admin.model.AdministratorConstants.PRICE_HOURLY;
import static it.unipv.ingsw.progettoe20.server.admin.model.AdministratorConstants.PRICE_MANAGEMENT;
import static it.unipv.ingsw.progettoe20.server.admin.model.AdministratorConstants.PRICE_MAXIMUM;
import static it.unipv.ingsw.progettoe20.server.admin.model.AdministratorConstants.PRICE_MINIMUM;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.unipv.ingsw.progettoe20.server.admin.controller.PriceListener;

/**
 * Classe per la gestione delle tariffe. Permette di modificare i valori delle
 * diverse tariffe disponibili.
 */

public class PriceManagementGUI extends AbstractGUI {

	private JComboBox<String> combo;
	private JTextField price;
	private JLabel title, insertherePrice;
	private JPanel panel, panel2;
	private JButton confirm, home;

	/**
	 * Inizializza una nuova istanza di PriceManagementGUI.
	 */
	public PriceManagementGUI() {
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
	 * Restituisce il prezzo.
	 *
	 * @return il prezzo
	 */
	public JTextField getPrice() {
		return price;
	}

	/**
	 * Restituisce il bottone di conferma.
	 *
	 * @return il bottone
	 */
	public JButton getConfirm() {
		return confirm;
	}

	/**
	 * Restituisce il bottone di home.
	 *
	 * @return il bottone
	 */
	public JButton getHome() {
		return home;
	}

	@Override
	public void initComponents() {
		panel = new JPanel();
		panel2 = new JPanel();
		title = new JLabel(PRICE_MANAGEMENT);
		insertherePrice = new JLabel("Price:  ");
		price = new JTextField(10);
		confirm = new JButton(CONFIRM_BUTTON);
		home = new JButton(HOME_BUTTON);

		String[] items = { PRICE_HOURLY, PRICE_MAXIMUM, PRICE_MINIMUM };
		combo = new JComboBox<>(items);

		// frame settings
		getContentPane().add(panel);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setTitle(PRICE_MANAGEMENT);

		// panel settings
		panel.setBackground(new Color(30, 30, 30));
		panel.setLayout(null);

		// panel2 settings
		panel2.setBackground(new Color(30, 30, 30));
		panel2.setLayout(new FlowLayout());

		// title settings
		title.setFont(new Font(Font.MONOSPACED, 3, 30));
		title.setForeground(new Color(196, 10, 255));

		// inserthere settings
		insertherePrice.setFont(new Font(Font.MONOSPACED, 1, 16));
		insertherePrice.setForeground(new Color(196, 10, 255));
		insertherePrice.setAlignmentX(LEFT_ALIGNMENT);

		// confirm settings
		confirm.setFont(new Font(Font.MONOSPACED, 1, 20));
		confirm.setBackground(new Color(222, 177, 255));

		// goback settings
		home.setFont(new Font(Font.MONOSPACED, 0, 10));
		home.setBackground(new Color(222, 177, 255));

		// textfield settings
		price.setFont(new Font(Font.MONOSPACED, 0, 12));
		price.setAlignmentX(RIGHT_ALIGNMENT);
		price.setForeground(new Color(196, 10, 255));

		// combobox settings
		combo.setFont(new Font(Font.MONOSPACED, 0, 16));

		// locations settings
		title.setBounds(275, 10, 500, 40);
		confirm.setBounds(190, 230, 200, 40);
		panel2.setBounds(140, 180, 300, 30);
		combo.setBounds(140, 130, 300, 30);
		home.setBounds(25, 20, 100, 20);

		// add
		panel.add(title);
		panel.add(combo);
		panel.add(panel2);
		panel.add(confirm);
		panel.add(home);

		panel2.add(insertherePrice);
		panel2.add(price);
	}

	@Override
	public void initListener() {
		listener = new PriceListener(this);
		confirm.addActionListener(listener);
		home.addActionListener(listener);
	}

}
