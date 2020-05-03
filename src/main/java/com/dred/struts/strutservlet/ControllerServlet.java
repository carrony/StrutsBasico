package com.dred.struts.strutservlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String direccion=request.getRequestURI();
		int posUltimaBarra=direccion.lastIndexOf('/');
		String accion = direccion.substring(posUltimaBarra+1);
		String result="success";
		if (accion.equals("alta_producto.action")) {
			ProductoAction pa = new ProductoAction();
			pa.setNombre(request.getParameter("nombre"));
			pa.setDescripcion(request.getParameter("descripcion"));
			pa.setPrecio(request.getParameter("precio"));
		
			 try {
				result= pa.execute();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("producto", pa);
		} 
		
		String vistaURL=null;
		if (accion.equals("alta_producto.action")) {
			if (result.equals("success")) {
				vistaURL = "/WEB-INF/jsp/altaproducto.jsp";	
			} else if (result.equals("input")) {
				vistaURL = "/index.jsp";	
			}		
		} else {
			vistaURL = "index.jsp";
		}
		
		if (vistaURL!=null) {
			RequestDispatcher rd = request.getRequestDispatcher(vistaURL);
			rd.forward(request, response);
		}
		
	}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	procesar(request, response);
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	procesar(request, response);
}
}
