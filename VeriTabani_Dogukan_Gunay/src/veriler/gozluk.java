package veriler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class gozluk extends JFrame {
//şuan boş
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	Object[] kolonlar = {"İD","FİYAT","MARKA_İD"};
	Object[]satirler= new Object[3];
	//Object[]satirler= {"1","2","3"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gozluk frame = new gozluk();
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
	public gozluk() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 394, 167);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		model.setColumnIdentifiers(kolonlar);
		//model.addRow(satirler);
		//table.setModel(model);
		
		table.setBounds(234, 125, 175, 60);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("VERİLERİ GÖSTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet set = baglanti.yap2();
				model.addRow(satirler);
				try {
					while(set.next()) {
						satirler[0]=set.getString("gozluk_id");
						satirler[1]=set.getString("gozluk_fiyat");
						satirler[2]=set.getString("gozluk_marka_id");
						model.addRow(satirler);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.setModel(model);
			}
		});
		btnNewButton.setBounds(53, 187, 134, 21);
		contentPane.add(btnNewButton);
		
		JButton btnMarkalarGster = new JButton("MARKALARI GÖSTER\r\n");
		btnMarkalarGster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marka marka = new marka();
				marka.setVisible(true);
			}
		});
		btnMarkalarGster.setBounds(208, 187, 134, 21);
		contentPane.add(btnMarkalarGster);
		//contentPane.add(table);
	}
}
