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
 * Servlet implementation class Newproduct
 */
@WebServlet(name="/Newproduct" , urlPatterns= {"/Newproduct"})
public class Newproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException{
    	response.setContentType("text/html;charset=UTF-8");
        
    	try (PrintWriter out = response.getWriter()){
    		String cantidad=request.getParameter("cantidad");
    		String modelo=request.getParameter("modelo");
    		String marca=request.getParameter("marca");
    		String descripcion=request.getParameter("descripcion");
    		String proveedor=request.getParameter("proveedor");
    		
    		Producto prod = new Producto(cantidad,modelo,marca,descripcion,proveedor);
    		
    		if (consultarP(prod).getItem()==0) {
    			boolean regP= new ProductoDAOImpl().registrarP(prod);
    			registrarP(prod);
    			consultarP(prod);
    			
    			request.setAttribute("Producto", prod);
    			request.getRequestDispatcher("/muestraconsulta.jsp").forward(request,  response);
    		}
    		else {
    			request.setAttribute("ProductoExistente", "Intentalo Nuevamente");
    			request.getRequestDispatcher("/agregarprod.jsp").forward(request,  response);
    		}
    		
    }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void registrarP(Producto producto) {
		ProductoDAO dao=new ProductoDAOImpl();
	}
	
	public Producto consultarP(Producto producto) {
		ProductoDAO dao = new ProductoDAOImpl();
		return dao.consultarP(producto);
	}
	
 }

