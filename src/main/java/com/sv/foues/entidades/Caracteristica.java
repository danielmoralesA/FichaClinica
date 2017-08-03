package com.sv.foues.entidades;

import java.io.Serializable;

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


@Entity
@Table(name = "caracteristica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caracteristica.findAll", query = "SELECT c FROM Caracteristica c")
    , @NamedQuery(name = "Caracteristica.findById", query = "SELECT c FROM Caracteristica c WHERE c.id = :id")
    , @NamedQuery(name = "Caracteristica.findByIdpieza", query = "SELECT c FROM Caracteristica c WHERE c.idpieza = :idpieza")
    , @NamedQuery(name = "Caracteristica.findByIdsuperficie", query = "SELECT c FROM Caracteristica c WHERE c.idsuperficie = :idsuperficie")
    , @NamedQuery(name = "Caracteristica.findByIdestado", query = "SELECT c FROM Caracteristica c WHERE c.idestado = :idestado")})
public class Caracteristica implements Serializable{

	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "id", nullable = false)
	    private Integer id;
	    @Column(name = "idpieza")
	    private Integer idpieza;
	    @Column(name = "idsuperficie")
	    private Integer idsuperficie;
	    @Column(name = "idestado")
	    private Integer idestado;
	    @JoinColumn(name = "odontograma_id", referencedColumnName = "id")
	    @ManyToOne
	    private Odontograma odontogramaId;

	    public Caracteristica() {
	    }

	    public Caracteristica(Integer id) {
	        this.id = id;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public Integer getIdpieza() {
	        return idpieza;
	    }

	    public void setIdpieza(Integer idpieza) {
	        this.idpieza = idpieza;
	    }

	    public Integer getIdsuperficie() {
	        return idsuperficie;
	    }

	    public void setIdsuperficie(Integer idsuperficie) {
	        this.idsuperficie = idsuperficie;
	    }

	    public Integer getIdestado() {
	        return idestado;
	    }

	    public void setIdestado(Integer idestado) {
	        this.idestado = idestado;
	    }

	    public Odontograma getOdontogramaId() {
	        return odontogramaId;
	    }

	    public void setOdontogramaId(Odontograma odontogramaId) {
	        this.odontogramaId = odontogramaId;
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
	        if (!(object instanceof Caracteristica)) {
	            return false;
	        }
	        Caracteristica other = (Caracteristica) object;
	        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "com.sv.foues.entidades.Caracteristica[ id=" + id + " ]";
	    }
	
}
