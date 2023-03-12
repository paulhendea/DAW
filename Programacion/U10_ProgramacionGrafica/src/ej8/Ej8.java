package ej8;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej8 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblInstruccion;
	private JTextField textA;
	private JTextField textB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej8 frame = new Ej8();
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
	public Ej8() {
		setTitle("Tablas de multiplicar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		table = new JTable();
		table.setEnabled(false);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		Object[][] data = new Object[10][10];
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				data[i][j] = (i+1) * (j+1);
			}
		}
		String[] tableTitles = new String[] {
			"*1", "*2", "*3", "*4", "*5", "*6", "*7", "*8", "*9", "*10"
		};
		
		table.setModel(new DefaultTableModel(data, tableTitles));
		table.setBounds(35, 150, 350, 160);
		panel.add(table);
		
		lblInstruccion = new JLabel("Insert range on numbers");
		lblInstruccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstruccion.setBounds(125, 11, 175, 14);
		panel.add(lblInstruccion);
		
		textA = new JTextField();
		textA.setBounds(116, 67, 86, 20);
		panel.add(textA);
		textA.setColumns(10);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrom.setBounds(116, 42, 86, 14);
		panel.add(lblFrom);
		
		textB = new JTextField();
		textB.setColumns(10);
		textB.setBounds(230, 67, 86, 20);
		panel.add(textB);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setBounds(230, 42, 86, 14);
		panel.add(lblTo);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int num1 = Integer.parseInt(textA.getText());
					int num2 = Integer.parseInt(textB.getText());
					
					int a = Math.min(num1, num2);
					int b = Math.max(num1, num2);
					for(int i = a; i <= b; i++) {
						for(int j = 0; j < 10; j++) {
							data[i][j] = (i+1) * (j+1);
						}
					}
					table.setModel(new DefaultTableModel(data, tableTitles));
					table.repaint();
				}
				catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(btnCalculate, "Must insert integer numbers", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCalculate.setBounds(165, 105, 100, 23);
		panel.add(btnCalculate);
	}
}
