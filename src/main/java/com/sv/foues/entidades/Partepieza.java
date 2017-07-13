/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.foues.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "partepieza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partepieza.findAll", query = "SELECT p FROM Partepieza p")
    , @NamedQuery(name = "Partepieza.findByIdpartepieza", query = "SELECT p FROM Partepieza p WHERE p.idpartepieza = :idpartepieza")
    , @NamedQuery(name = "Partepieza.findByParte", query = "SELECT p FROM Partepieza p WHERE p.parte = :parte")})
public class Partepieza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpartepieza", nullable = false)
    private Integer idpartepieza;
    @Column(name = "parte", length = 45)
    private String parte;
    @JoinColumn(name = "pieza_idpieza", referencedColumnName = "idpieza", nullable = false)
    @ManyToOne(optional = false)
    private Pieza piezaIdpieza;

    public Partepieza() {
    }

    public Partepieza(Integer idpartepieza) {
        this.idpartepieza = idpartepieza;
    }

    public Integer getIdpartepieza() {
        return idpartepieza;
    }

    public void setIdpartepieza(Integer idpartepieza) {
        this.idpartepieza = idpartepieza;
    }

    public String getParte() {
        return parte;
    }

    public void setParte(String parte) {
        this.parte = parte;
    }

    public Pieza getPiezaIdpieza() {
        return piezaIdpieza;
    }

    public void setPiezaIdpieza(Pieza piezaIdpieza) {
        this.piezaIdpieza = piezaIdpieza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpartepieza != null ? idpartepieza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partepieza)) {
            return false;
        }
        Partepieza other = (Partepieza) object;
        if ((this.idpartepieza == null && other.idpartepieza != null) || (this.idpartepieza != null && !this.idpartepieza.equals(other.idpartepieza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Partepieza[ idpartepieza=" + idpartepieza + " ]";
    }
    
}
