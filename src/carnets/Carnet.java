/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package carnets;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author chuda
 */
@Entity
@Table(name = "carnet", catalog = "cranet", schema = "")
@NamedQueries({@NamedQuery(name = "Carnet.findAll", query = "SELECT c FROM Carnet c"), @NamedQuery(name = "Carnet.findByDepartamento", query = "SELECT c FROM Carnet c WHERE c.departamento = :departamento"), @NamedQuery(name = "Carnet.findByNombre", query = "SELECT c FROM Carnet c WHERE c.nombre = :nombre"), @NamedQuery(name = "Carnet.findByApellido", query = "SELECT c FROM Carnet c WHERE c.apellido = :apellido"), @NamedQuery(name = "Carnet.findByCedula", query = "SELECT c FROM Carnet c WHERE c.cedula = :cedula")})
public class Carnet implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "departamento")
    private String departamento;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Id
    @Basic(optional = false)
    @Column(name = "cedula")
    private String cedula;

    public Carnet() {
    }

    public Carnet(String cedula) {
        this.cedula = cedula;
    }

    public Carnet(String cedula, String departamento, String nombre, String apellido) {
        this.cedula = cedula;
        this.departamento = departamento;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        String oldDepartamento = this.departamento;
        this.departamento = departamento;
        changeSupport.firePropertyChange("departamento", oldDepartamento, departamento);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        String oldApellido = this.apellido;
        this.apellido = apellido;
        changeSupport.firePropertyChange("apellido", oldApellido, apellido);
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        String oldCedula = this.cedula;
        this.cedula = cedula;
        changeSupport.firePropertyChange("cedula", oldCedula, cedula);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carnet)) {
            return false;
        }
        Carnet other = (Carnet) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carnets.Carnet[cedula=" + cedula + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
