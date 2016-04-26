package teretana.gui;

import java.awt.EventQueue;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import teretana.clan.Clan;
import teretana.clan.ListaClanova;
import teretana.clan.interfejs.ListaClanovaInterfejs;

/**
 * Klasa koja je posrednik izmedju GUI-a i domenskih klasa
 * 
 * @author Filip Furtula, Edis Šarda, Marko Stanimirović
 *
 */
public class GUIKontroler {

	/**
	 * Glavni prozor
	 */
	private static TeretanaGUI teretanaGui;
	/**
	 * Prozor koji prikazuje podatke o autorima
	 */
	private static GUIAboutUs guiAboutUs;
	/**
	 * Lista clanova
	 */
	private static ListaClanovaInterfejs listaClanova;
	/**
	 * Prozor koji sluzi za dodavanje novog clana
	 */
	private static DodajClanaGUI dodajClanaGui;
	/**
	 * Prozor koji sluzi za izmenu podataka clana
	 */
	private static IzmeniClanaGUI izmeniClanaGui;

	public static void prikaziEastPanel() {
		teretanaGui.getEastPanel().setVisible(true);
	}

	public static void sakrijEastPanel() {
		teretanaGui.getEastPanel().setVisible(false);
	}

	public static void korisnikNijeUneoIspravnuSifru() {
		JOptionPane.showMessageDialog(teretanaGui.getContentPane(), "Niste uneli ispravnu sifru!", "Obavestenje",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void ulogujSeKaoAdmin() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Unesite sifru:");
		JPasswordField pass = new JPasswordField(10);
		pass.setFocusable(true);
		pass.grabFocus();

		panel.add(label);
		panel.add(pass);
		String[] options = new String[] { "Cancel", "OK" };
		boolean signal = false;
		while (!signal) {
			int option = JOptionPane.showOptionDialog(null, panel, "Verifikacija", JOptionPane.NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
			if (option == 1) // pressing OK button
			{
				String password = pass.getText();
				if (password.equals("admin")) {
					signal = true;
					prikaziEastPanel();
					teretanaGui.getBtnAdministrator().setVisible(false);
					teretanaGui.getBtnOdjaviteSe().setVisible(true);
				} else {
					pass.setText("");
					label.setText("Pogresna sifra, pokusajte ponovo:");
				}
			} else {
				signal = true;
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
				"Da li ste sigurni da zelite da izadjete iz programa?", "Izlazak iz programa",
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

			String fileName = f.getAbsolutePath();

			try {
				ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));

				final LinkedList<Clan> clanovi = (LinkedList<Clan>) in.readObject();

				listaClanova.dodajClanove(clanovi);
				popuniTabelu();

				in.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(teretanaGui.getContentPane(), "Greska pri ucitavanju clanova!", "Greska",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	private static void popuniTabelu() {
		DefaultTableModel dfm = (DefaultTableModel) teretanaGui.getTable().getModel();

		dfm.setRowCount(0);

		for (int i = 0; i < listaClanova.size(); i++) {
			Clan c = listaClanova.getClan(i);
			dfm.addRow(new Object[] { c.getBrojClanskeKarte(), c.getIme(), c.getPrezime(), c.getPol() });
		}
	}

	public static void sacuvajUFajl() {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Gym files", "gym");
		fc.setFileFilter(filter);
		int izbor = fc.showSaveDialog(teretanaGui.getContentPane());

		if (izbor == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();

			String imeFajla;

			if (!f.exists()) {
				imeFajla = f.getAbsolutePath() + ".gym";
			} else {
				imeFajla = f.getAbsolutePath();
			}

			try {
				ObjectOutputStream out = new ObjectOutputStream(
						new BufferedOutputStream(new FileOutputStream(imeFajla)));

				ListaClanova l = (ListaClanova) listaClanova;

				out.writeObject((LinkedList<Clan>) l.getListaClanova());

				JOptionPane.showMessageDialog(teretanaGui.getContentPane(), "Clanovi su uspesno sacuvani u datoteci.",
						"Obavestenje", JOptionPane.INFORMATION_MESSAGE);

				out.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(teretanaGui.getContentPane(), "Greska prilikom cuvanja clanova.",
						"Obavestenje", JOptionPane.ERROR_MESSAGE);
			}

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
		int izbor = JOptionPane.showConfirmDialog(teretanaGui.getContentPane(),
				"Da li ste sigurni da zelite da obrisete izabranog clana?", "Potrvrdite brisanje",
				JOptionPane.YES_NO_OPTION);
		if (izbor == JOptionPane.YES_OPTION) {
			try {
				listaClanova.izbrisiClana(id);
				izbrisiClanaIzTabele(red);
				JOptionPane.showMessageDialog(teretanaGui.getContentPane(), "Izabrani clan je uspesno obrisan.",
						"Obavestenje", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(teretanaGui, e.getMessage(), "Gre�ka", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private static void izbrisiClanaIzTabele(int red) {
		DefaultTableModel dtm = (DefaultTableModel) teretanaGui.getTable().getModel();
		dtm.removeRow(red);
	}

	public static void otvoriIzmeniClanaGUI(int index) {
		if (izmeniClanaGui == null) {
			izmeniClanaGui = new IzmeniClanaGUI(index);
			izmeniClanaGui.setLocationRelativeTo(null);
			popuniPolja(index);
			izmeniClanaGui.setVisible(true);
		} else {
			izmeniClanaGui.toFront();
		}
	}

	private static void popuniPolja(int index) {
		Clan c = listaClanova.getClan(index);
		izmeniClanaGui.getTxtBrojtelefona().setText(c.getBrojTelefona());
		izmeniClanaGui.getTxtAdresa().setText(c.getAdresa());
		izmeniClanaGui.getTxtTezina().setText(c.getTezina() + "");
		izmeniClanaGui.getTxtVisina().setText(c.getVisina() + "");
		izmeniClanaGui.getTxtSifra().setText(c.getSifra());
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
			JOptionPane.showMessageDialog(teretanaGui.getContentPane(), "Clan je uspesno dodat.", "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
		}
	}

	public static void dodajClanaUTabelu(Clan c) {
		DefaultTableModel dtm = (DefaultTableModel) teretanaGui.getTable().getModel();
		dtm.addRow(new Object[] { c.getBrojClanskeKarte(), c.getIme(), c.getPrezime(), c.getPol() });
	}

	public static void izmeniClana(int index, String brojTelefona, String adresa, String tezina, String visina,
			String sifra) {
		try {
			listaClanova.izmeniClana(index, brojTelefona, adresa, Double.parseDouble(tezina),
					Double.parseDouble(visina), sifra);
			zatvroiImeniClanaGUI();
			JOptionPane.showMessageDialog(teretanaGui.getContentPane(), "Clan je uspesno izmenjen.", "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
