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
@Table(name = "horarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horarios.findAll", query = "SELECT h FROM Horarios h")
    , @NamedQuery(name = "Horarios.findByIdhorarios", query = "SELECT h FROM Horarios h WHERE h.idhorarios = :idhorarios")
    , @NamedQuery(name = "Horarios.findByValor", query = "SELECT h FROM Horarios h WHERE h.valor = :valor")})
public class Horarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhorarios", nullable = false)
    private Integer idhorarios;
    @Column(name = "valor")
    private Integer valor;
    @JoinColumn(name = "FichaClinica_idFicha", referencedColumnName = "idFicha", nullable = false)
    @ManyToOne(optional = false)
    private FichaClinica fichaClinicaidFicha;

    public Horarios() {
    }

    public Horarios(Integer idhorarios) {
        this.idhorarios = idhorarios;
    }

    public Integer getIdhorarios() {
        return idhorarios;
    }

    public void setIdhorarios(Integer idhorarios) {
        this.idhorarios = idhorarios;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public FichaClinica getFichaClinicaidFicha() {
        return fichaClinicaidFicha;
    }

    public void setFichaClinicaidFicha(FichaClinica fichaClinicaidFicha) {
        this.fichaClinicaidFicha = fichaClinicaidFicha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhorarios != null ? idhorarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horarios)) {
            return false;
        }
        Horarios other = (Horarios) object;
        if ((this.idhorarios == null && other.idhorarios != null) || (this.idhorarios != null && !this.idhorarios.equals(other.idhorarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Horarios[ idhorarios=" + idhorarios + " ]";
    }
    
}
