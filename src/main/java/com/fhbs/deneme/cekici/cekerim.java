package com.fhbs.deneme.cekici;
import com.fhbs.deneme.ConnectionManager;
import com.fhbs.deneme.HomeController;

import java.util.ArrayList;
import com.fhbs.deneme.kitap;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class cekerim {
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//ArrayList<kitap> kitapList = null;
	public ArrayList<kitap> get(){
        ArrayList <kitap> kitapList=new ArrayList<kitap>();
        Connection con = ConnectionManager.getConnection();
        
        try{
            Statement st =con.createStatement();
            ResultSet rs =  st.executeQuery("select *from kitap");
            while(rs.next())
            kitapList.add (new kitap(rs.getInt("id"),rs.getString("ad"),rs.getString("yazar")));
            logger.info(kitapList.toString());
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return kitapList;
    }
}
