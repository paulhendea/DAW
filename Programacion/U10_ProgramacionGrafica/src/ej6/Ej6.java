package ej6;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej6 extends JFrame {

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
					Ej6 frame = new Ej6();
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
	public Ej6() {
		//GET IMAGES
		BufferedImage dado6 = null;
		BufferedImage dado8 = null;
		BufferedImage dado10 = null;
		BufferedImage dado12 = null;
		BufferedImage dado20 = null;
		try {
			dado6 = ImageIO.read(new File("C:/Users/paulh//Documents/Eclipse/U10_ProgramacionGrafica/src/ej6/img/dado6s.png"));
			dado8 = ImageIO.read(new File("C:/Users/paulh//Documents/Eclipse/U10_ProgramacionGrafica/src/ej6/img/dado8s.png"));
			dado10 = ImageIO.read(new File("C:/Users/paulh//Documents/Eclipse/U10_ProgramacionGrafica/src/ej6/img/dado10s.png"));
			dado12 = ImageIO.read(new File("C:/Users/paulh//Documents/Eclipse/U10_ProgramacionGrafica/src/ej6/img/dado12s.png"));
			dado20 = ImageIO.read(new File("C:/Users/paulh//Documents/Eclipse/U10_ProgramacionGrafica/src/ej6/img/dado20s.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		setTitle("Dados de rol");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblRandomNumber = new JLabel("");
		lblRandomNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblRandomNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRandomNumber.setBounds(120, 159, 150, 31);
		panel.add(lblRandomNumber);
		
		JLabel lblDadoSeleccionado = new JLabel("");
		lblDadoSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadoSeleccionado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDadoSeleccionado.setBounds(120, 131, 150, 31);
		panel.add(lblDadoSeleccionado);
		
		JButton btnDado6 = new JButton("", new ImageIcon(dado6));
		btnDado6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDadoSeleccionado.setText("Dado de 6 caras");
				lblRandomNumber.setText(String.format("N�mero: %d", randomNumber(1, 6)));
			}
		});
		btnDado6.setMargin(new Insets(0, 0, 0, 0));
		btnDado6.setBackground(Color.WHITE);
		btnDado6.setBounds(80, 67, 40, 42);
		panel.add(btnDado6);
		
		JButton btnDado8 = new JButton("", new ImageIcon(dado8));
		btnDado8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDadoSeleccionado.setText("Dado de 8 caras");
				lblRandomNumber.setText(String.format("N�mero: %d", randomNumber(1, 8)));
			}
		});
		btnDado8.setMargin(new Insets(0, 0, 0, 0));
		btnDado8.setBackground(Color.WHITE);
		btnDado8.setBounds(130, 67, 40, 42);
		panel.add(btnDado8);
		
		JButton btnDado10 = new JButton("", new ImageIcon(dado10));
		btnDado10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDadoSeleccionado.setText("Dado de 10 caras");
				lblRandomNumber.setText(String.format("N�mero: %d", randomNumber(1, 10)));
			}
		});
		btnDado10.setMargin(new Insets(0, 0, 0, 0));
		btnDado10.setBackground(Color.WHITE);
		btnDado10.setBounds(180, 67, 40, 42);
		panel.add(btnDado10);
		
		JButton btnDado12 = new JButton("", new ImageIcon(dado12));
		btnDado12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDadoSeleccionado.setText("Dado de 12 caras");
				lblRandomNumber.setText(String.format("N�mero: %d", randomNumber(1, 12)));
			}
		});
		btnDado12.setMargin(new Insets(0, 0, 0, 0));
		btnDado12.setBackground(Color.WHITE);
		btnDado12.setBounds(230, 67, 40, 42);
		panel.add(btnDado12);
		
		JButton btnDado20 = new JButton("", new ImageIcon(dado20));
		btnDado20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDadoSeleccionado.setText("Dado de 20 caras");
				lblRandomNumber.setText(String.format("N�mero: %d", randomNumber(1, 20)));
			}
		});
		btnDado20.setMargin(new Insets(0, 0, 0, 0));
		btnDado20.setBackground(Color.WHITE);
		btnDado20.setBounds(280, 67, 40, 42);
		panel.add(btnDado20);
		
		JLabel lblInstruccion = new JLabel("Pulsa sobre un dado");
		lblInstruccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInstruccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstruccion.setBounds(125, 10, 150, 31);
		panel.add(lblInstruccion);
		
		JLabel lblDado6 = new JLabel("1-6");
		lblDado6.setHorizontalAlignment(SwingConstants.CENTER);
		lblDado6.setBounds(80, 52, 40, 14);
		panel.add(lblDado6);
		
		JLabel lblDado8 = new JLabel("1-8");
		lblDado8.setHorizontalAlignment(SwingConstants.CENTER);
		lblDado8.setBounds(130, 52, 40, 14);
		panel.add(lblDado8);
		
		JLabel lblDado10 = new JLabel("1-10");
		lblDado10.setHorizontalAlignment(SwingConstants.CENTER);
		lblDado10.setBounds(180, 52, 40, 14);
		panel.add(lblDado10);
		
		JLabel lblDado12 = new JLabel("1-12");
		lblDado12.setHorizontalAlignment(SwingConstants.CENTER);
		lblDado12.setBounds(230, 52, 40, 14);
		panel.add(lblDado12);
		
		JLabel lblDado20 = new JLabel("1-20");
		lblDado20.setHorizontalAlignment(SwingConstants.CENTER);
		lblDado20.setBounds(280, 52, 40, 14);
		panel.add(lblDado20);
	}
	private static int randomNumber(int min, int max) {
		int range = max - min;
		int randomNumber = (int) Math.round((Math.random() * range) + min);
		return randomNumber;
	}
}
