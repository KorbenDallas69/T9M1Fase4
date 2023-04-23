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
import modelo.UsuarioDAOImpl;

/**
 * Servlet implementation class newuser
 */
@WebServlet(name="/Newuser", urlPatterns= {"/Newuser"})
public class Newuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException{
    	response.setContentType("text/html;charset=UTF-8");
    	try (PrintWriter out = response.getWriter()){
    		String usuario=request.getParameter("usuario");
    		String password=request.getParameter("password");
    		String nombre=request.getParameter("nombre");
    		String apellido=request.getParameter("apellido");
    		String edad=request.getParameter("edad");
    		
    		Usuario user = new Usuario(usuario,password,nombre,apellido,edad);
    		
    		if (consultar(user).getId()==0) {
    			boolean registra= new UsuarioDAOImpl().registrar(user);
    			// Revisar la linea de registrar
    			registrar(user);
    			request.setAttribute("UsuarioRegistrado", "Tu Usuario fue Creado Exitosamente");
    			request.getRequestDispatcher("/index.jsp").forward(request,  response);
    		}
    		else {
    			request.setAttribute("UsuarioExistente", "Error, el Usuario ya Existe, Intentalo Nuevamente");
    			request.getRequestDispatcher("/newuser.jsp").forward(request,  response);
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
		processRequest(request, response);
	}
	
	public void registrar(Usuario usuario) {
		UsuarioDAO dao=new UsuarioDAOImpl();
	}
	
	public Usuario consultar(Usuario usuario) {
		UsuarioDAO dao = new UsuarioDAOImpl();
		return dao.consultar(usuario);
	}

}