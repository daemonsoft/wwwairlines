<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />
<form action="./LoginServlet" method="POST">
    <div class="col s12 m6">
        <div class="card white center z-depth-5">
            <div class="card-content black-text">
                        <span class="card-title">SOCIOS</span>
                        <p>* Autenticarte como socio te permite autocompletar datos y agilizar el proceso</p>
                        <div class="row">
                            <div class="offset-s2 input-field col s8">
                                <select name="tipoIdentificacion">
                                    <option value="" disabled selected>Tipo de documento</option>
                                    <option value="1">Cédula</option>
                                    <option value="2">Cédula de extranjeria</option>
                                    <option value="3">Pasaporte</option>
                                    <option value="4">Registro civil</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="offset-s2 input-field col s8">
                                <input type="text" id="id" name="id">
                                <label for="id">Número de identificación</label>
                            </div>
                        </div>    
                        <div class="row">          
                            <div class="offset-s2 input-field col s8">
                                <input type="password" id="contrasenia" name="contrasenia">
                                <label for="contrasenia">Contraseña</label>
                            </div>
                        </div>
                        <div class="row center-align">
                            <button class="btn waves-effect waves-light indigo accent-2" type="submit" name="action" value="Ingresar">INGRESAR
                                <i class="material-icons right">play_arrow</i>
                            </button>            
                        </div>
                    </div>
                </div>
            </div>               

            <br/><br/>     
            <div class="col s12 m6">
                <div class="card white center z-depth-5">
                    <div class="card-content black-text">
                        <span class="card-title">DATOS DEL VIAJERO</span>
                        <p>* Ingresa tu información personal para realizar la compra</p>
                        <div class="row">
                            <div class="input-field col s12 l6">
                                <select name="tipoId" value="${socio.socioPK.tipoid}">
                                    <option value="" disabled selected>Tipo de documento</option>
                                    <option value="1" ${tipo1}>Cédula</option>
                                    <option value="2" ${tipo2}>Cédula de extranjeria</option>
                                    <option value="3" ${tipo3}>Pasaporte</option>
                                    <option value="4" ${tipo4}>Registro civil</option>
                                </select>
                            </div>
                            <div class="input-field col s12 l6">
                                <input type="text" id="numeroId" name="numeroId" value="${socio.socioPK.numeroid}">
                                <label for="numeroId">Número de Identificación</label>
                            </div>
                            <div class="input-field col s12 l6">
                                <input type="text" id="nombre" name="nombre" value="${socio.nombre}">
                                <label for="nombre">Nombre</label>
                            </div>
                            <div class="input-field col s12 l6">
                                <input type="text" id="apellido" name="apellido" value="${socio.apellido}">
                                <label for="apellido">Apellido</label>
                            </div>
                            <div class="input-field col s12 l6">
                                <input type="date" id="fechaNacimiento" name="fechaNacimiento" class="datepicker" value="${socio.fechaNacimiento}">
                                <label for="fechaNacimiento">Fecha Nacimiento</label>
                            </div>

                            <div class="input-field col s12 l6 left-align">
                                <input type="email" id="correo" name="correo" class="validate" value="${socio.correo}">
                                <label for="correo">Correo</label>
                            </div>

                            <div class="input-field col s12 l6">
                                <select name="genero" value="${socio.genero}">
                                    <option value="" disabled selected>Género</option>
                                    <option value="M" ${genero1}>Masculino</option>
                                    <option value="F" ${genero2}>Femenino</option>
                                </select>
                            </div>
                            <div class="input-field col s12 l6">
                                <input type="text" id="paisNacimiento" name="paisNacimiento" value="${socio.paisNacimiento}">
                                <label for="paisNacimiento">Pais de Nacimiento</label>
                            </div>
                            <div class="input-field col s12 l6">
                                <input type="text" id="paisResidencia" name="paisResidencia" value="${socio.paisResidencia}">
                                <label for="paisResidencia">Pais de Residencia</label>
                            </div>
                            <div class="input-field col s12 l6">
                                <input type="text" id="departamento" name="departamento" value="${socio.departamento}"> 
                                <label for="departamento">Departamento</label>
                            </div>
                            <div class="input-field col s12 l6">
                                <input type="text" id="ciudad" name="ciudad" value="${socio.ciudad}">
                                <label for="ciudad">Ciudad</label>
                            </div>
                            <div class="input-field col s12 l6">
                                <input type="text" id="direccion" name="direccion" value="${socio.direccion}">
                                <label for="direccion">Direccion</label>
                            </div>
                            <br/>
                            <div class="col s12 center">
                                <button class="btn waves-effect waves-light indigo accent-2" type="submit" name="action" value="continuar">CONTINUAR
                                    <i class="material-icons right">language</i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>       
        </form>

        <jsp:include page="footer.jsp" />