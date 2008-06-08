package com.gwtextux.sample.showcase2.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: Redirect
 *
 */
 public class Redirect extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Redirect() {
		super();
	}   	
	
	/* 
	 * This just hits a url and returns its contents to the client
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String queryString = request.getQueryString();
		String address = queryString.split("url=")[1];
		URL url = new URL(address);
		
		PrintStream out = new PrintStream(response.getOutputStream());
		String inputLine = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		while((inputLine = br.readLine()) != null)
		{
			// System.out.println(inputLine);
			out.println(inputLine);
		}
		
		out.close();
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}