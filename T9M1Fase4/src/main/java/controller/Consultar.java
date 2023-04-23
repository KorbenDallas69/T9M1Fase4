package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Producto; 
import modelo.ProductoDAO;
import modelo.ProductoDAOImpl;

/**
 * Servlet implementation class User
 */
@WebServlet(name="/Consultar", urlPatterns = {"/Consultar"})
public class Consultar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    	response.setContentType("text/html;charser=UTF-8");
    	try (PrintWriter out = response.getWriter()){
    		String modelo = request.getParameter("modelo");
    		
    		
    		// aqui me quede
    		Producto prod= new Producto();
    		//prod.setModelo(modelo);
    		
    		 

    		
    		if (consultarP(prod).getItem()!=0) {
    			
    			request.setAttribute("Producto Existente", "Encontrado");
    			request.getRequestDispatcher("/main.jsp").forward(request,  response);
    		}
    		else {
    			request.setAttribute("Producto", "No Encontrado");
    			request.getRequestDispatcher("/main.jsp").forward(request,  response);
    		}
    		
    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

}
