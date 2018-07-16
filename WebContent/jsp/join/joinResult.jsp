<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- memId, teamId, name, age, roll, password, ssn -->
<%@ page import="domain.*" %>
<%@ page import="service.*" %>

<%
	MemberBean mem = new MemberBean();
	mem.setUserid(request.getParameter("userid"));
	mem.setPassword(request.getParameter("password"));
	mem.setName(request.getParameter("name"));
	mem.setSsn(request.getParameter("ssn"));
	MemberServiceImpl.getInstance().createMember(mem);
%>