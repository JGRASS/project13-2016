package teretana.gui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import teretana.clan.Clan;
import teretana.clan.ListaClanova;
import teretana.clan.interfejs.ListaClanovaInterfejs;

/**
 * Klasa koja je posrednik izmedju GUI-a i domenskih klasa
 * 
 * @author Filip Furtula, Edis Sarda, Marko Stanimirovic
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

	/**
	 * Metoda postavlja istocni panel da bude vidljiv
	 */
	public static void prikaziEastPanel() {
		teretanaGui.getEastPanel().setVisible(true);
	}

	/**
	 * Metoda postavlja da istocni panel ne bude vidljiv
	 */
	public static void sakrijEastPanel() {
		teretanaGui.getEastPanel().setVisible(false);
	}

	/**
	 * U slucaju da korisnik ne unese ispravnu sifru, metoda poziva dijalog koji
	 * obavestava korisnika o tome
	 */
	public static void korisnikNijeUneoIspravnuSifru() {
		JOptionPane.showMessageDialog(teretanaGui.getContentPane(), "Niste uneli ispravnu sifru!", "Obavestenje",
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Metoda poziva dijaloski prozor uz pomoc kog administrator moze da se
	 * uloguje
	 */
	public static void ulogujSeKaoAdmin() {
		prikazIProveraSifre(-2, 'a');
	}

	public static boolean prikazIProveraSifre(int index, char c) {
		if (index == -1) {
			return false;
		}
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 3, 3, 3));
		JLabel labelSifra = new JLabel("Unesite sifru:");
		JLabel labelBrClanskeKarte = null;
		JTextField brClanKarte = null;
		if (c == 'k') {
			labelBrClanskeKarte = new JLabel("Unesite broj clanske karte:");
			brClanKarte = new JTextField();
			panel.add(labelBrClanskeKarte);
			panel.add(brClanKarte);
		}
		JPasswordField pass = new JPasswordField(10);

		pass.setFocusable(true);
		pass.grabFocus();

		panel.add(labelSifra);
		panel.add(pass);

		String[] options = new String[] { "Cancel", "OK" };
		boolean signal = false;
		while (!signal) {
			int option = JOptionPane.showOptionDialog(null, panel, "Verifikacija", JOptionPane.NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
			if (option == 1) // pressing OK button
			{
				if (index == -2 && pass.getText().equals("admin") && c == 'a') {
					signal = true;
					prikaziEastPanel();
					teretanaGui.getBtnAdministrator().setVisible(false);
					teretanaGui.getBtnOdjaviteSe().setVisible(true);
				} else if (index != -1 && pass.getText().equals(listaClanova.getClan(index).getSifra())
						&& brClanKarte.getText().equals(listaClanova.getClan(index).getBrojClanskeKarte())
						&& c == 'k') {
					return true;
				} else {
					if (c == 'k') {
						brClanKarte.setText("");
						labelBrClanskeKarte.setText("Pogresan broj clanske karte, pokusajte ponovo:");
					}
					pass.setText("");
					labelSifra.setText("Pogresna sifra, pokusajte ponovo:");
				}
			} else {
				signal = true;
			}
		}
		return false;
	}

	/**
	 * Metoda se poziva kada se administrator odjavi, Forma se vraca u
	 * korisnicki rezim rada
	 */
	public static void odjaviSe() {
		teretanaGui.getBtnAdministrator().setVisible(true);
		teretanaGui.getBtnOdjaviteSe().setVisible(false);
		sakrijEastPanel();
	}

	/**
	 * Metoda poziva dijalog koji pita korisnika da li zeli da ugasi aplikaciju,
	 * Ako on prihvati, aplikacija se gasi, u suprotnom se ne gasi
	 */
	public static void zatvoriAplikaciju() {
		int zatvori = JOptionPane.showConfirmDialog(teretanaGui.getContentPane(),
				"Da li ste sigurni da zelite da izadjete iz programa?", "Izlazak iz programa",
				JOptionPane.YES_NO_OPTION);
		if (zatvori == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	/**
	 * Metoda poziva JFileChooser dijalog tipa Open, u kom korisnik moze da
	 * izabere datoteku sa ekstenzijom .gym koju zeli da ucita u tabelu
	 * aplikacije
	 */
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

	/**
	 * Uz pomoc ove metode se puni tabela iz liste clanova
	 */
	private static void popuniTabelu() {
		DefaultTableModel dfm = (DefaultTableModel) teretanaGui.getTable().getModel();

		dfm.setRowCount(0);

		for (int i = 0; i < listaClanova.size(); i++) {
			Clan c = listaClanova.getClan(i);
			dfm.addRow(new Object[] { c.getBrojClanskeKarte(), c.getIme(), c.getPrezime(), c.getPol() });
		}
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		teretanaGui.getTable().getColumnModel().getColumn(0).setCellRenderer(tcr);
		teretanaGui.getTable().getColumnModel().getColumn(1).setCellRenderer(tcr);
		teretanaGui.getTable().getColumnModel().getColumn(2).setCellRenderer(tcr);
		teretanaGui.getTable().getColumnModel().getColumn(3).setCellRenderer(tcr);

	}

	/**
	 * Metoda poziva JFileChooser dijalog tipa Save, u kom korisnik moze da
	 * izabere mesto u memoriji gde zeli da cuva podatke o clanovima teretane
	 * koji se nalaze u tabeli
	 */
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

	/**
	 * Pozivanjem ove metode se na ekran prikazuje dijaloski prozor sa kratkim
	 * opisom autora aplikacije
	 */
	public static void prikaziAboutUs() {
		guiAboutUs = new GUIAboutUs(teretanaGui, true);
		guiAboutUs.setLocationRelativeTo(null);
		guiAboutUs.setVisible(true);
	}

	/**
	 * Pozivanjem ove metode se na ekran prikazuje prozor u kom se mogu dodati
	 * podaci o clanu teretane
	 */
	public static void prikaziDodajClanaGUI() {
		if (dodajClanaGui == null) {
			dodajClanaGui = new DodajClanaGUI();
			dodajClanaGui.setLocationRelativeTo(null);
			dodajClanaGui.setVisible(true);
		} else {
			dodajClanaGui.toFront();
		}
	}

	/**
	 * Pozivanjem ove metode se zatvara prozor za dodavanje clana
	 */
	public static void zatvoriDodajClanaGUI() {
		if (dodajClanaGui != null) {
			dodajClanaGui.dispose();
			dodajClanaGui = null;
		}

	}

	/**
	 * Pozivanjem ove metode se brise selektovani clan iz tabele i iz liste
	 * clanova. Ako nijedan red tabele nije selektovan, dijalogom se
	 * administrator obavestava o tome, takodje ako administrator selektuje
	 * clana kog zeli da obrise, pojavljuje se dijaloski prozor kojim on jos
	 * jednom potvrdjuje brisanje. Ako potvrdi biva obavesten o brisanju u
	 * dijalogu
	 * 
	 * @param red
	 *            - selektovani clan iz tabele
	 * @param id
	 *            - broj clanske karte (jedinstveni identifikator)
	 */
	public static void izbrisiRedIzTabele(int red, String id) {
		int izbor = JOptionPane.showConfirmDialog(teretanaGui.getContentPane(),
				"Da li ste sigurni da zelite da obrisete izabranog clana?", "Potvrdite brisanje",
				JOptionPane.YES_NO_OPTION);
		if (izbor == JOptionPane.YES_OPTION) {
			try {
				listaClanova.izbrisiClana(id);
				izbrisiClanaIzTabele(red);
				JOptionPane.showMessageDialog(teretanaGui.getContentPane(), "Izabrani clan je uspesno obrisan.",
						"Obavestenje", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(teretanaGui, e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Pomocna metoda metodi izbrisiRedIzTabele
	 * 
	 * @param red
	 *            - selektovani clan iz tabele
	 */
	private static void izbrisiClanaIzTabele(int red) {
		DefaultTableModel dtm = (DefaultTableModel) teretanaGui.getTable().getModel();
		dtm.removeRow(red);
	}

	/**
	 * Pozivanjem ove metode se otvara prozor u kom administrator moze da izmeni
	 * podatke clana iz tabele kog je selektovao
	 * 
	 * @param index
	 *            - selektovani red tabele
	 */
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

	/**
	 * Ova metoda puni polja podacima o clanu teretane koje administrator moze
	 * da promeni
	 * 
	 * @param index
	 *            - selektovani red tabele
	 */
	private static void popuniPolja(int index) {
		Clan c = listaClanova.getClan(index);
		izmeniClanaGui.getTxtBrojtelefona().setText(c.getBrojTelefona());
		izmeniClanaGui.getTxtAdresa().setText(c.getAdresa());
		izmeniClanaGui.getTxtTezina().setText(c.getTezina() + "");
		izmeniClanaGui.getTxtVisina().setText(c.getVisina() + "");
		izmeniClanaGui.getTxtSifra().setText(c.getSifra());
	}

	/**
	 * Ova metoda zatvara prozor za menjanje podataka o clanu teretane
	 */
	public static void zatvoriIzmeniClanaGUI() {
		if (izmeniClanaGui != null) {
			izmeniClanaGui.dispose();
			izmeniClanaGui = null;
		}
	}

	/**
	 * Ova metoda dodaje podatke o clanu teretane u tabelu i listu koje je
	 * administrator uneo
	 * 
	 * @param brojClanskeKarte
	 *            - broj clanske karte clana teretane
	 * @param ime
	 *            - ime clana teretane
	 * @param prezime
	 *            - prezime clana teretane
	 * @param godiste
	 *            - godiste clana teretane
	 * @param pol
	 *            - pol clana teretane
	 * @param brojTelefona
	 *            - broj telefona clana teretane
	 * @param adresa
	 *            - adresa clana teretane
	 * @param tezina
	 *            - tezina clana teretane
	 * @param visina
	 *            - visina clana teretane
	 * @param sifra
	 *            - sifra clana teretane
	 */
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

	/**
	 * Metoda dodaje clana teretane u tabelu
	 * 
	 * @param c
	 *            - clan teretane
	 */
	private static void dodajClanaUTabelu(Clan c) {
		DefaultTableModel dtm = (DefaultTableModel) teretanaGui.getTable().getModel();
		dtm.addRow(new Object[] { c.getBrojClanskeKarte(), c.getIme(), c.getPrezime(), c.getPol() });
	}

	/**
	 * Metoda menja podatke o selektovanom clanu u tabeli i listi clanova
	 * 
	 * @param index
	 *            - selektovani red u tabeli
	 * @param brojTelefona
	 *            - broj telefona clana teretane
	 * @param adresa
	 *            - adresa clana teretane
	 * @param tezina
	 *            - tezina clana teretane
	 * @param visina
	 *            - visina clana teretane
	 * @param sifra
	 *            - sifra clana teretane
	 */
	public static void izmeniClana(int index, String brojTelefona, String adresa, String tezina, String visina,
			String sifra) {
		try {
			listaClanova.izmeniClana(index, brojTelefona, adresa, Double.parseDouble(tezina),
					Double.parseDouble(visina), sifra);
			zatvoriIzmeniClanaGUI();
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

	public static void pogledajPodatkeClana(int index) {
		if (prikazIProveraSifre(index, 'k')) {
			if (dodajClanaGui == null) {
				dodajClanaGui = new DodajClanaGUI();
				dodajClanaGui.setLocationRelativeTo(null);
				dodajClanaGui.setTitle("CLAN");
				blokirajIzmenuPolja();
				dodajClanaGui.getBtnDodaj().setText("OK");
				dodajClanaGui.getBtnDodaj().setEnabled(true);
				dodajClanaGui.getBtnOdustani().setVisible(false);
				popuniSvaPolja(index);
				dodajClanaGui.setVisible(true);
				dodajClanaGui.getBtnDodaj().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dodajClanaGui.dispose();
						dodajClanaGui = null;
					}
				});
			} else {
				dodajClanaGui.toFront();
			}
		}

	}

	private static void blokirajIzmenuPolja() {
		dodajClanaGui.getTxtBrojClanskeKarte().setEditable(false);
		dodajClanaGui.getTxtAdresa().setEditable(false);
		dodajClanaGui.getTxtBrojTelefona().setEditable(false);
		dodajClanaGui.getTxtIme().setEditable(false);
		dodajClanaGui.getTxtPrezime().setEditable(false);
		dodajClanaGui.getTxtTezina().setEditable(false);
		dodajClanaGui.getTxtVisina().setEditable(false);
		dodajClanaGui.getComboBox().setEnabled(false);
		dodajClanaGui.getComboBox_1().setEnabled(false);
		dodajClanaGui.getBtnOdustani().setEnabled(false);
		dodajClanaGui.getPwdSifra().setEditable(false);

	}

	private static void popuniSvaPolja(int index) {
		Clan c = listaClanova.getClan(index);
		dodajClanaGui.getTxtBrojClanskeKarte().setText(c.getBrojClanskeKarte());
		dodajClanaGui.getTxtBrojTelefona().setText(c.getBrojTelefona());
		dodajClanaGui.getTxtAdresa().setText(c.getAdresa());
		dodajClanaGui.getTxtTezina().setText(c.getTezina() + "");
		dodajClanaGui.getTxtVisina().setText(c.getVisina() + "");
		dodajClanaGui.getPwdSifra().setText(c.getSifra());
		dodajClanaGui.getTxtIme().setText(c.getIme());
		dodajClanaGui.getTxtPrezime().setText(c.getPrezime() + "");
		dodajClanaGui.getComboBox().setSelectedItem(c.getGodiste());
		dodajClanaGui.getComboBox_1().setSelectedItem(c.getPol());
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
