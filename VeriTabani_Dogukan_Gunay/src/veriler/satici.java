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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class satici extends JFrame {

	private JPanel contentPane;
	private JTable table;

	DefaultTableModel model = new DefaultTableModel();
	Object[] kolonlar = {"İD","Satıcı adı"};
	Object[]satirler= new Object[2];
	String veriler;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					satici frame = new satici();
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
	public satici() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 126, 124);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model.setColumnIdentifiers(kolonlar);
		ResultSet set = baglanti.saticiGoster();
		
		try {
			while(set.next()) {
				System.out.print("while içi");
				satirler[0]=set.getString("satici_id");
				satirler[1]=set.getString("satici_adi");
				model.addRow(satirler);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table.setModel(model);
		table.setBounds(181, 37, 104, 153);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("SATICI EKLE\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(165, 1, 155, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ADI:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(179, 49, 51, 21);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(224, 51, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("EKLE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				veriler = textField.getText();
				baglanti.satici_ekle(veriler);
				
				// Mevcut pencereyi kapat
	            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(contentPane);
	            currentFrame.dispose();
				
				EventQueue.invokeLater(new Runnable() {
	                public void run() {
	                    try {
	                        satici frame = new satici();
	                        frame.setVisible(true);
	                    } catch (Exception ex) {
	                        ex.printStackTrace();
	                    }
	                }
	            });
			}
		});
		btnNewButton.setBounds(218, 99, 85, 21);
		contentPane.add(btnNewButton);
		//contentPane.add(table);
	}
}
