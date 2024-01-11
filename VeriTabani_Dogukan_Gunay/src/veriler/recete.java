package veriler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class recete extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	Object[]veriler= new Object[2];
	DefaultTableModel model = new DefaultTableModel();
	Object[] kolonlar = {"İD","GÖZ NO","RECETE_TARİH"};
	Object[]satirler= new Object[3];
	
	private JLabel lblNewLabel;
	private JLabel lblReeteTarihi;
	private JTextField goz;
	private JTextField tarih;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recete frame = new recete();
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
	public recete() {
		setTitle("RECETE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 426, 103);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model.setColumnIdentifiers(kolonlar);
		
		ResultSet set = baglanti.receteGoster();
		//model.addRow(kolonlar);
		
		try {
			while(set.next()) {
				satirler[0]=set.getString("recete_id");
				satirler[1]=set.getString("recete_no");
				satirler[2]=set.getString("recete_tarihi");
				model.addRow(satirler);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table.setModel(model);
		table.setBounds(232, 102, 127, 89);
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Göz numarası : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 155, 100, 22);
		contentPane.add(lblNewLabel);
		
		lblReeteTarihi = new JLabel("Reçete Tarihi:");
		lblReeteTarihi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReeteTarihi.setBounds(10, 187, 100, 22);
		contentPane.add(lblReeteTarihi);
		
		goz = new JTextField();
		goz.setBounds(131, 159, 96, 19);
		contentPane.add(goz);
		goz.setColumns(10);
		
		tarih = new JTextField();
		tarih.setColumns(10);
		tarih.setBounds(131, 191, 96, 19);
		contentPane.add(tarih);
		
		lblNewLabel_1 = new JLabel("REÇETE EKLE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 143, 217, 13);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("REÇETEYİ KAYDET");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				veriler[0]=Double.parseDouble(goz.getText());
				veriler[1]=tarih.getText();
				baglanti.recte_ekle(veriler);
				System.out.println("veriler gönderildi...");
				
				// Mevcut pencereyi kapat
	            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(contentPane);
	            currentFrame.dispose();
	            // Yeni pencereyi aç
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
		btnNewButton.setBounds(287, 190, 148, 21);
		contentPane.add(btnNewButton);
		//contentPane.add(table);
	}

}
