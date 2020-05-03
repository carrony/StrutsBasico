package com.dred.struts.strutservlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FilterDispatcher implements Filter {
	private FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig=filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String direccion=req.getRequestURI();
		int posUltimaBarra=direccion.lastIndexOf('/');
		String accion = direccion.substring(posUltimaBarra+1);
		String result="succes";
		if (accion.equals("alta_producto.action")) {
			ProductoAction pa = new ProductoAction();
			pa.setNombre(req.getParameter("nombre"));
			pa.setDescripcion(req.getParameter("descripcion"));
			pa.setPrecio(req.getParameter("precio"));
		
			 try {
				result= pa.execute();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("producto", pa);
		} 
		
		String vistaURL=null;
		if (accion.equals("alta_producto.action")) {
			if (result.equals("success")) {
				vistaURL = "/WEB-INF/jsp/altaproducto.jsp";	
			} else if (result.equals("input")) {
				vistaURL = "/index.jsp";	
			}	
		} else {
			vistaURL = "/index.jsp";
		}
		
		if (vistaURL!=null) {
			RequestDispatcher rd = req.getRequestDispatcher(vistaURL);
			rd.forward(req, res);
		}  else if ((direccion.indexOf("/css/") !=-1) 
				&& (req.getHeader("referer") == null)){
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		filterConfig=null;
	}
}
