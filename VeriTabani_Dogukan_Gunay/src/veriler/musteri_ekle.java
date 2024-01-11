package veriler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class musteri_ekle extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	Object[]veriler= new Object[4];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					musteri_ekle frame = new musteri_ekle();
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
	public musteri_ekle() {
		setTitle("MÜŞTERİ EKLE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("İSİM : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 69, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblSoyisim = new JLabel("SOYİSİM : ");
		lblSoyisim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSoyisim.setBounds(10, 42, 88, 22);
		contentPane.add(lblSoyisim);
		
		JLabel lblTelefon = new JLabel("TELEFON : ");
		lblTelefon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefon.setBounds(10, 74, 88, 29);
		contentPane.add(lblTelefon);
		
		JLabel lblReeteId = new JLabel("REÇETE İD:");
		lblReeteId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReeteId.setBounds(10, 113, 88, 22);
		contentPane.add(lblReeteId);
		
		textField = new JTextField();
		textField.setBounds(101, 14, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 46, 96, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(101, 81, 96, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(101, 113, 96, 19);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("KAYDET");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baglanti bag = new baglanti();
				
				veriler[0] = textField.getText(); //İSİM
				veriler[1] = textField_1.getText(); //SOYİSİM
				veriler[2] = Integer.parseInt(textField_2.getText()); //TEL 
				veriler[3] = Integer.parseInt(textField_3.getText());//RECETE
				bag.musteriEkle(veriler);
				
	            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(contentPane);
	            currentFrame.dispose();
				
				EventQueue.invokeLater(new Runnable() {
	                public void run() {
	                    try {
	                        musteri frame = new musteri();
	                        frame.setVisible(true);
	                    } catch (Exception ex) {
	                        ex.printStackTrace();
	                    }
	                }
	            });
				
				System.out.println("Müşteri eklendi");
			}
		});
		btnNewButton.setBounds(138, 169, 111, 21);
		contentPane.add(btnNewButton);
	}

}
