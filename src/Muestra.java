

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mostrar")
public class Muestra extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public Muestra() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Leer todos los parametros del formulario //
		
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String estudios = request.getParameter("estudios");
		
		String[] preferencias = request.getParameterValues("preferencias");
		
		// Configuramos la salida de datos hacia el navegador //
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Generamos la salida de la web //
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Encuesta</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Resultado encuesta</h1>");
		out.println("Nombre: " + nombre + "<br>");
		out.println("Apellidos: " + apellidos + "<br>");
		out.println("Estudios: " + estudios + "<br>");
		out.println("Preferencias: ");
		for (int i = 0; i < preferencias.length; i++) {
			if(i < preferencias.length-1){out.println(preferencias[i] + ",");} 
			else {out.println(preferencias[i] + ".");}
		}
		out.println("</body>");
		out.println("</html>");
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
