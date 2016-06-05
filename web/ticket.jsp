<jsp:include page="header.jsp" />

<h1> ${codigo} </h1>

<img src="QRCodeServlet?qrtext=${codigo}">

<jsp:include page="footer.jsp" />