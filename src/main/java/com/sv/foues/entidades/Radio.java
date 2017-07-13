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
@Table(name = "radio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Radio.findAll", query = "SELECT r FROM Radio r")
    , @NamedQuery(name = "Radio.findById", query = "SELECT r FROM Radio r WHERE r.id = :id")
    , @NamedQuery(name = "Radio.findByPieza", query = "SELECT r FROM Radio r WHERE r.pieza = :pieza")
    , @NamedQuery(name = "Radio.findByParte", query = "SELECT r FROM Radio r WHERE r.parte = :parte")})
public class Radio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "pieza")
    private Integer pieza;
    @Column(name = "parte")
    private Integer parte;
    @JoinColumn(name = "hallazgos_radio_idhalla", referencedColumnName = "idhalla", nullable = false)
    @ManyToOne(optional = false)
    private HallazgosRadio hallazgosRadioIdhalla;

    public Radio() {
    }

    public Radio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPieza() {
        return pieza;
    }

    public void setPieza(Integer pieza) {
        this.pieza = pieza;
    }

    public Integer getParte() {
        return parte;
    }

    public void setParte(Integer parte) {
        this.parte = parte;
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
        if (!(object instanceof Radio)) {
            return false;
        }
        Radio other = (Radio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Radio[ id=" + id + " ]";
    }
    
}
