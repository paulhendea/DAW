package ej4;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej4 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej4 frame = new Ej4();
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
	public Ej4() {
		setTitle("Validar letra NIF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblInstruccion = new JLabel("Introduce el NIF");
		lblInstruccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstruccion.setBounds(150, 11, 100, 14);
		panel.add(lblInstruccion);
		
		JLabel lblInstruccion2 = new JLabel("(8 num, 1 letra)");
		lblInstruccion2.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstruccion2.setBounds(150, 36, 100, 14);
		panel.add(lblInstruccion2);
		
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter("########-U");
			mask.setPlaceholderCharacter('_');
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		JFormattedTextField textNIF = new JFormattedTextField(mask);
		textNIF.setBounds(155, 60, 90, 20);
		panel.add(textNIF);

		JLabel lblRes = new JLabel("");
		lblRes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRes.setBounds(150, 125, 100, 14);
		panel.add(lblRes);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(validarNIF(textNIF.getText())) lblRes.setText("CORRECTO");
					else lblRes.setText("INCORRECTO");
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(btnValidar, "NIF incompleto", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnValidar.setBounds(155, 91, 90, 23);
		panel.add(btnValidar);
	}
	
	/**
	 * USEFUL METHOD
	 */
	private static boolean validarNIF(String NIF) {
		char letraNIF[] = new char[] {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		
		char letra = NIF.charAt(9);		
		int num = Integer.parseInt(NIF.substring(0,7));
		return letra == letraNIF[num % 23];
	}
}
