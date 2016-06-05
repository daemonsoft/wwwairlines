<jsp:include page="header.jsp" />

<div class="card white center z-depth-5">
    <div class="card-content black-text">
        <span class="card-title">DATOS DEL TIQUETE</span>
        <table class="responsive-table highlight">
            <tbody>
                <tr>
                    <td>Código:</td>
                    <td><p>${codigo}</p></td>                          
                </tr>
                <tr>
                    <td>Identificación:</td>
                    <td><p>${ident}</p></td>                          
                </tr>

                <tr>
                    <td>Nombres:</td>
                    <td><p>${nombres}</p></td>
                </tr>

                <tr>
                    <td>Ciudad de origen:</td>
                    <td><p>${origen}</p></td>
                </tr>
                <tr>
                    <td>Aeropuerto de origen:</td>
                    <td><p>${aeroorigen}</p></td>
                </tr>
                <tr>
                    <td>Ciudad de destino:</td>
                    <td><p>${destino}</p></td>
                </tr>
                <tr>
                    <td>Aeropuerto de destino:</td>
                    <td><p>${aerodestino}</p></td>
                </tr>

                <tr>
                    <td>Fecha del Vuelo:</td>
                    <td><p>${fecha}</p></td>
                </tr>


            </tbody>
        </table>
        <img class="center-align" src="QRCodeServlet?qrtext=${codigo}">
    </div>
</div>



<jsp:include page="footer.jsp" />