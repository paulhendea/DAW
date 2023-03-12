package swingExample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JTabbedPane;

public class LabelDemo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMessage;
	private JLabel labelMessage;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabelDemo frame = new LabelDemo();
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
	public LabelDemo() {
		setTitle("My First Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("InternalFrame.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter something");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(63, 42, 203, 32);
		contentPane.add(lblNewLabel);
		
		textMessage = new JTextField();
		textMessage.setBounds(276, 53, 86, 20);
		contentPane.add(textMessage);
		textMessage.setColumns(10);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(btnNewButton, " ", " ", JOptionPane.YES_NO_CANCEL_OPTION);
			}
		});
		btnNewButton.setBounds(162, 160, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textMessage.setText(" ");
				labelMessage.setText(" ");
			}
		});
		btnNewButton_1.setBounds(261, 160, 89, 23);
		contentPane.add(btnNewButton_1);
		
		labelMessage = new JLabel("");
		labelMessage.setBounds(220, 248, 142, 80);
		contentPane.add(labelMessage);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Option 1");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(276, 80, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Option 2");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(276, 106, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter("########-?");
			mask.setPlaceholderCharacter('_');
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		JFormattedTextField formattedTextField = new JFormattedTextField(mask);
		formattedTextField.setBounds(276, 23, 86, 20);
		contentPane.add(formattedTextField);
		tabbedPane.setBounds(10, 263, 161, 87);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
	}
}
