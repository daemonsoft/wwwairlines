package com.udea.controller;

import com.udea.business.Socio;
import com.udea.business.SocioPK;
import com.udea.ejb.SocioFacadeLocal;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daemonsoft
 */
public class MiCuenta extends HttpServlet {

    @EJB
    private SocioFacadeLocal socioDAO;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String tipoid = request.getParameter("tipoIdentificacion");
        String numid = request.getParameter("id");
        String pass = request.getParameter("contrasenia");
        String action = request.getParameter("action");
        if (action != null && action.equalsIgnoreCase("continuar")) {

            String tipoId = request.getParameter("tipoId");
            String identificacion = request.getParameter("numeroId");
            String contrasena = request.getParameter("contrasena");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String fechaNacimiento = request.getParameter("fechaNacimiento");
            String correo = request.getParameter("correo");
            String genero = request.getParameter("genero");
            String paisNacimiento = request.getParameter("paisNacimiento");
            String paisResidencia = request.getParameter("paisResidencia");
            String departamento = request.getParameter("departamento");
            String ciudad = request.getParameter("ciudad");
            String direccion = request.getParameter("direccion");

            if (tipoId != null && !tipoId.trim().equalsIgnoreCase("")
                    && identificacion != null && !identificacion.trim().equalsIgnoreCase("")
                    && nombre != null && !nombre.trim().equalsIgnoreCase("")
                    && apellido != null && !apellido.trim().equalsIgnoreCase("")
                    && fechaNacimiento != null && !fechaNacimiento.trim().equalsIgnoreCase("")
                    && correo != null && !correo.trim().equalsIgnoreCase("")
                    && genero != null && !genero.trim().equalsIgnoreCase("")
                    && paisNacimiento != null && !paisNacimiento.trim().equalsIgnoreCase("")
                    && paisResidencia != null && !paisResidencia.trim().equalsIgnoreCase("")
                    && departamento != null && !departamento.trim().equalsIgnoreCase("")
                    && direccion != null && !direccion.trim().equalsIgnoreCase("")
                    && ciudad != null && !ciudad.trim().equalsIgnoreCase("")) {
                System.out.println(tipoId);
                switch (tipoId) {
                    case "Cedula":
                        tipoId = "1";
                        break;
                    case "Cedula de extranjeria":
                        tipoId = "2";
                        break;
                    case "Pasaporte":
                        tipoId = "3";
                        break;
                    default:
                        tipoId = "4";
                        break;
                }

                Socio socio = socioDAO.find(new SocioPK(tipoId, Integer.parseInt(identificacion)));
                socio.setNombre(nombre);
                socio.setApellido(apellido);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date;
                try {
                    date = formatter.parse(fechaNacimiento);
                    socio.setFechaNacimiento(date);
                } catch (ParseException ex) {
                    Logger.getLogger(MiCuenta.class.getName()).log(Level.SEVERE, null, ex);
                }

                socio.setContrasena(contrasena);
                socio.setCorreo(correo);
                socio.setGenero(genero);
                socio.setPaisNacimiento(Integer.parseInt(paisNacimiento));
                socio.setPaisResidencia(Integer.parseInt(paisResidencia));
                socio.setDepartamento(Integer.parseInt(departamento));
                socio.setCiudad(Integer.parseInt(ciudad));
                socio.setDireccion(direccion);
                socioDAO.edit(socio);
                request.setAttribute("message", "Datos actulizados correctamente.");
                request.setAttribute("tipoIdentificacion", socio.getSocioPK().getTipoid());
                request.setAttribute("contrasenia", socio.getContrasena());
                request.setAttribute("id", socio.getSocioPK().getNumeroid());
                request.getRequestDispatcher("/micuenta.jsp").forward(request, response);
                return;

            }
        }
        if (numid != null && tipoid != null && pass != null) {
            numid = numid.trim();
            tipoid = tipoid.trim();
            pass = pass.trim();

            if (!numid.equals("") && !tipoid.equals("") && !pass.equals("")) {
                int numeroid;
                try {
                    numeroid = Integer.parseInt(numid.trim());

                } catch (NumberFormatException nfe) {
                    request.setAttribute("message", "Ingresa los datos correctamente");
                    request.getRequestDispatcher("/micuenta.jsp").forward(request, response);
                    return;
                }

                Socio socio = socioDAO.find(new SocioPK(tipoid, numeroid));
                if (socio != null) {
                    String contrasena = socio.getContrasena();
                    if (!contrasena.equals(pass)) {
                        request.setAttribute("message", "Identificación y/ó Contraseña incorrectas");
                        request.getRequestDispatcher("/micuenta.jsp").forward(request, response);
                        return;
                    }
                    String nombre = socio.getNombre();
                    String apellido = socio.getApellido();
                    String email = socio.getCorreo();
                    String direccion = socio.getDireccion();
                    int ciudad = socio.getCiudad();
                    Date fechanacimiento = socio.getFechaNacimiento();
                    int millas = socio.getMillas();
                    String genero = socio.getGenero();
                    switch (Integer.parseInt(socio.getSocioPK().getTipoid())) {
                        case 1:
                            request.setAttribute("tipo1", "selected readonly=\"readonly\" ");
                            break;
                        case 2:
                            request.setAttribute("tipo2", "selected readonly=\"readonly\" ");
                            break;
                        case 3:
                            request.setAttribute("tipo3", "selected readonly=\"readonly\" ");
                            break;
                        case 4:
                            request.setAttribute("tipo4", "selected readonly=\"readonly\" ");
                            break;
                    }
                    if (socio.getGenero().equals("M")) {
                        request.setAttribute("genero1", "selected");
                    } else {
                        request.setAttribute("genero2", "selected");
                    }
                    request.setAttribute("nombre", nombre);
                    request.setAttribute("contrasena", socio.getContrasena());
                    request.setAttribute("apellido", apellido);
                    request.setAttribute("email", email);
                    request.setAttribute("direccion", direccion);
                    request.setAttribute("ciudad", ciudad);
                    request.setAttribute("fechanacimiento", fechanacimiento);
                    request.setAttribute("tipoid", tipoid);
                    request.setAttribute("numid", numid);
                    request.setAttribute("millas", millas);
                    request.setAttribute("genero", genero);
                    request.setAttribute("socio", socio);

                    request.getRequestDispatcher("/micuenta.jsp").forward(request, response);
                    return;
                }
            }
            request.setAttribute("message", "Ingresa los datos correctamente");
        }

        request.getRequestDispatcher("/micuenta.jsp").forward(request, response);
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
