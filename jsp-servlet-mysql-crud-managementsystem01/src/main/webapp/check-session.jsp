<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>


<%
    Object userObject = session.getAttribute("useracountname");
    if (userObject != null) {
        out.println("<h3>Hi, " + userObject.toString()+"</h3>");
    }else{
    	System.out.print("No Session Log in Properly.");
    	response.sendRedirect("/");
    }
    
%>
