package dao;

import java.util.*;

import metier.entities.Produit;

public class TestDao {

	
	  public static void main(String[] args) {
	  
	  ProduitDaoImpl dao = new ProduitDaoImpl(); 
	  Produit p1 = dao.save(new Produit("hp",3500.00,2));
	  //System.out.println(p1.toString());
	  //Produit p2 = dao.save(new Produit("DELL",4000.00,3));
	  //Produit p3 = dao.save(new Produit("Iphone8",4500.00,6)) ;
	  
	  List<Produit> pp = new ArrayList();
	  pp=dao.produitsParMC("%D%");
	  
	  for(Produit p :pp) {
		  System.out.println(p.toString());
	  }
	 
	  }
	  
	  
	  
	  
	 
}
