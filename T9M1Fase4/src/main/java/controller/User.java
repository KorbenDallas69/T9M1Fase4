package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario; 
import modelo.UsuarioDAO;
import modelo.UsuarioDaoImpl;

/**
 * Servlet implementation class User
 */
@WebServlet(name="/User", urlPatterns = {"/User"})
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    	response.setContentType("text/html;charser=UTF-8");
    	try (PrintWriter out = response.getWriter()){
    		String usuario = request.getParameter("usuario");
    		String password = request.getParameter("password");
    		
    		// hay que pasar estos valores usuario y password de la pagina de entrada al query para validar
    		Usuario usr= new Usuario();
    		usr.setUsuario(usuario);
    		usr.setPassword(password);
    		
    		
    		
    		// tomar el resultado de query en una variable boleana y dirigir a la pagina de imc o de index en funcion del resultado
    		boolean valida= new UsuarioDaoImpl().validar(usr);
    		if (valida ==true) {
    			
    			request.setAttribute("Usuario Existente", "Bienvenido");
    			request.getRequestDispatcher("/main.jsp").forward(request,  response);
    		}
    		else {
    			request.setAttribute("Error", "Verifica tus datos de usuario");
    			request.getRequestDispatcher("/index.jsp").forward(request,  response);
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