package com.sv.foues.entidades;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.sv.foues.entidades.Roles;

@Entity
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r")
    , @NamedQuery(name = "Roles.findByIdRol", query = "SELECT r FROM Roles r WHERE r.idRol = :idRol")
    , @NamedQuery(name = "Roles.findByNomRol", query = "SELECT r FROM Roles r WHERE r.nomRol = :nomRol")})

public class Roles implements Serializable{
	  private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "idRol")
	    private Integer idRol;
	    @Column(name = "nomRol")	
	    private String nomRol;

	    public Roles() {
	    }

	    public Roles(Integer idRol) {
	        this.idRol = idRol;
	    }

	    public void setIdRol(Integer IdROl){
	    	this.idRol=idRol;
	    }
	    public Integer getIdRol() {
	        return idRol;
	    }

	    /*public void setIdRol(Integer idRol) {
	        this.idRol = idRol;
	    }*/	

	    public String getNomRol() {
	        return nomRol;
	    }

	    public void setNomRol(String nomRol) {
	        this.nomRol = nomRol;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (idRol != null ? idRol.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Roles)) {
	            return false;
	        }
	        Roles other = (Roles) object;
	        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "com.sv.foues.entidades.Roles[ idRol=" + idRol + " ]";
	    }

}
