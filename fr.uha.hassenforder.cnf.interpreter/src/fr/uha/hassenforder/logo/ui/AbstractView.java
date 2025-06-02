package fr.uha.hassenforder.logo.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public abstract class AbstractView extends javax.swing.JFrame {
	/**
	 * 
	 */
	private AbstractDocument document;
	private static final long serialVersionUID = 1L;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenuItem jMenuItem = null;
	private JMenuItem jMenuItem1 = null;
	private JMenuItem jMenuItem2 = null;
	private JMenuItem jMenuItem3 = null;
	private JMenuItem jMenuItem4 = null;
	private JMenu jMenu1 = null;
	private JMenuItem jMenuItem5 = null;
	private JMenuItem jMenuItem6 = null;
	private JMenuItem jMenuItem7 = null;
	private JMenuItem jMenuItem8 = null;
	private JMenu jMenu2 = null;
	private JMenuItem jMenuItem9 = null;
	private JMenu jMenu3 = null;
	private JCheckBoxMenuItem jCheckBoxMenuItem = null;
	private JCheckBoxMenuItem jCheckBoxMenuItem1 = null;
	private JPanel jPanel = null;
	private javax.swing.JFileChooser jFileChooser = null;  //  @jve:decl-index=0:visual-constraint="11,367"

	public AbstractView(AbstractDocument document) {
		super();
		this.document = document;
		initialize();
		getDocument().onNewDocument();
	}

	/**
	 * Initialize the class.
	 */
	private void initialize() {

		this.setName("JFrame1");
		this.setBackground(new Color(0xF7, 0xF7, 0xF7));
		this.setContentPane(getJPanel());
		this.setJMenuBar(getJJMenuBar());
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Tiny Turtle");
		this.pack();
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu());
			jJMenuBar.add(getJMenu1());
			jJMenuBar.add(getJMenu3());
			jJMenuBar.add(getJMenu2());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setText("Fichier");
			jMenu.setMnemonic(KeyEvent.VK_UNDEFINED);
			jMenu.add(getJMenuItem());
			jMenu.add(getJMenuItem1());
			jMenu.add(getJMenuItem2());
			jMenu.add(getJMenuItem3());
			jMenu.addSeparator();
			jMenu.add(getJMenuItem4());
		}
		return jMenu;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
			jMenuItem.setText("Nouveau");
			jMenuItem.setMnemonic(KeyEvent.VK_N);
			jMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getDocument().onNewDocument ();
				}
			});
		}
		return jMenuItem;
	}

	/**
	 * This method initializes jMenuItem1	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("Ouvrir");
			jMenuItem1.setMnemonic(KeyEvent.VK_O);
			jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getDocument().onOpenDocument ();
				}
			});
		}
		return jMenuItem1;
	}

	/**
	 * This method initializes jMenuItem2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem2() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setText("Enregistrer");
			jMenuItem2.setMnemonic(KeyEvent.VK_S);
			jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getDocument().onSaveDocument ();
				}
			});
		}
		return jMenuItem2;
	}

	/**
	 * This method initializes jMenuItem3	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem3() {
		if (jMenuItem3 == null) {
			jMenuItem3 = new JMenuItem();
			jMenuItem3.setText("Enregistrer sous ...");
		}
		return jMenuItem3;
	}

	/**
	 * This method initializes jMenuItem4	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem4() {
		if (jMenuItem4 == null) {
			jMenuItem4 = new JMenuItem();
			jMenuItem4.setText("Quitter");
			jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					AbstractView.this.setVisible(false);
				}
			});
		}
		return jMenuItem4;
	}

	/**
	 * This method initializes jMenu1	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu1() {
		if (jMenu1 == null) {
			jMenu1 = new JMenu();
			jMenu1.setText("Edition");
			jMenu1.add(getJMenuItem5());
			jMenu1.addSeparator();
			jMenu1.add(getJMenuItem6());
			jMenu1.add(getJMenuItem7());
			jMenu1.add(getJMenuItem8());
		}
		return jMenu1;
	}

	/**
	 * This method initializes jMenuItem5	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem5() {
		if (jMenuItem5 == null) {
			jMenuItem5 = new JMenuItem();
			jMenuItem5.setText("Annuler");
			jMenuItem5.setMnemonic(KeyEvent.VK_Z);
		}
		return jMenuItem5;
	}

	/**
	 * This method initializes jMenuItem6	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem6() {
		if (jMenuItem6 == null) {
			jMenuItem6 = new JMenuItem();
			jMenuItem6.setText("Couper");
			jMenuItem6.setMnemonic(KeyEvent.VK_X);
		}
		return jMenuItem6;
	}

	/**
	 * This method initializes jMenuItem7	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem7() {
		if (jMenuItem7 == null) {
			jMenuItem7 = new JMenuItem();
			jMenuItem7.setText("Copier");
			jMenuItem7.setMnemonic(KeyEvent.VK_C);
		}
		return jMenuItem7;
	}

	/**
	 * This method initializes jMenuItem8	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem8() {
		if (jMenuItem8 == null) {
			jMenuItem8 = new JMenuItem();
			jMenuItem8.setText("Coller");
			jMenuItem8.setMnemonic(KeyEvent.VK_V);
		}
		return jMenuItem8;
	}

	/**
	 * This method initializes jMenu2	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu2() {
		if (jMenu2 == null) {
			jMenu2 = new JMenu();
			jMenu2.setText("Aide");
			jMenu2.add(getJMenuItem9());
		}
		return jMenu2;
	}

	/**
	 * This method initializes jMenuItem9	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem9() {
		if (jMenuItem9 == null) {
			jMenuItem9 = new JMenuItem();
			jMenuItem9.setText("A propos de TinyTurtle ...");
		}
		return jMenuItem9;
	}

	/**
	 * This method initializes jMenu3	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu3() {
		if (jMenu3 == null) {
			jMenu3 = new JMenu();
			jMenu3.setText("Affichage");
			jMenu3.add(getJCheckBoxMenuItem());
			jMenu3.add(getJCheckBoxMenuItem1());
		}
		return jMenu3;
	}

	/**
	 * This method initializes jCheckBoxMenuItem	
	 * 	
	 * @return javax.swing.JCheckBoxMenuItem	
	 */
	private JCheckBoxMenuItem getJCheckBoxMenuItem() {
		if (jCheckBoxMenuItem == null) {
			jCheckBoxMenuItem = new JCheckBoxMenuItem();
			jCheckBoxMenuItem.setText("barre d'outils");
			jCheckBoxMenuItem.setSelected(true);
		}
		return jCheckBoxMenuItem;
	}

	/**
	 * This method initializes jCheckBoxMenuItem1	
	 * 	
	 * @return javax.swing.JCheckBoxMenuItem	
	 */
	private JCheckBoxMenuItem getJCheckBoxMenuItem1() {
		if (jCheckBoxMenuItem1 == null) {
			jCheckBoxMenuItem1 = new JCheckBoxMenuItem();
			jCheckBoxMenuItem1.setText("barre d'état");
			jCheckBoxMenuItem1.setSelected(true);
			jCheckBoxMenuItem1.setMnemonic(KeyEvent.VK_UNDEFINED);
		}
		return jCheckBoxMenuItem1;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel() {
				private static final long serialVersionUID = 1L;
				public void paintComponent (Graphics g) {
					Color oldColor = g.getColor();
					g.setColor(Color.blue);
					g.drawRect(0, 0, 640, 480);
					g.fillOval(320, 240, 5, 5);
					g.setColor(oldColor);
					onPaint (g);
				}
			};
			jPanel.setLayout(new BorderLayout());
			jPanel.setPreferredSize(new Dimension(642, 482));
		}
		return jPanel;
	}

	/**
	 * This method initializes jFileChooser
	 * 
	 * @return javax.swing.JFileChooser
	 */
	public javax.swing.JFileChooser getJFileChooser() {
		if (jFileChooser == null) {
			jFileChooser = new javax.swing.JFileChooser();
			jFileChooser.setMultiSelectionEnabled(false);
		}
		return jFileChooser;
	}

	protected AbstractDocument getDocument() {
		return document;
	}

	protected abstract void onPaint (Graphics g);

}  //  @jve:decl-index=0:visual-constraint="10,10"
