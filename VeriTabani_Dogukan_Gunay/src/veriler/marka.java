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
import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class marka extends JFrame {
	baglanti baglanti = new baglanti();
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	
	Object[] kolonlar = {"İD","MODEL","MARKA"};
	Object[] kolonlar2 = {"İD","FİYAT","MARKA_İD"};
	Object[]satirler= new Object[3];
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					marka frame = new marka();
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
	public marka() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 416, 133);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		//model.addRow(satirler);
		//table.setModel(model);
		table.setBounds(184, 84, 177, 99);
		scrollPane.setViewportView(table);
		model.setColumnIdentifiers(kolonlar);
		
		JButton btnNewButton = new JButton("Göster");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet set = baglanti.yap();
				model.addRow(satirler);
				try {
					while(set.next()) {
						satirler[0]=set.getString("marka_id");
						satirler[1]=set.getString("marka_gozluk_model");
						satirler[2]=set.getString("marka_ismi");
						model.addRow(satirler);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				table.setModel(model);
			}
		});
		btnNewButton.setBounds(36, 153, 85, 21);
		contentPane.add(btnNewButton);
		
		// İkinci sekme
		JScrollPane scrollPane2 = new JScrollPane();
		tabbedPane.addTab("Tab 2", null, scrollPane2, null);

		JTable table2 = new JTable();
		scrollPane2.setViewportView(table2);
		DefaultTableModel model2 = new DefaultTableModel();
		table2.setModel(model2);
		model2.setColumnIdentifiers(kolonlar2);

		JButton btnNewButton2 = new JButton("Gözlükler");
		btnNewButton2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	ResultSet set = baglanti.yap2();
				model.addRow(satirler);

		        try {
		            while (set.next()) {
		            	satirler[0]=set.getString("gozluk_id");
						satirler[1]=set.getString("gozluk_fiyat");
						satirler[2]=set.getString("gozluk_marka_id");
						model2.addRow(satirler);
		            }
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }

		        table2.setModel(model2);
		    }
		});
		btnNewButton2.setBounds(200, 153, 150, 21);
		contentPane.add(btnNewButton2);
		//contentPane.add(table);
	}
}
