package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import metier.entities.Produit;

public class ProduitDaoImpl implements IProduitDao {
	@Override
	public Produit save(Produit p) {
		
		Connection connection = SingletonConnetion.getConnection();
		System.out.println(connection);
		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO PRODUITS (DESIGNATION,PRIX,QUANTITE) VALUES (?,?,?)");
			ps.setString(1,p.getDesignation() );
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			int a =ps.executeUpdate();
			System.out.println(a);
			PreparedStatement ps2 = connection.prepareStatement(
					"SELECT  MAX(ID) AS MAXID FROM PRODUITS");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				p.setId(rs.getLong("MAXID"));
			}
		
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;

	}
	

	@Override
	public List<Produit> produitsParMC(String mc) {
		Connection connection = SingletonConnetion.getConnection();
		List<Produit> produits = new ArrayList();
		try {
			PreparedStatement ps = connection.prepareStatement(
			"SELECT * FROM PRODUITS WHERE DESIGNATION LIKE ?");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				Produit p =new Produit(rs.getString("DESIGNATION"),rs.getDouble("PRIX"),rs.getInt("QUANTITE"));
				p.setId(rs.getLong("ID"));
				produits.add(p);
			}
		}catch(SQLException e) {
			
		}
		
			return produits;
		
		
	}

	@Override
	public Produit getProduit(Long id) {
		Connection connection = SingletonConnetion.getConnection();
		Produit p = null;;

		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM PRODUITS WHERE id = ?");
			ps.setLong(1,id );
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p=new Produit();
				p.setId(id);
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
			}
		
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
		
	}

	@Override
	public Produit updateProduit(Produit p) {
		Connection connection = SingletonConnetion.getConnection();
		System.out.println(connection);
		try {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE  PRODUITS SET DESIGNATION=?,PRIX= ?,QUANTITE= ? WHERE ID = ?");
			ps.setString(1,p.getDesignation() );
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setLong(4,p.getId());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public void deleteProduit(Long id) {
		
		
		Connection connection = SingletonConnetion.getConnection();
		System.out.println(connection);
		try {
			PreparedStatement ps = connection.prepareStatement(
					"DELETE FROM PRODUITS where id= ?");
			ps.setLong(1,id);	
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public  void init() {
		System.out.println("Initialisation.... \n \n ");
	}

}
