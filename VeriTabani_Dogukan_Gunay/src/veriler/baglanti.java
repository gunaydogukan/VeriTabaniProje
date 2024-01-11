package veriler;

import java.sql.*;

public class baglanti {
	static String url = "jdbc:mysql://localhost:3306/cetinoptikdb";
	static String user = "root";
    static String password = "dogukan1903";
    
    
    public static ResultSet yap() {
    	ResultSet myRs = null;
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			CallableStatement callableStatement = connection.prepareCall("{ call marka_table() }");
	        boolean hasResults = callableStatement.execute();
			if(hasResults) {
				myRs=callableStatement.getResultSet();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myRs;

    }
    
    public static ResultSet yap2() {
    	ResultSet myRs = null;
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			CallableStatement callableStatement = connection.prepareCall("{ call gozluk_table() }");
	        boolean hasResults = callableStatement.execute();
			if(hasResults) {
				myRs=callableStatement.getResultSet();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myRs;

    }
    
    public static void siparisEkle(Object [] veriler) {
    	try {
			Connection connection = DriverManager.getConnection(url, user, password);
			CallableStatement callableStatement = connection.prepareCall("{ call add_siparis(?, ?, ?, ?, ?) }");
			
            // Metoda verilen diziyi callableStatement parametrelerine set etme
            callableStatement.setInt(1, (int) veriler[3]); // in_fiyat
            callableStatement.setObject(2, veriler[4]);    // in_tarih
            callableStatement.setInt(3, (int) veriler[0]); // in_musteri_id
            callableStatement.setInt(4, (int) veriler[2]); // in_gozluk_id
            callableStatement.setInt(5, (int) veriler[1]); // in_satici_id

            // Stored procedure'ı çalıştırma
            callableStatement.execute();

            // Bağlantıyı kapatma
            connection.close();
            System.out.println("EKLENDİ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }
    
    public static void musteriEkle(Object [] veriler) {
    	try {
			Connection connection = DriverManager.getConnection(url, user, password);
			CallableStatement callableStatement = connection.prepareCall("{ call add_musteri(?, ?, ?, ? ) }");
			
            // Metoda verilen diziyi callableStatement parametrelerine set etme
            callableStatement.setObject(1, veriler[0]); // isim
            callableStatement.setObject(2, veriler[1]);    // soyisim
            callableStatement.setInt(3, (int) veriler[2]); // tell
            callableStatement.setInt(4,  (int)veriler[3]); // recete


            // Stored procedure'ı çalıştırma
            callableStatement.execute();

            // Bağlantıyı kapatma
            connection.close();
            System.out.println("EKLENDİ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void odemeYap(Object [] odeme) {
    	try {
			Connection connection = DriverManager.getConnection(url, user, password);
			CallableStatement callableStatement = connection.prepareCall("{ call add_odeme(?, ?, ?, ? ) }");
			
			callableStatement.setObject(1, odeme[0]); 
            callableStatement.setObject(2, odeme[1]);    
            callableStatement.setInt(3, (int) odeme[2]); 
            callableStatement.setInt(4,  (int)odeme[3]); 
            
            // Stored procedure'ı çalıştırma
            callableStatement.execute();

            // Bağlantıyı kapatma
            connection.close();
            System.out.println("EKLENDİ");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static ResultSet musteri_goster() {
    	ResultSet myRs = null;
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			CallableStatement callableStatement = connection.prepareCall("{ call muster_table() }");
	        boolean hasResults = callableStatement.execute();
			if(hasResults) {
				myRs=callableStatement.getResultSet();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myRs;
    	
    }
    
    public static ResultSet musteri_duzen(Object [] change) {
    	ResultSet myRs = null;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            CallableStatement callableStatement = connection.prepareCall("{ call musteri_duzenle(?, ?, ?, ?, ?) }");

            // Parametreleri ayarla
            callableStatement.setInt(1, (int) change[0]);          // musteri_id
            callableStatement.setString(2, (String) change[1]);   // musteri_ad
            callableStatement.setString(3, (String) change[2]);   // musteri_soyad
            callableStatement.setString(4, (String) change[3]);   // musteri_telefon
            callableStatement.setInt(5, (int) change[4]);         // musteri_recete_id

            // Stored procedure'ü çağır
            boolean hasResults = callableStatement.execute();

            // Eğer bir sonuç kümesi varsa, ResultSet'i al
            if (hasResults) {
                myRs = callableStatement.getResultSet();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myRs;
    }
    
    public static void musteri_sil(int musteri_id) {
    	 try {
			Connection connection = DriverManager.getConnection(url, user, password);
			CallableStatement callableStatement = connection.prepareCall("{ call musteri_sil(?) }");
			 callableStatement.setInt(1,musteri_id);
			 boolean hasResults = callableStatement.execute();
			 if(hasResults) {
				 callableStatement.getResultSet();
				 connection.close();
		         System.out.println("Silindi.");
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static ResultSet receteGoster() {
    	ResultSet myRs = null;
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			CallableStatement callableStatement = connection.prepareCall("{ call recete_table() }");
	        boolean hasResults = callableStatement.execute();
			if(hasResults) {
				myRs=callableStatement.getResultSet();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myRs;
    }
    
    public static ResultSet odemeGoster() {
    	ResultSet myRs = null;
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			CallableStatement callableStatement = connection.prepareCall("{ call odeme_table() }");
	        boolean hasResults = callableStatement.execute();
			if(hasResults) {
				myRs=callableStatement.getResultSet();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myRs;
    }
    
    public static ResultSet saticiGoster() {
    	ResultSet myRs = null;
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			CallableStatement callableStatement = connection.prepareCall("{ call satici_table() }");
	        boolean hasResults = callableStatement.execute();
			if(hasResults) {
				myRs=callableStatement.getResultSet();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myRs;
    }
    
    public static void recte_ekle(Object [] veri) {
    	try {
			Connection con = DriverManager.getConnection(url, user, password);
			CallableStatement stat=con.prepareCall("{ call recete_ekle(?,?) }");
			stat.setDouble(1, (double) veri[0]);
			stat.setString(2, (String) veri[1]);
			boolean hasResults=stat.execute();
			
			if(hasResults) {
				 stat.close();
		          System.out.println("EKLEME YAPILDI");
			}else {
				System.out.println("YAPILMADI");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void satici_ekle(String veri) {
    	try {
			Connection con = DriverManager.getConnection(url, user, password);
			CallableStatement stat=con.prepareCall("{ call saticii_ekle(?) }");
			stat.setString(1, (String) veri);
			boolean hasResults=stat.execute();
			if(hasResults) {
				 stat.close();
		         System.out.println("EKLEME YAPILDI");
			}else {
				System.out.println("YAPILMADI");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	public static ResultSet siparisgoster() {
		ResultSet myRs = null;
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			CallableStatement callableStatement = connection.prepareCall("{ call siparis_table() }");
	        boolean hasResults = callableStatement.execute();
			if(hasResults) {
				myRs=callableStatement.getResultSet();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myRs;
	}
    

}