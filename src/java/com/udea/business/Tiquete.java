/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.business;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JPOH97
 */
@Entity
@Table(name = "tiquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiquete.findAll", query = "SELECT t FROM Tiquete t"),
    @NamedQuery(name = "Tiquete.findByVuelo", query = "SELECT t FROM Tiquete t WHERE t.tiquetePK.vuelo = :vuelo"),
    @NamedQuery(name = "Tiquete.findByAsiento", query = "SELECT t FROM Tiquete t WHERE t.tiquetePK.asiento = :asiento"),
    @NamedQuery(name = "Tiquete.findByPrecio", query = "SELECT t FROM Tiquete t WHERE t.precio = :precio"),
    @NamedQuery(name = "Tiquete.findByTipoid", query = "SELECT t FROM Tiquete t WHERE t.tipoid = :tipoid"),
    @NamedQuery(name = "Tiquete.findByNumeroid", query = "SELECT t FROM Tiquete t WHERE t.numeroid = :numeroid"),
    @NamedQuery(name = "Tiquete.findByTipo", query = "SELECT t FROM Tiquete t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "Tiquete.findByCodigo", query = "SELECT t FROM Tiquete t WHERE t.codigo = :codigo")})
public class Tiquete implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TiquetePK tiquetePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 6, max = 6)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "checkedin")
    private int checkedin;

    public int getCheckedin() {
        return checkedin;
    }

    public void setCheckedin(int checkedin) {
        this.checkedin = checkedin;
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "precio")
    private Integer precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipoid")
    private String tipoid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroid")
    private int numeroid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private int tipo;
    @JoinColumn(name = "vuelo", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vuelo vuelo1;
    @JoinColumn(name = "asiento", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Asiento asiento1;
    

    public Tiquete() {
    }

    public Tiquete(TiquetePK tiquetePK) {
        this.tiquetePK = tiquetePK;
    }

    public Tiquete(TiquetePK tiquetePK, String tipoid, int numeroid, int tipo, String codigo) {
        this.tiquetePK = tiquetePK;
        this.tipoid = tipoid;
        this.numeroid = numeroid;
        this.tipo = tipo;
        this.codigo = codigo;
        this.checkedin = 0;
    }

    public Tiquete(int vuelo, int asiento) {
        this.tiquetePK = new TiquetePK(vuelo, asiento);
    }

    public TiquetePK getTiquetePK() {
        return tiquetePK;
    }

    public void setTiquetePK(TiquetePK tiquetePK) {
        this.tiquetePK = tiquetePK;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getTipoid() {
        return tipoid;
    }

    public void setTipoid(String tipoid) {
        this.tipoid = tipoid;
    }

    public int getNumeroid() {
        return numeroid;
    }

    public void setNumeroid(int numeroid) {
        this.numeroid = numeroid;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Vuelo getVuelo1() {
        return vuelo1;
    }

    public void setVuelo1(Vuelo vuelo1) {
        this.vuelo1 = vuelo1;
    }

    public Asiento getAsiento1() {
        return asiento1;
    }

    public void setAsiento1(Asiento asiento1) {
        this.asiento1 = asiento1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiquetePK != null ? tiquetePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiquete)) {
            return false;
        }
        Tiquete other = (Tiquete) object;
        if ((this.tiquetePK == null && other.tiquetePK != null) || (this.tiquetePK != null && !this.tiquetePK.equals(other.tiquetePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.business.Tiquete[ tiquetePK=" + tiquetePK + " ]";
    }

}
