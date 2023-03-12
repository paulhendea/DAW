package ej1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej1 frame = new Ej1();
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
	public Ej1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNum = new JLabel("Introduce un n\u00FAmero entero");
		lblNum.setBounds(128, 39, 166, 14);
		panel.add(lblNum);
		
		textNum = new JTextField();
		textNum.setBounds(154, 64, 86, 20);
		panel.add(textNum);
		textNum.setColumns(10);
		
		JLabel lblRes = new JLabel("");
		lblRes.setBounds(174, 129, 46, 14);
		panel.add(lblRes);
		
		JButton btnParImpar = new JButton("\u00BFPar o impar?");
		btnParImpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int num = Integer.parseInt(textNum.getText());
					if(num % 2 == 0) lblRes.setText("PAR");
					else lblRes.setText("IMPAR");
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(btnParImpar, "Debes introducir un n�mero entero", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnParImpar.setBounds(138, 94, 119, 23);
		panel.add(btnParImpar);
	}		
}
