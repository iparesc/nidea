<jsp:include page="/templates/head.jsp"></jsp:include>
<jsp:include page="/templates/navbar.jsp"></jsp:include>

<h2>RESULTADO</h2>
<% 
	int result=(Integer)request.getAttribute("resultado");
%>

<%=result %>
<jsp:include page="/templates/footer.jsp"></jsp:include>