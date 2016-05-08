package teretana.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.InputEvent;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Glavni prozor aplikacije
 * 
 * @author Filip Furtula, Edis Sarda, Marko Stanimirovic
 *
 */
public class TeretanaGUI extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmAboutUs;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JSeparator separator;
	private JPanel eastPanel;
	private JPanel southPanel;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnAdministrator;
	private JButton btnDodaj;
	private JButton btnIzbrii;
	private JButton btnIzmeni;
	private JButton btnOdjaviteSe;
	private JLabel label;
	private JMenuItem mntmNew;

	/**
	 * Create the frame.
	 */
	public TeretanaGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.zatvoriAplikaciju();
			}
		});
		setTitle("Teretana");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TeretanaGUI.class.getResource("/icons/icon.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 768, 640);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getEastPanel(), BorderLayout.EAST);
		contentPane.add(getSouthPanel(), BorderLayout.SOUTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}

	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmNew());
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getSeparator());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAboutUs());
		}
		return mnHelp;
	}

	private JMenuItem getMntmAboutUs() {
		if (mntmAboutUs == null) {
			mntmAboutUs = new JMenuItem("About us");
			mntmAboutUs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziAboutUs();
				}
			});
			mntmAboutUs.setIcon(new ImageIcon(TeretanaGUI.class.getResource("/icons/iconAboutUs.png")));
		}
		return mntmAboutUs;
	}

	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.otvoriFajl();
				}
			});
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
			mntmOpen.setIcon(
					new ImageIcon(TeretanaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		}
		return mntmOpen;
	}

	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.sacuvajUFajl();
				}
			});
			mntmSave.setIcon(
					new ImageIcon(TeretanaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		}
		return mntmSave;
	}

	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.zatvoriAplikaciju();
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
			mntmExit.setIcon(new ImageIcon(TeretanaGUI.class.getResource("/icons/iconExit.png")));
		}
		return mntmExit;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}

	public JPanel getEastPanel() {
		if (eastPanel == null) {
			eastPanel = new JPanel();
			eastPanel.setVisible(false);
			eastPanel.setPreferredSize(new Dimension(180, 10));
			eastPanel.add(getLabel());
			eastPanel.add(getBtnDodaj());
			eastPanel.add(getBtnIzbrii());
			eastPanel.add(getBtnIzmeni());
		}
		return eastPanel;
	}

	private JPanel getSouthPanel() {
		if (southPanel == null) {
			southPanel = new JPanel();
			southPanel.setPreferredSize(new Dimension(10, 50));
			southPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			southPanel.add(getBtnAdministrator());
			southPanel.add(getBtnOdjaviteSe());
		}
		return southPanel;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(btnAdministrator.isVisible()){
						GUIKontroler.pogledajPodatkeClana(table.getSelectedRow());
					}
				}
			});
			table.setFillsViewportHeight(true);
			table.setModel(new DefaultTableModel(new Object[] { "Broj clanske karte", "Ime", "Prezime", "Pol" }, 0) {

				public boolean isCellEditable(int row, int column) {
					return false;
				}
			});
			table.getTableHeader().setReorderingAllowed(false);

		}
		return table;
	}

	public JButton getBtnAdministrator() {
		if (btnAdministrator == null) {
			btnAdministrator = new JButton("Administrator");
			btnAdministrator.setFocusTraversalKeysEnabled(false);
			btnAdministrator.setFocusTraversalPolicyProvider(true);
			btnAdministrator.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.ulogujSeKaoAdmin();
				}
			});
			btnAdministrator.setPreferredSize(new Dimension(140, 40));
		}
		return btnAdministrator;
	}

	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziDodajClanaGUI();
				}
			});
			btnDodaj.setPreferredSize(new Dimension(130, 40));
		}
		return btnDodaj;
	}

	private JButton getBtnIzbrii() {
		if (btnIzbrii == null) {
			btnIzbrii = new JButton("Izbrisi");
			btnIzbrii.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int red = getTable().getSelectedRow();

					if (red >= 0) {
						GUIKontroler.izbrisiRedIzTabele(red, (String) getTable().getValueAt(red, 0));
					} else {
						JOptionPane.showMessageDialog(getTable(), "Niste selektovali clana!", "Greska",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnIzbrii.setPreferredSize(new Dimension(130, 40));
		}
		return btnIzbrii;
	}

	private JButton getBtnIzmeni() {
		if (btnIzmeni == null) {
			btnIzmeni = new JButton("Izmeni");
			btnIzmeni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int red = getTable().getSelectedRow();

					if (red >= 0) {
						GUIKontroler.otvoriIzmeniClanaGUI(red);
					} else {

						JOptionPane.showMessageDialog(getTable(), "Niste selektovali clana!", "Greska",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnIzmeni.setPreferredSize(new Dimension(130, 40));
		}
		return btnIzmeni;
	}

	public JButton getBtnOdjaviteSe() {
		if (btnOdjaviteSe == null) {
			btnOdjaviteSe = new JButton("Odjavite se");
			btnOdjaviteSe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.odjaviSe();
				}
			});
			btnOdjaviteSe.setPreferredSize(new Dimension(140, 40));
			btnOdjaviteSe.setVisible(false);
		}
		return btnOdjaviteSe;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("           ");
			label.setPreferredSize(new Dimension(130, 16));
		}
		return label;
	}
	private JMenuItem getMntmNew() {
		if (mntmNew == null) {
			mntmNew = new JMenuItem("New");
			mntmNew.setIcon(new ImageIcon(TeretanaGUI.class.getResource("/icons/newFile.png")));
			mntmNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.pokreniAplikacijuPonovo();
				}
			});
			mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		}
		return mntmNew;
	}
}
