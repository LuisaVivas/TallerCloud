/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisavivas
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")
    , @NamedQuery(name = "Equipo.findByIdEquipo", query = "SELECT e FROM Equipo e WHERE e.idEquipo = :idEquipo")
    , @NamedQuery(name = "Equipo.findByNombre", query = "SELECT e FROM Equipo e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Equipo.findByAniofundacion", query = "SELECT e FROM Equipo e WHERE e.aniofundacion = :aniofundacion")
    , @NamedQuery(name = "Equipo.findByCantidadtitulos", query = "SELECT e FROM Equipo e WHERE e.cantidadtitulos = :cantidadtitulos")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int aniofundacion;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int cantidadtitulos;

    public Equipo() {
    }

    public Equipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipo(Integer idEquipo, String nombre, int aniofundacion, int cantidadtitulos) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.aniofundacion = aniofundacion;
        this.cantidadtitulos = cantidadtitulos;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAniofundacion() {
        return aniofundacion;
    }

    public void setAniofundacion(int aniofundacion) {
        this.aniofundacion = aniofundacion;
    }

    public int getCantidadtitulos() {
        return cantidadtitulos;
    }

    public void setCantidadtitulos(int cantidadtitulos) {
        this.cantidadtitulos = cantidadtitulos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Equipo[ idEquipo=" + idEquipo + " ]";
    }
    
}
