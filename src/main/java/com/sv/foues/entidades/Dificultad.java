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
@Table(name = "dificultad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dificultad.findAll", query = "SELECT d FROM Dificultad d")
    , @NamedQuery(name = "Dificultad.findById", query = "SELECT d FROM Dificultad d WHERE d.id = :id")
    , @NamedQuery(name = "Dificultad.findByVariacion", query = "SELECT d FROM Dificultad d WHERE d.variacion = :variacion")})
public class Dificultad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "variacion", length = 10)
    private String variacion;
    @JoinColumn(name = "hallazgos_radio_idhalla", referencedColumnName = "idhalla", nullable = false)
    @ManyToOne(optional = false)
    private HallazgosRadio hallazgosRadioIdhalla;

    public Dificultad() {
    }

    public Dificultad(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVariacion() {
        return variacion;
    }

    public void setVariacion(String variacion) {
        this.variacion = variacion;
    }

    public HallazgosRadio getHallazgosRadioIdhalla() {
        return hallazgosRadioIdhalla;
    }

    public void setHallazgosRadioIdhalla(HallazgosRadio hallazgosRadioIdhalla) {
        this.hallazgosRadioIdhalla = hallazgosRadioIdhalla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dificultad)) {
            return false;
        }
        Dificultad other = (Dificultad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Dificultad[ id=" + id + " ]";
    }
    
}
