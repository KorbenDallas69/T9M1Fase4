package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;


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
    		
    		
    		
    		Producto p= new Producto();
    		p.setModelo(modelo);
    		boolean valida= new ProductoDAOImpl().validarP(p);
    		if (valida ==true) {
    			
    			// aqui me quede, modificar la linea para guardar el resultado, la siguiente linea esta incmpleta
    			Producto producto = new Producto();
    			//ProductoDAO dao=new ProductoDAOImpl();
    			//dao.consultarP(producto);
    			producto=consultarP(p);
   			
    			request.setAttribute("Producto", producto);
    			request.getRequestDispatcher("/muestraconsulta.jsp").forward(request,  response);
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
	
	private Producto consultarP(Producto prod) {
		// TODO Auto-generated method stub
		ProductoDAO dao=new ProductoDAOImpl();
		return dao.consultarP(prod);
	}

	}


