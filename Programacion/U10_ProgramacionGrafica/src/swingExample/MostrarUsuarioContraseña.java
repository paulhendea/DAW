package swingExample;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarUsuarioContraseña extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField textPasswd;
	private JTextField textDNI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarUsuarioContraseña frame = new MostrarUsuarioContraseña();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MostrarUsuarioContraseña() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 5;
		gbc_textArea.gridheight = 2;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 7;
		panel.add(textArea, gbc_textArea);
		
		JLabel lblUser = new JLabel("Usuario: ");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.anchor = GridBagConstraints.EAST;
		gbc_lblUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser.gridx = 3;
		gbc_lblUser.gridy = 1;
		panel.add(lblUser, gbc_lblUser);
		
		textUser = new JTextField();
		GridBagConstraints gbc_textUser = new GridBagConstraints();
		gbc_textUser.insets = new Insets(0, 0, 5, 0);
		gbc_textUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUser.gridx = 4;
		gbc_textUser.gridy = 1;
		panel.add(textUser, gbc_textUser);
		textUser.setColumns(10);
		
		JLabel lblPasswd = new JLabel("Contrase\u00F1a: ");
		lblPasswd.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblPasswd = new GridBagConstraints();
		gbc_lblPasswd.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswd.anchor = GridBagConstraints.EAST;
		gbc_lblPasswd.gridx = 3;
		gbc_lblPasswd.gridy = 2;
		panel.add(lblPasswd, gbc_lblPasswd);
		
		textPasswd = new JPasswordField();
		GridBagConstraints gbc_textPasswd = new GridBagConstraints();
		gbc_textPasswd.insets = new Insets(0, 0, 5, 0);
		gbc_textPasswd.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPasswd.gridx = 4;
		gbc_textPasswd.gridy = 2;
		panel.add(textPasswd, gbc_textPasswd);
		
		JLabel lblDNI = new JLabel("DNI: ");
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.gridx = 3;
		gbc_lblDNI.gridy = 3;
		panel.add(lblDNI, gbc_lblDNI);
		
		textDNI = new JTextField();
		GridBagConstraints gbc_textDNI = new GridBagConstraints();
		gbc_textDNI.insets = new Insets(0, 0, 5, 0);
		gbc_textDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDNI.gridx = 4;
		gbc_textDNI.gridy = 3;
		panel.add(textDNI, gbc_textDNI);
		textDNI.setColumns(10);
		
		JButton btnNewButton = new JButton("Mostrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("Usuario: " + textUser.getText() + "\n");
				textArea.append("DNI: "  + textDNI.getText() + "\n");
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 5;
		panel.add(btnNewButton, gbc_btnNewButton);
		
	}

}
