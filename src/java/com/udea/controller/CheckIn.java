/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.business.Cliente;
import com.udea.business.ClientePK;
import com.udea.business.Socio;
import com.udea.business.SocioPK;
import com.udea.business.Tiquete;
import com.udea.ejb.ClienteFacadeLocal;
import com.udea.ejb.SocioFacadeLocal;
import com.udea.ejb.TiqueteFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daemonsoft
 */
public class CheckIn extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    private TiqueteFacadeLocal tiqueteDAO;

    @EJB
    private SocioFacadeLocal socioDAO;

    @EJB
    private ClienteFacadeLocal clienteDAO;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String codigo = request.getParameter("codigo");
            request.setAttribute("codigo", codigo);
            Tiquete t;
            String nombres;
            String ident;
            String confirma = "<div class=\"row\">\n"
                    + "                    <div class=\"offset-s2 input-field col s8\">\n"
                    + "                        <input type=\"text\" id=\"codigo\" name=\"codigo\">\n"
                    + "                        <label for=\"codigo\" >Código de Tiquete</label>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"row center-align\">\n"
                    + "                        <button class=\"btn waves-effect waves-light indigo accent-2\" type=\"submit\" name=\"action\" value=\"Ingresar\">INGRESAR\n"
                    + "                            <i class=\"material-icons right\">play_arrow</i>\n"
                    + "                        </button>            \n"
                    + "                    </div>\n"
                    + "                </div>";
            if ("Confirmar".equals(request.getParameter("action"))) {
                request.setAttribute("codigo", codigo);
                t = tiqueteDAO.finfByCodigo(codigo.trim().toUpperCase());
                if (t != null) {
                    request.setAttribute("codigo", t.getCodigo());
                    t.setCheckedin(1);
                    tiqueteDAO.edit(t);
                    if (t.getTipo() == 0) {
                        Cliente c = clienteDAO.find(new ClientePK(t.getTipoid(), t.getNumeroid()));
                        nombres = c.getNombre() + " " + c.getApellido();
                        int inttipo = Integer.parseInt(c.getClientePK().getTipoid());
                        String strtipo = "";

                        switch (inttipo) {
                            case 1:
                                strtipo = "Cédula: ";
                                break;
                            case 2:
                                strtipo = "Cédula de extranjeria: ";
                                break;
                            case 3:
                                strtipo = "Pasaporte: ";
                                break;
                            case 4:
                                strtipo = "Registro civil: ";
                                break;
                        }
                        ident = strtipo + " " + c.getClientePK().getNumeroid();
                    } else {
                        Socio s = socioDAO.find(new SocioPK(t.getTipoid(), t.getNumeroid()));
                        nombres = s.getNombre() + " " + s.getApellido();
                        int inttipo = Integer.parseInt(s.getSocioPK().getTipoid());
                        String strtipo = "";

                        switch (inttipo) {
                            case 1:
                                strtipo = "Cédula: ";
                                break;
                            case 2:
                                strtipo = "Cédula de extranjeria: ";
                                break;
                            case 3:
                                strtipo = "Pasaporte: ";
                                break;
                            case 4:
                                strtipo = "Registro civil: ";
                                break;
                        }
                        ident = strtipo + " " + s.getSocioPK().getNumeroid();
                    }

                    request.setAttribute("nombres", nombres);
                    request.setAttribute("ident", ident);
                    request.setAttribute("origen", t.getVuelo1().getAeropuertoSalida().getCiudad());

                    request.setAttribute("destino", t.getVuelo1().getAeropuertoLlegada().getCiudad());
                    request.setAttribute("aeroorigen", t.getVuelo1().getAeropuertoSalida().getNombre());

                    request.setAttribute("aerodestino", t.getVuelo1().getAeropuertoLlegada().getNombre());
                    request.setAttribute("fecha", t.getVuelo1().getFecha());

                    request.getRequestDispatcher("/ticket.jsp").forward(request, response);
                    return;
                }

            } else if (codigo != null && !codigo.trim().equals("")) {
                codigo = codigo.trim().toUpperCase();
                t = tiqueteDAO.finfByCodigo(codigo);
                if (t != null) {
                    request.setAttribute("codigo", t.getCodigo());

                    if (t.getTipo() == 0) {
                        Cliente c = clienteDAO.find(new ClientePK(t.getTipoid(), t.getNumeroid()));
                        nombres = c.getNombre() + " " + c.getApellido();
                        int inttipo = Integer.parseInt(c.getClientePK().getTipoid());
                        String strtipo = "";

                        switch (inttipo) {
                            case 1:
                                strtipo = "Cédula: ";
                                break;
                            case 2:
                                strtipo = "Cédula de extranjeria: ";
                                break;
                            case 3:
                                strtipo = "Pasaporte: ";
                                break;
                            case 4:
                                strtipo = "Registro civil: ";
                                break;
                        }
                        ident = strtipo + " " + c.getClientePK().getNumeroid();
                    } else {
                        Socio s = socioDAO.find(new SocioPK(t.getTipoid(), t.getNumeroid()));
                        nombres = s.getNombre() + " " + s.getApellido();
                        int inttipo = Integer.parseInt(s.getSocioPK().getTipoid());
                        String strtipo = "";

                        switch (inttipo) {
                            case 1:
                                strtipo = "Cédula: ";
                                break;
                            case 2:
                                strtipo = "Cédula de extranjeria: ";
                                break;
                            case 3:
                                strtipo = "Pasaporte: ";
                                break;
                            case 4:
                                strtipo = "Registro civil: ";
                                break;
                        }
                        ident = strtipo + " " + s.getSocioPK().getNumeroid();
                    }
                    if (t.getCheckedin() == 1) {
                        request.setAttribute("nombres", nombres);
                        request.setAttribute("ident", ident);
                        request.setAttribute("origen", t.getVuelo1().getAeropuertoSalida().getCiudad());

                        request.setAttribute("destino", t.getVuelo1().getAeropuertoLlegada().getCiudad());
                        request.setAttribute("aeroorigen", t.getVuelo1().getAeropuertoSalida().getNombre());

                        request.setAttribute("aerodestino", t.getVuelo1().getAeropuertoLlegada().getNombre());
                        request.setAttribute("fecha", t.getVuelo1().getFecha());

                        request.getRequestDispatcher("/ticket.jsp").forward(request, response);
                        return;

                    }
                    confirma = "<span class=\"card-title\">DATOS DEL TIQUETE</span>\n"
                            + "        <table class=\"responsive-table highlight\">\n"
                            + "            <tbody>\n"
                            + "                <tr>\n"
                            + "                    <td>Código:</td>\n"
                            + "                    <td><p>"+ t.getCodigo()+"</p></td>                          \n"
                            + "                </tr>\n"
                            + "                <tr>\n"
                            + "                    <td>Identificación:</td>\n"
                            + "                    <td><p>"+ident+ "</p></td>                          \n"
                            + "                </tr>\n"
                            + "\n"
                            + "                <tr>\n"
                            + "                    <td>Nombres:</td>\n"
                            + "                    <td><p>"+nombres+"</p></td>\n"
                            + "                </tr>\n"
                            + "\n"
                            + "                <tr>\n"
                            + "                    <td>Ciudad de origen:</td>\n"
                            + "                    <td><p>"+t.getVuelo1().getAeropuertoSalida().getCiudad()+"</p></td>\n"
                            + "                </tr>\n"
                            + "                <tr>\n"
                            + "                    <td>Aeropuerto de origen:</td>\n"
                            + "                    <td><p>"+t.getVuelo1().getAeropuertoSalida().getNombre()+"</p></td>\n"
                            + "                </tr>\n"
                            + "                <tr>\n"
                            + "                    <td>Ciudad de destino:</td>\n"
                            + "                    <td><p>"+t.getVuelo1().getAeropuertoLlegada().getCiudad()+"</p></td>\n"
                            + "                </tr>\n"
                            + "                <tr>\n"
                            + "                    <td>Aeropuerto de destino:</td>\n"
                            + "                    <td><p>"+t.getVuelo1().getAeropuertoLlegada().getNombre()+"</p></td>\n"
                            + "                </tr>\n"
                            + "\n"
                            + "                <tr>\n"
                            + "                    <td>Fecha del Vuelo:</td>\n"
                            + "                    <td><p>"+ t.getVuelo1().getFecha() +"</p></td>\n"
                            + "                </tr>\n"
                            + "\n"
                            + "\n"
                            + "            </tbody>\n"
                            + "        </table>\n";
                           

                    confirma += "<a class=\"waves-effect waves-light indigo btn modal-trigger\" href=\"#modal1\">Check In</a>\n"
                            + "\n"
                            + "  <div id=\"modal1\" class=\"modal\" >\n"
                            + "    <div class=\"modal-content\" >\n"
                            + "      <h4>Confirmar abordaje</h4>\n"
                            + "      <p>" + "Estimad@ " + nombres + " está segur@ que desea confirmar el abordaje del vuelo con tiquete <input readonly=\"readonly\" style=\"width: 80px; color: black; border: none;"
                            + "border-color: transparent;\" name=\"codigo\" value=\"" + t.getCodigo() + "\"/>?</p>\n"
                            + "    </div>\n"
                            + "    <div class=\"modal-footer\">\n"
                            + " "
                            + "      <button class=\"btn modal-action modal-close waves-effect waves-light indigo accent-2\" type=\"submit\" name=\"action\" value=\"Confirmar\">Confirmar\n"
                            + "                            \n"
                            + "                        </button>\n"
                            + "    </div>\n"
                            + "  </div>";

                } else {
                    request.setAttribute("message", "Codigo NO válido");

                }

            }

            request.setAttribute("confirma", confirma);
            request.getRequestDispatcher("/checkin.jsp").forward(request, response);
        }
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
