package teretana.gui;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import teretana.clan.Clan;
import teretana.clan.ListaClanova;

public class GUIKontroler {

	private static TeretanaGUI teretanaGui;
	private static GUIAboutUs guiAboutUs;
	private static ListaClanova listaClanova;
	private static DodajClanaGUI dodajClanaGui;
	private static IzmeniClanaGUI izmeniClanaGui;

	public static void prikaziEastPanel() {
		teretanaGui.getEastPanel().setVisible(true);
	}

	public static void sakrijEastPanel() {
		teretanaGui.getEastPanel().setVisible(false);
	}

	public static void korisnikNijeUneoIspravnuSifru() {
		JOptionPane.showMessageDialog(teretanaGui.getContentPane(), "Niste uneli ispravnu šifru!", "Obaveštenje",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void ulogujSeKaoAdmin() {
		String sifra = JOptionPane.showInputDialog(teretanaGui.getContentPane(), "Šifra:", "Unesite šifru:",
				JOptionPane.OK_CANCEL_OPTION);

		if (sifra != null) {
			if (sifra.equals("admin")) {
				prikaziEastPanel();
				teretanaGui.getBtnAdministrator().setVisible(false);
				teretanaGui.getBtnOdjaviteSe().setVisible(true);
			} else {
				korisnikNijeUneoIspravnuSifru();

			}
		}
	}

	public static void odjaviSe() {
		teretanaGui.getBtnAdministrator().setVisible(true);
		teretanaGui.getBtnOdjaviteSe().setVisible(false);
		sakrijEastPanel();
	}

	public static void zatvoriAplikaciju() {
		int zatvori = JOptionPane.showConfirmDialog(teretanaGui.getContentPane(),
				"Da li ste sigurni da želite da izaðete iz programa?", "Izlazak iz programa",
				JOptionPane.YES_NO_OPTION);
		if (zatvori == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void otvoriFajl() {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Gym files", "gym");

		fc.setFileFilter(filter);

		int izbor = fc.showOpenDialog(teretanaGui.getContentPane());

		if (izbor == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();

			String fileName = f.getName();
			// TODO: implementirati dalje...
		}
	}

	public static void sacuvajUFajl() {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Gym files", "gym");
		fc.setFileFilter(filter);
		int izbor = fc.showSaveDialog(teretanaGui.getContentPane());

		if (izbor == JFileChooser.APPROVE_OPTION) {
			// TODO: implementirati...
		}
	}

	public static void prikaziAboutUs() {
		guiAboutUs = new GUIAboutUs(teretanaGui, true);
		guiAboutUs.setLocationRelativeTo(null);
		guiAboutUs.setVisible(true);
	}

	public static void prikaziDodajClanaGUI() {
		if (dodajClanaGui == null) {
			dodajClanaGui = new DodajClanaGUI();
			dodajClanaGui.setLocationRelativeTo(null);
			dodajClanaGui.setVisible(true);
		} else {
			dodajClanaGui.toFront();
		}
	}

	public static void zatvoriDodajClanaGUI() {
		if (dodajClanaGui != null) {
			dodajClanaGui.dispose();
			dodajClanaGui = null;
		}

	}

	public static void izbrisiRedIzTabele(int red, String id) {
		try {
			listaClanova.izbrisiClana(id);
			izbrisiClanaIzTabele(red);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(teretanaGui, e.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
		}
	}

	private static void izbrisiClanaIzTabele(int red) {
		DefaultTableModel dtm = (DefaultTableModel) teretanaGui.getTable().getModel();
		dtm.removeRow(red);
	}

	public static void otvoriIzmeniClanaGUI() {
		if (izmeniClanaGui == null) {
			izmeniClanaGui = new IzmeniClanaGUI();
			izmeniClanaGui.setLocationRelativeTo(null);
			izmeniClanaGui.setVisible(true);
		} else {
			izmeniClanaGui.toFront();
		}
	}

	public static void zatvroiImeniClanaGUI() {
		if (izmeniClanaGui != null) {
			izmeniClanaGui.dispose();
			izmeniClanaGui = null;
		}
	}

	public static void dodajClana(String brojClanskeKarte, String ime, String prezime, String godiste, String pol,
			String brojTelefona, String adresa, String tezina, String visina, String sifra) {
		Clan c = new Clan();
		c.setBrojClanskeKarte(brojClanskeKarte);
		c.setIme(ime);
		c.setPrezime(prezime);
		c.setGodiste(Integer.parseInt(godiste));
		c.setPol(pol.charAt(0));
		c.setBrojTelefona(brojTelefona);
		c.setAdresa(adresa);
		c.setTezina(Double.parseDouble(tezina));
		c.setVisina(Double.parseDouble(visina));
		c.setSifra(sifra);

		try {
			listaClanova.dodajClana(c);
			zatvoriDodajClanaGUI();
			dodajClanaUTabelu(c);
			JOptionPane.showMessageDialog(teretanaGui.getContentPane(), "Èlan je uspješno dodat.", "Obaveštenje",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
		}
	}

	public static void dodajClanaUTabelu(Clan c) {
		DefaultTableModel dtm = (DefaultTableModel) teretanaGui.getTable().getModel();
		dtm.addRow(new Object[] { c.getBrojClanskeKarte(), c.getIme(), c.getPrezime(), c.getPol() });

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listaClanova = new ListaClanova();
					teretanaGui = new TeretanaGUI();
					teretanaGui.setLocationRelativeTo(null);
					teretanaGui.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
