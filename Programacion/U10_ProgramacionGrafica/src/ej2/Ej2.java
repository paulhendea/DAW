package ej2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNum1;
	private JTextField textNum2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej2 frame = new Ej2();
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
	public Ej2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNum1 = new JLabel("N\u00FAmero 1: ");
		lblNum1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNum1.setBounds(110, 23, 71, 14);
		panel.add(lblNum1);
		
		JLabel lblNum2 = new JLabel("N\u00FAmero 2: ");
		lblNum2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNum2.setBounds(110, 48, 71, 14);
		panel.add(lblNum2);
		
		textNum1 = new JTextField();
		textNum1.setBounds(185, 21, 86, 20);
		panel.add(textNum1);
		textNum1.setColumns(10);
		
		textNum2 = new JTextField();
		textNum2.setBounds(185, 45, 86, 20);
		panel.add(textNum2);
		textNum2.setColumns(10);

		JLabel lblRes = new JLabel("");
		lblRes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRes.setBounds(110, 149, 194, 14);
		panel.add(lblRes);
		
		JButton btnSuma = new JButton("+");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double num1 = Double.parseDouble(textNum1.getText());
					double num2 = Double.parseDouble(textNum2.getText());
					
					lblRes.setText(String.format("Suma: %.2f", num1+num2));
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(btnSuma, "Debes introducir n�meros reales", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSuma.setBounds(110, 98, 41, 23);
		panel.add(btnSuma);
		
		JButton btnResta = new JButton("-");
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double num1 = Double.parseDouble(textNum1.getText());
					double num2 = Double.parseDouble(textNum2.getText());
					
					lblRes.setText(String.format("Resta: %.2f", num1-num2));
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(btnResta, "Debes introducir n�meros reales", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnResta.setBounds(161, 98, 41, 23);
		panel.add(btnResta);
		
		JButton btnMult = new JButton("x");
		btnMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double num1 = Double.parseDouble(textNum1.getText());
					double num2 = Double.parseDouble(textNum2.getText());
					
					lblRes.setText(String.format("Multiplicaci�n: %.2f", num1*num2));
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(btnMult, "Debes introducir n�meros reales", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnMult.setBounds(212, 98, 41, 23);
		panel.add(btnMult);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double num1 = Double.parseDouble(textNum1.getText());
					double num2 = Double.parseDouble(textNum2.getText());
					
					lblRes.setText(String.format("Divisi�n: %.2f", num1/num2));
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(btnDiv, "Debes introducir n�meros reales", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDiv.setBounds(263, 98, 41, 23);
		panel.add(btnDiv);
	}

}
