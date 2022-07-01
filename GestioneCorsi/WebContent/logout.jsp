
<%
if (session.getAttribute("tentativi") != null && (int) session.getAttribute("tentativi") >= 5) {
	response.sendRedirect("troppitentativi.jsp");
}
session.invalidate();
response.sendRedirect("index.jsp");
%>