package teretana.gui;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUIKontroler {

	private static TeretanaGUI teretanaGui;
	private static GUIAboutUs guiAboutUs;

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
				JOptionPane.showMessageDialog(teretanaGui.getContentPane(), "Prijavljeni ste kao administrator!",
						"Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
