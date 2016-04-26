package teretana.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

/**
 * Prozor koji prikazuje informacije o autorima programa
 * 
 * @author Filip Furtula, Edis Šarda, Marko Stanimirović
 *
 */
public class GUIAboutUs extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel label;
	private JTextArea txtrOvaAplikacijaJe;

	/**
	 * Create the dialog.
	 */

	public GUIAboutUs(Frame parent, boolean modal) {
		super(parent, modal);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIAboutUs.class.getResource("/icons/icon.png")));
		setTitle("About us");
		setBounds(100, 100, 535, 494);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			panel.add(getLabel());
			panel.add(getTxtrOvaAplikacijaJe());
		}
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setIcon(new ImageIcon(GUIAboutUs.class.getResource("/pictures/JSLogo.png")));
			label.setBounds(12, 13, 483, 177);
		}
		return label;
	}

	private JTextArea getTxtrOvaAplikacijaJe() {
		if (txtrOvaAplikacijaJe == null) {
			txtrOvaAplikacijaJe = new JTextArea();
			txtrOvaAplikacijaJe.setBackground(SystemColor.control);
			txtrOvaAplikacijaJe.setFont(new Font("Calibri", Font.PLAIN, 26));
			txtrOvaAplikacijaJe.setLineWrap(true);
			txtrOvaAplikacijaJe.setWrapStyleWord(true);
			txtrOvaAplikacijaJe.setText(
					"Ova aplikacija je delo studenata druge godine Fakulteta Organizacionih Nauka, Edisa \u0160arde, Filipa Furtule i Marka Stanimirovi\u0107a. Napravljena je u okviru  Naprednog Java kursa.");
			txtrOvaAplikacijaJe.setEditable(false);
			txtrOvaAplikacijaJe.setBounds(38, 222, 430, 189);
		}
		return txtrOvaAplikacijaJe;
	}
}
