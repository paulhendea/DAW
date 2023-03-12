package ej3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej3 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textA;
	private JTextField textB;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej3 frame = new Ej3();
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
	public Ej3() {
		setTitle("Mini calculadora II");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNumA = new JLabel("A: ");
		lblNumA.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumA.setBounds(110, 39, 46, 14);
		panel.add(lblNumA);
		
		JLabel lblInstrucciones = new JLabel("Introduce 2 n\u00FAmeros enteros");
		lblInstrucciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstrucciones.setBounds(110, 14, 200, 14);
		panel.add(lblInstrucciones);
		
		textA = new JTextField();
		textA.setBounds(166, 36, 86, 20);
		panel.add(textA);
		textA.setColumns(10);
		
		JLabel lblNumB = new JLabel("B: ");
		lblNumB.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumB.setBounds(110, 64, 46, 14);
		panel.add(lblNumB);
		
		textB = new JTextField();
		textB.setBounds(166, 61, 86, 20);
		panel.add(textB);
		textB.setColumns(10);
		
		JLabel lblOperaciones = new JLabel("Elige una operaci\u00F3n");
		lblOperaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperaciones.setBounds(125, 109, 175, 14);
		panel.add(lblOperaciones);
		
		JRadioButton rdbtnSumatorio = new JRadioButton("Sumatorio (A+...+B)");
		buttonGroup.add(rdbtnSumatorio);
		rdbtnSumatorio.setBounds(143, 130, 140, 23);
		panel.add(rdbtnSumatorio);
		
		JRadioButton rdbtnProductorio = new JRadioButton("Productorio (A*...*B)");
		buttonGroup.add(rdbtnProductorio);
		rdbtnProductorio.setBounds(143, 156, 140, 23);
		panel.add(rdbtnProductorio);
		
		JRadioButton rdbtnExponencial = new JRadioButton("Exponencial (A^B)");
		buttonGroup.add(rdbtnExponencial);
		rdbtnExponencial.setBounds(143, 182, 140, 23);
		panel.add(rdbtnExponencial);

		JLabel lblRes = new JLabel("");
		lblRes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRes.setBounds(110, 262, 200, 14);
		panel.add(lblRes);
		
		JButton btnCalcula = new JButton("\u00A1Calcula!");
		btnCalcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a = Integer.parseInt(textA.getText());
					int b = Integer.parseInt(textB.getText());
					
					if(rdbtnSumatorio.isSelected()) lblRes.setText("Sumatorio: "+sumatorio(a, b));
					else if(rdbtnProductorio.isSelected()) lblRes.setText("Productorio: "+productorio(a, b));
					else if(rdbtnExponencial.isSelected()) lblRes.setText("Exponencial: "+exponencial(a, b));
					else lblRes.setText("");
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(btnCalcula, "Debes introducir n�meros enteros", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCalcula.setBounds(166, 229, 89, 23);
		panel.add(btnCalcula);
		
	}
	
	/** USEFUL METHODS */
	private static int sumatorio(int num1, int num2) {
		int a = Math.min(num1, num2);
		int b = Math.max(num1, num2);
		int total = 0;
		
		for(int i = a; i <= b; i++) {
			total += i;
		}
		return total;
	}
	private static int productorio(int num1, int num2) {
		int a = Math.min(num1, num2);
		int b = Math.max(num1, num2);
		int total = 1;
		
		for(int i = a; i <= b; i++) {
			total *= i;
		}
		return total;
	}
	private static int exponencial(int num1, int num2) {
		int a = Math.min(num1, num2);
		int b = Math.max(num1, num2);
		
		return (int) Math.pow(a, b);
	}
}
