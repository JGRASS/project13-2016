package teretana.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzmeniClanaGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblBrojTelefona;
	private JFormattedTextField txtBrojtelefona;
	private JLabel lblNewLabel;
	private JTextField txtAdresa;
	private JLabel lblVisina;
	private JTextField txtVisina;
	private JLabel lblTezina;
	private JTextField txtTezina;
	private JLabel lblSifra;
	private JTextField txtSifra;
	private JButton btnIzmeni;
	private JButton btnOdustani;
	private int index;

	/**
	 * Create the frame.
	 */
	public IzmeniClanaGUI(int index) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.zatvroiImeniClanaGUI();
			}
		});
		this.index = index;
		setResizable(false);
		setTitle("Izmeni clana");
		setIconImage(Toolkit.getDefaultToolkit().getImage(IzmeniClanaGUI.class.getResource("/icons/icon.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 401, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 2, 3, 3));
		contentPane.add(getLblBrojTelefona());
		contentPane.add(getTxtBrojtelefona());
		contentPane.add(getLblNewLabel());
		contentPane.add(getTxtAdresa());
		contentPane.add(getLblVisina());
		contentPane.add(getTxtVisina());
		contentPane.add(getLblTezina());
		contentPane.add(getTxtTezina());
		contentPane.add(getLblSifra());
		contentPane.add(getTxtSifra());
		contentPane.add(getBtnIzmeni());
		contentPane.add(getBtnOdustani());
	}

	private JLabel getLblBrojTelefona() {
		if (lblBrojTelefona == null) {
			lblBrojTelefona = new JLabel("Broj telefona");
		}
		return lblBrojTelefona;
	}
	public JFormattedTextField getTxtBrojtelefona() {
		if (txtBrojtelefona == null) {
			txtBrojtelefona = new JFormattedTextField();
		}
		return txtBrojtelefona;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Adresa");
		}
		return lblNewLabel;
	}
	public JTextField getTxtAdresa() {
		if (txtAdresa == null) {
			txtAdresa = new JTextField();
			txtAdresa.setColumns(10);
		}
		return txtAdresa;
	}
	private JLabel getLblVisina() {
		if (lblVisina == null) {
			lblVisina = new JLabel("Visina");
		}
		return lblVisina;
	}
	public JTextField getTxtVisina() {
		if (txtVisina == null) {
			txtVisina = new JTextField();
			txtVisina.setColumns(10);
		}
		return txtVisina;
	}
	private JLabel getLblTezina() {
		if (lblTezina == null) {
			lblTezina = new JLabel("Tezina");
		}
		return lblTezina;
	}
	public JTextField getTxtTezina() {
		if (txtTezina == null) {
			txtTezina = new JTextField();
			txtTezina.setColumns(10);
		}
		return txtTezina;
	}
	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra");
		}
		return lblSifra;
	}
	public JTextField getTxtSifra() {
		if (txtSifra == null) {
			txtSifra = new JTextField();
			txtSifra.setColumns(10);
		}
		return txtSifra;
	}
	private JButton getBtnIzmeni() {
		if (btnIzmeni == null) {
			btnIzmeni = new JButton("Izmeni");
			btnIzmeni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.izmeniClana(index, txtBrojtelefona.getText(),txtAdresa.getText(),txtTezina.getText(), txtVisina.getText(), txtSifra.getText());
				}
			});
		}
		return btnIzmeni;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.zatvroiImeniClanaGUI();
				}
			});
		}
		return btnOdustani;
	}
}
