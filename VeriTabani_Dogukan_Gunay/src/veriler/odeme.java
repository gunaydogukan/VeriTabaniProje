package veriler;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class odeme extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel model = new DefaultTableModel();
	
	Object[] kolonlar = {"İD","TUTAR","TÜR","VADE","MÜŞTERİ"};
	Object[]satirler= new Object[5];
	//Object[]satirler= {"1","2","3","4","5"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					odeme frame = new odeme();
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
	public odeme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 416, 137);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model.setColumnIdentifiers(kolonlar);
		ResultSet set = baglanti.odemeGoster();
		//model.addRow(kolonlar);
		System.out.print("while dışı");
		try {
			while(set.next()) {
				System.out.print("while içi");
				satirler[0]=set.getString("odeme_İD");
				satirler[1]=set.getString("odeme_tutari");
				satirler[2]=set.getString("odeme_turu");
				satirler[3]=set.getString("odeme_vadesi");
				satirler[4]=set.getString("odeme_musteri_id");
				model.addRow(satirler);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table.setModel(model);
		table.setBounds(215, 110, 211, 93);
		scrollPane.setViewportView(table);
		//contentPane.add(table);
	}

}
