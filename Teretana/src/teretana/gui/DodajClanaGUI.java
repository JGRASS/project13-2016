package teretana.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Toolkit;
import java.text.ParseException;
import java.util.GregorianCalendar;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class DodajClanaGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblBrojClanskeKarte;
	private JTextField txtBrojClanskeKarte;
	private JLabel lblIme;
	private JTextField txtIme;
	private JLabel lblPrezime;
	private JTextField txtPrezime;
	private JLabel lblGodiste;
	private JComboBox comboBox;
	private int tekucaGodina = new GregorianCalendar().get(GregorianCalendar.YEAR);
	private JLabel lblPol;
	private JComboBox comboBox_1;
	private JLabel lblBrojTelefona;
	private JFormattedTextField txtBrojTelefona;
	private JLabel lblAdresa;
	private JTextField txtAdresa;
	private JLabel lblTezina;
	private JTextField txtTezina;
	private JLabel lblVisina;
	private JTextField txtVisina;
	private JLabel lblSifra;
	private JPasswordField pwdSifra;
	private JButton btnDodaj;
	private JButton btnOdustani;

	

	/**
	 * Create the frame.
	 */
	public DodajClanaGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.zatvoriDodajClanaGUI();
			}
		});
		setResizable(false);
		setTitle("Dodaj \u010Dlana");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodajClanaGUI.class.getResource("/icons/icon.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 572, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(11, 2, 3, 3));
			panel.add(getLblBrojClanskeKarte());
			panel.add(getTxtBrojClanskeKarte());
			panel.add(getLblIme());
			panel.add(getTxtIme());
			panel.add(getLblPrezime());
			panel.add(getTxtPrezime());
			panel.add(getLblGodiste());
			panel.add(getComboBox());
			panel.add(getLblPol());
			panel.add(getComboBox_1());
			panel.add(getLblBrojTelefona());
			panel.add(getTxtBrojTelefona());
			panel.add(getLblAdresa());
			panel.add(getTxtAdresa());
			panel.add(getLblTezina());
			panel.add(getTxtTezina());
			panel.add(getLblVisina());
			panel.add(getTxtVisina());
			panel.add(getLblSifra());
			panel.add(getPwdSifra());
			panel.add(getBtnDodaj());
			panel.add(getBtnOdustani());
		}
		return panel;
	}
	private JLabel getLblBrojClanskeKarte() {
		if (lblBrojClanskeKarte == null) {
			lblBrojClanskeKarte = new JLabel("Broj \u010Dlanske karte");
		}
		return lblBrojClanskeKarte;
	}
	private JTextField getTxtBrojClanskeKarte() {
		if (txtBrojClanskeKarte == null) {
			txtBrojClanskeKarte = new JTextField();
			txtBrojClanskeKarte.setColumns(10);
		}
		return txtBrojClanskeKarte;
	}
	private JLabel getLblIme() {
		if (lblIme == null) {
			lblIme = new JLabel("Ime");
		}
		return lblIme;
	}
	private JTextField getTxtIme() {
		if (txtIme == null) {
			txtIme = new JTextField();
			txtIme.setColumns(10);
		}
		return txtIme;
	}
	private JLabel getLblPrezime() {
		if (lblPrezime == null) {
			lblPrezime = new JLabel("Prezime");
		}
		return lblPrezime;
	}
	private JTextField getTxtPrezime() {
		if (txtPrezime == null) {
			txtPrezime = new JTextField();
			txtPrezime.setColumns(10);
		}
		return txtPrezime;
	}
	private JLabel getLblGodiste() {
		if (lblGodiste == null) {
			lblGodiste = new JLabel("Godi\u0161te");
		}
		return lblGodiste;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			for (int i = tekucaGodina; i > tekucaGodina - 101; i--) {
				comboBox.addItem(i);
			}
		}
		return comboBox;
	}
	private JLabel getLblPol() {
		if (lblPol == null) {
			lblPol = new JLabel("Pol");
		}
		return lblPol;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.addItem("M");
			comboBox_1.addItem("Ž");
		}
		return comboBox_1;
	}
	private JLabel getLblBrojTelefona() {
		if (lblBrojTelefona == null) {
			lblBrojTelefona = new JLabel("Broj telefona");
		}
		return lblBrojTelefona;
	}
	private JFormattedTextField getTxtBrojTelefona() {
		if (txtBrojTelefona == null) {
			try {
				MaskFormatter formatter = new MaskFormatter("###/###-####");
				txtBrojTelefona = new JFormattedTextField(formatter);
			} catch (ParseException e) {
				txtBrojTelefona = new JFormattedTextField();
			}
			
		}
		return txtBrojTelefona;
	}
	private JLabel getLblAdresa() {
		if (lblAdresa == null) {
			lblAdresa = new JLabel("Adresa");
		}
		return lblAdresa;
	}
	private JTextField getTxtAdresa() {
		if (txtAdresa == null) {
			txtAdresa = new JTextField();
			txtAdresa.setColumns(10);
		}
		return txtAdresa;
	}
	private JLabel getLblTezina() {
		if (lblTezina == null) {
			lblTezina = new JLabel("Te\u017Eina");
		}
		return lblTezina;
	}
	private JTextField getTxtTezina() {
		if (txtTezina == null) {
			txtTezina = new JTextField();
			txtTezina.setColumns(10);
		}
		return txtTezina;
	}
	private JLabel getLblVisina() {
		if (lblVisina == null) {
			lblVisina = new JLabel("Visina");
		}
		return lblVisina;
	}
	private JTextField getTxtVisina() {
		if (txtVisina == null) {
			txtVisina = new JTextField();
			txtVisina.setColumns(10);
		}
		return txtVisina;
	}
	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("\u0160ifra");
		}
		return lblSifra;
	}
	private JPasswordField getPwdSifra() {
		if (pwdSifra == null) {
			pwdSifra = new JPasswordField();
		}
		return pwdSifra;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
		}
		return btnDodaj;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.zatvoriDodajClanaGUI();
				}
			});
		}
		return btnOdustani;
	}
}
