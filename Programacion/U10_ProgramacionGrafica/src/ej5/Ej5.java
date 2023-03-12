package ej5;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Hashtable;

import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Ej5 extends JFrame {

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
					Ej5 frame = new Ej5();
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
	public Ej5() {
		setTitle("N\u00FAmero aleatorio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblInstruccion = new JLabel("Elige el m\u00E1ximo");
		lblInstruccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInstruccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstruccion.setBounds(133, 11, 150, 25);
		panel.add(lblInstruccion);

		JLabel lblSelected = new JLabel("");
		lblSelected.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelected.setBounds(111, 108, 200, 14);
		panel.add(lblSelected);
		
		JSlider sliderMax = new JSlider();
		sliderMax.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblSelected.setText(String.format("N�mero seleccionado: %d", sliderMax.getValue()));
			}
		});
		sliderMax.setPaintLabels(true);
		
		//Create the label table
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put( 1, new JLabel("1"));
		labelTable.put( 10, new JLabel("10"));
		labelTable.put( 20, new JLabel("20"));
		labelTable.put( 30, new JLabel("30"));
		labelTable.put( 40, new JLabel("40"));
		labelTable.put( 50, new JLabel("50"));
		labelTable.put( 60, new JLabel("60"));
		labelTable.put( 70, new JLabel("70"));
		labelTable.put( 80, new JLabel("80"));
		labelTable.put( 90, new JLabel("90"));
		labelTable.put( 100, new JLabel("100"));
		sliderMax.setLabelTable(labelTable);
		
		sliderMax.setMinimum(1);
		sliderMax.setPaintTicks(true);
		sliderMax.setSnapToTicks(true);
		sliderMax.setBounds(10, 47, 404, 50);
		panel.add(sliderMax);

		JLabel lblRes = new JLabel("");
		lblRes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRes.setBounds(150, 167, 118, 14);
		panel.add(lblRes);
		
		JButton btnRandom = new JButton("N\u00FAmero aleatorio");
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int randomNumber = (int) Math.round(Math.random() * sliderMax.getValue());
				lblRes.setText(String.format("%d", randomNumber));
			}
		});
		btnRandom.setBounds(133, 133, 150, 23);
		panel.add(btnRandom);
	}
}
