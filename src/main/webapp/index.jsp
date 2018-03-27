
<jsp:include page="templates/head.jsp"></jsp:include>
<jsp:include page="templates/navbar.jsp"></jsp:include>
<%

	String nombre="pepe";
	String hora="10:18"; 

%>

<h2>Hello <%=nombre %></h2>
<p><%=hora %></p>	
<a href="generar-mesa">¿Quieres comprar una mesa?</a>
<a href="calculator">Calculadora</a>	
<jsp:include page="templates/footer.jsp"></jsp:include>


