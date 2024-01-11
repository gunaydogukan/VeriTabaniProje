package veriler;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

public class siparis extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel model = new DefaultTableModel();
	
	Object[] kolonlar = {"İD","FİYAT","TARİH","MÜŞTERİ","GÖZLÜK","SATİCİ"};
	Object[]satirler= new Object[6];
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siparis frame = new siparis();
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
	public siparis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 416, 243);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model.setColumnIdentifiers(kolonlar);
		ResultSet set = baglanti.siparisgoster();
		
		try {
			while(set.next()) {
				satirler[0]=set.getString("siparis_id");
				satirler[1]=set.getString("siparis_fiyat");
				satirler[2]=set.getString("siparis_tarih");
				satirler[3]=set.getString("siparis_musteri_id");
				satirler[4]=set.getString("siparis_gozluk_id");
				satirler[5]=set.getString("siparis_satici_id");
				model.addRow(satirler);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table.setModel(model);
		table.setBounds(205, 62, 192, 148);
		scrollPane.setViewportView(table);
		//contentPane.add(table);
	}
}
