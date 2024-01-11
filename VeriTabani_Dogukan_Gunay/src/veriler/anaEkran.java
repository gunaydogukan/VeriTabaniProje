package veriler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class anaEkran extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	Object[]veriler= new Object[5];
	Object[]odeme= new Object[4];
	
	private JTextField tutar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					anaEkran frame = new anaEkran();
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
	public anaEkran() {
		setTitle("Veri Tabanı");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sipariş ver (ödemesini giriniz)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(10, 22, 244, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Müşteri İD GİRİNİZ :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 56, 112, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Satıcı İD giriniz:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 90, 112, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Gözlük İD Giriniz :\r\n");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(10, 124, 112, 24);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Fiyat : ");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBounds(10, 158, 112, 24);
		contentPane.add(lblNewLabel_1_2_1);
		
		textField = new JTextField();
		textField.setBounds(132, 60, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(132, 94, 96, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(132, 128, 96, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(132, 162, 96, 19);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Gözlükler ve MARKA\r\n");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				marka marka = new marka();
				marka.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(238, 127, 170, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("TARİH:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1_1.setBounds(10, 192, 112, 24);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(132, 191, 96, 19);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_2 = new JLabel("Yapılan Ödeme");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(378, 162, 125, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TUTAR:");
		lblNewLabel_3.setBounds(337, 199, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ödeme Türü:\r\n");
		lblNewLabel_3_1.setBounds(337, 217, 71, 13);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Taksit:");
		lblNewLabel_3_2.setBounds(336, 240, 45, 13);
		contentPane.add(lblNewLabel_3_2);
		
		tutar = new JTextField();
		tutar.setBounds(421, 192, 82, 13);
		contentPane.add(tutar);
		tutar.setColumns(10);
		
		JComboBox odeme_tur = new JComboBox();
		odeme_tur.setMaximumRowCount(2);
		odeme_tur.setModel(new DefaultComboBoxModel(new String[] {"Nakit", "Kart"}));
		odeme_tur.setBounds(421, 212, 72, 17);
		contentPane.add(odeme_tur);
		
		JCheckBox taksit = new JCheckBox("");
		taksit.setBounds(421, 232, 30, 21);
		contentPane.add(taksit);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Taksit süresi\r\n");
		lblNewLabel_3_2_1.setBounds(337, 263, 71, 13);
		contentPane.add(lblNewLabel_3_2_1);
		
		JComboBox sure = new JComboBox();
		sure.setModel(new DefaultComboBoxModel(new String[] {"0", "6 ", "8 ", "12 "}));
		sure.setMaximumRowCount(4);
		sure.setBounds(421, 259, 72, 20);
		contentPane.add(sure);
		
		
		JButton btnNewButton_1 = new JButton("SİPARİŞİ EKLE\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baglanti bag = new baglanti();
				veriler[0] = Integer.parseInt(textField.getText()); //musteri id
				veriler[1] = Integer.parseInt(textField_1.getText()); //satici id
				veriler[2] = Integer.parseInt(textField_2.getText()); //gozluk id 
				veriler[3] = Integer.parseInt(textField_3.getText());//fiyat id
	            veriler[4] = textField_4.getText(); //tarih
	            
	            bag.siparisEkle(veriler);
	            
	            odeme[0]=Integer.parseInt(tutar.getText().toString());//tutar
	            odeme[1]=(String) odeme_tur.getSelectedItem();//tur
	            if(taksit.isSelected()) {
	            	 String selectedSure = (String) sure.getSelectedItem();
	                 odeme[2] = Integer.parseInt(selectedSure.trim());
	            }else {
	            	odeme[2]=0;
	            }
	            odeme[3]=veriler[0];
	            bag.odemeYap(odeme);
	            
	            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(contentPane);
	            currentFrame.dispose();
				
				EventQueue.invokeLater(new Runnable() {
	                public void run() {
	                    try {
	                        anaEkran frame = new anaEkran();
	                        frame.setVisible(true);
	                    } catch (Exception ex) {
	                        ex.printStackTrace();
	                    }
	                }
	            });
	            
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(10, 231, 137, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("MÜŞTERİ");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				musteri mus= new musteri();
				mus.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(238, 59, 170, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("SATICI");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				satici satici = new satici();
				satici.setVisible(true);
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2_1.setBounds(238, 93, 170, 21);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_1_1 = new JButton("REÇETELERE GİT");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            EventQueue.invokeLater(new Runnable() {
	                public void run() {
	                    try {
	                        recete frame = new recete();
	                        frame.setVisible(true);
	                    } catch (Exception ex) {
	                        ex.printStackTrace();
	                    }
	                }
	            });
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(20, 277, 216, 21);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_3 = new JButton("ÖDEMELERİ GÖSTER");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
	                public void run() {
	                    try {
	                        odeme frame = new odeme();
	                        frame.setVisible(true);
	                    } catch (Exception ex) {
	                        ex.printStackTrace();
	                    }
	                }
	            });
				
			}
		});
		btnNewButton_3.setBounds(326, 283, 177, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_1_2 = new JButton("SİPARİŞLERİ GÖSTER\r\n");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
	                public void run() {
	                    try {
	                        siparis frame = new siparis();
	                        frame.setVisible(true);
	                    } catch (Exception ex) {
	                        ex.printStackTrace();
	                    }
	                }
	            });
				
				
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1_2.setBounds(157, 232, 169, 21);
		contentPane.add(btnNewButton_1_2);
	}
}
