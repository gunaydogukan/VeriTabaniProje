package veriler;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class musteri extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel model = new DefaultTableModel();
	Object[] kolonlar = {"musteri_id","musteri_ad","musteri_soyad","musteri_telefon","musteri_recete_id"};
	Object[]satirler= new Object[5];
	Object[]yeni= new Object[5];
	
	
	private JTextField arama_cubugu;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField id;
	private JTextField ad;
	private JTextField soyad;
	private JTextField telefon;
	private JTextField recete;
	private JButton btnNewButton;
	private JButton btnSil;
	private JButton btnNewButton_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					musteri frame = new musteri();
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
	public musteri() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane musteri_tablosu = new JScrollPane();
		
		musteri_tablosu.setBounds(0, 147, 415, 194);
		contentPane.add(musteri_tablosu);
		
		table = new JTable();
		model.setColumnIdentifiers(kolonlar);
		table.setBounds(234, 92, 162, 78);
		musteri_tablosu.setViewportView(table);
		
		
		
		
		
		
		ResultSet set = baglanti.musteri_goster();
		model.addRow(satirler);
		System.out.println("test");
		
		try {
			while(set.next()) {
				satirler[0]=set.getString("musteri_id");
				satirler[1]=set.getString("musteri_ad");
				satirler[2]=set.getString("musteri_soyad");
				satirler[3]=set.getString("musteri_telefon");
				satirler[4]=set.getString("musteri_recete_id");
				model.addRow(satirler);
				System.out.println(satirler[1]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table.setModel(model);
		
		arama_cubugu = new JTextField();
		arama_cubugu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//klavyeyi dinliyo elinden çekince tetiklenir
				String ara = arama_cubugu.getText();
				
				dinamikAra(ara); //klavyeden arama bitince bu tetiklerinr
				
				
			}

			public void dinamikAra(String ara) {
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
		        table.setRowSorter(tr);
		        tr.setRowFilter(RowFilter.regexFilter(ara));
			}
		});
		
    
		arama_cubugu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		arama_cubugu.setBounds(0, 40, 426, 23);
		contentPane.add(arama_cubugu);
		arama_cubugu.setColumns(10);
		
		lblNewLabel = new JLabel("Müşteri Seç");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(0, 10, 415, 30);
		contentPane.add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setBounds(0, 73, 426, 12);
		contentPane.add(separator);
		
		lblNewLabel_1 = new JLabel("AD");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(504, 47, 79, 16);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("SOYAD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(504, 73, 79, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("İD\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(504, 21, 79, 16);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("TELEFON");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(504, 102, 79, 16);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("REÇETE");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(504, 137, 79, 16);
		contentPane.add(lblNewLabel_5);
		
		id = new JTextField();
		id.setBounds(598, 22, 96, 19);
		contentPane.add(id);
		id.setColumns(10);
		
		ad = new JTextField();
		ad.setColumns(10);
		ad.setBounds(598, 44, 96, 19);
		contentPane.add(ad);
		
		soyad = new JTextField();
		soyad.setColumns(10);
		soyad.setBounds(598, 73, 96, 19);
		contentPane.add(soyad);
		
		telefon = new JTextField();
		telefon.setColumns(10);
		telefon.setBounds(598, 103, 96, 19);
		contentPane.add(telefon);
		
		recete = new JTextField();
		recete.setColumns(10);
		recete.setBounds(598, 138, 96, 19);
		contentPane.add(recete);
		
		
		btnNewButton = new JButton("Düzenle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String idd,add,soyadd,tel,recc;
				idd=id.getText();
				add=ad.getText();
				soyadd=soyad.getText();
				tel=telefon.getText();
				recc=recete.getText();
				yeni[0]=Integer.parseInt(idd);
				yeni[1]=add;
				yeni[2]=soyadd;
				yeni[3]=tel;
				yeni[4]=Integer.parseInt(recc);
				
				int selectedRow = table.getSelectedRow();
				
				if(selectedRow==-1) {
					if(model.getRowCount()==0) {
						System.out.println("Tablo şuanda boş");
					}else {
						arama_cubugu.setText("Bir alan seç");
					}
				}else {
					//int id_sec = (int)model.getValueAt(selectedRow,0); //id seçtik tekrardan (fazladan iş)
					ResultSet set = baglanti.musteri_duzen(yeni);
					
					// Mevcut pencereyi kapat
		            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(contentPane);
		            currentFrame.dispose();
		            // Yeni pencereyi aç
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
				}
			}
		});
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(498, 197, 103, 21);
		contentPane.add(btnNewButton);
		
		btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String idd ;
				idd=id.getText();
				int convert=Integer.parseInt(idd);
				baglanti.musteri_sil(convert);
	            
				// Mevcut pencereyi kapat
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(contentPane);
	            currentFrame.dispose();
	            // Yeni pencereyi aç
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
			}
		});
		
		
		btnSil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSil.setBounds(626, 197, 110, 21);
		contentPane.add(btnSil);
		
		btnNewButton_1 = new JButton("Ekle\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				musteri_ekle mus= new musteri_ekle();
				mus.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(532, 274, 141, 21);
		contentPane.add(btnNewButton_1);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				id.setText((String)model.getValueAt(selectedRow,0));
				ad.setText((String)model.getValueAt(selectedRow,1));
				soyad.setText((String)model.getValueAt(selectedRow,2 ));
				telefon.setText((String)model.getValueAt(selectedRow,3 ));
				recete.setText((String)model.getValueAt(selectedRow,4 ));
				
			}
		});

		//contentPane.add(table);
	
	}
}
