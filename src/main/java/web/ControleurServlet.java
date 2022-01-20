package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import metier.entities.Produit;
/**
 * Servlet implementation class ControleurServlet
 */
//@WebServlet(name="web.ControleurServlet",urlPatterns={"*.do"})

public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProduitDao metier;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
    	
    	metier = new ProduitDaoImpl();
 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		if(path.equals("/index.do")) {
			request.getRequestDispatcher("produits.jsp").forward(request, response);

		}else if(path.equals("/chercher.do")){
			String motCle = request.getParameter("motCle");	
			ProduitModel model  = new ProduitModel();
			model.setMotCle(motCle);
			List<Produit> produits=metier.produitsParMC("%"+motCle+"%");
			model.setProduits(produits);
			request.setAttribute("model", model);
			request.getRequestDispatcher("produits.jsp").forward(request, response);
	
		}else if(path.equals("/saisie.do")){
			request.getRequestDispatcher("saisieProduit.jsp").forward(request, response);

		
		}else if(path.equals("/saveProduit.do")&& request.getMethod().equals("POST")){
			
			String des = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			Produit p = metier.save(new Produit(des,prix,quantite));
			request.setAttribute("produit", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
			
			
		}else if(path.equals("/supprimer.do")) {
			Long id =Long.parseLong(request.getParameter("id"));
			metier.deleteProduit(id);
			//request.getRequestDispatcher("produits.jsp").forward(request, response);
			//Redirection: je termine une action i l me dirige vers une autre action
			response.sendRedirect("chercher.do?motCle=");
				
		}
		
		else if(path.equals("/edit.do")) {
			Long id =Long.parseLong(request.getParameter("id"));
			Produit p =metier.getProduit(id);
			System.out.println(p.getDesignation());
			request.setAttribute("produit", p);
			request.getRequestDispatcher("editProduit.jsp").forward(request, response);
			

			
				
		}else if(path.equals("/updateProduit.do")&& request.getMethod().equals("POST")){
			Long id =Long.parseLong(request.getParameter("id"));
			String des = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			Produit p = new Produit(des,prix,quantite);
			p.setId(id);
			metier.updateProduit(p);
			request.setAttribute("produit", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
			
			
		}
		else {
			response.sendError(response.SC_NOT_FOUND);
		}
		//request.getRequestDispatcher("produits.jsp").forward(request, response);

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
