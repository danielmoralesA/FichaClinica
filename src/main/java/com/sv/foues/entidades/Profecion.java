/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.foues.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "profecion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profecion.findAll", query = "SELECT p FROM Profecion p")
    , @NamedQuery(name = "Profecion.findByIdprofecion", query = "SELECT p FROM Profecion p WHERE p.idprofecion = :idprofecion")
    , @NamedQuery(name = "Profecion.findByNombreprofesion", query = "SELECT p FROM Profecion p WHERE p.nombreprofesion = :nombreprofesion")})
public class Profecion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprofecion", nullable = false)
    private Integer idprofecion;
    @Column(name = "nombreprofesion", length = 45)
    private String nombreprofesion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profecionIdprofecion")
    private Collection<Paciente> pacienteCollection;

    public Profecion() {
    }

    public Profecion(Integer idprofecion) {
        this.idprofecion = idprofecion;
    }

    public Integer getIdprofecion() {
        return idprofecion;
    }

    public void setIdprofecion(Integer idprofecion) {
        this.idprofecion = idprofecion;
    }

    public String getNombreprofesion() {
        return nombreprofesion;
    }

    public void setNombreprofesion(String nombreprofesion) {
        this.nombreprofesion = nombreprofesion;
    }

    @XmlTransient
    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofecion != null ? idprofecion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profecion)) {
            return false;
        }
        Profecion other = (Profecion) object;
        if ((this.idprofecion == null && other.idprofecion != null) || (this.idprofecion != null && !this.idprofecion.equals(other.idprofecion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Profecion[ idprofecion=" + idprofecion + " ]";
    }
    
}
