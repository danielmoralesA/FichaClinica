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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "superficie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Superficie.findAll", query = "SELECT s FROM Superficie s")
    , @NamedQuery(name = "Superficie.findByIdsession", query = "SELECT s FROM Superficie s WHERE s.idsession = :idsession")
    , @NamedQuery(name = "Superficie.findByNombre", query = "SELECT s FROM Superficie s WHERE s.nombre = :nombre")})
public class Superficie implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsession", nullable = false)
    private Integer idsession;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "superficieIdsession")
    private Collection<Estado> estadoCollection;
    @JoinColumn(name = "pieza_idpieza", referencedColumnName = "idpieza", nullable = false)
    @ManyToOne(optional = false)
    private Pieza piezaIdpieza;

    public Superficie() {
    }

    public Superficie(Integer idsession) {
        this.idsession = idsession;
    }

    public Integer getIdsession() {
        return idsession;
    }

    public void setIdsession(Integer idsession) {
        this.idsession = idsession;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Estado> getEstadoCollection() {
        return estadoCollection;
    }

    public void setEstadoCollection(Collection<Estado> estadoCollection) {
        this.estadoCollection = estadoCollection;
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
        hash += (idsession != null ? idsession.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Superficie)) {
            return false;
        }
        Superficie other = (Superficie) object;
        if ((this.idsession == null && other.idsession != null) || (this.idsession != null && !this.idsession.equals(other.idsession))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.foues.entidades.Superficie[ idsession=" + idsession + " ]";
    }	
}
