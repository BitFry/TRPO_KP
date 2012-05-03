/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trpo_kp.tables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "WARROWNUMBER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Warrownumber.findAll", query = "SELECT w FROM Warrownumber w"),
    @NamedQuery(name = "Warrownumber.findById", query = "SELECT w FROM Warrownumber w WHERE w.id = :id"),
    @NamedQuery(name = "Warrownumber.findByRownumber", query = "SELECT w FROM Warrownumber w WHERE w.rownumber = :rownumber")})
@SequenceGenerator(name="WarrownumberSeq", sequenceName="WARROWNUMBER_SEQ", initialValue=1000, allocationSize=1)
public class Warrownumber implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="WarrownumberSeq")
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "ROWNUMBER")
    private BigInteger rownumber;
    @JoinColumn(name = "ROW_ID", referencedColumnName = "ID")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Docrow rowId;

    public Warrownumber() {
    }

    public Warrownumber(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getRownumber() {
        return rownumber;
    }

    public void setRownumber(BigInteger rownumber) {
        this.rownumber = rownumber;
    }

    public Docrow getRowId() {
        return rowId;
    }

    public void setRowId(Docrow rowId) {
        this.rowId = rowId;
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
        if (!(object instanceof Warrownumber)) {
            return false;
        }
        Warrownumber other = (Warrownumber) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trpo_kp.tables.Warrownumber[ id=" + id + " ]";
    }
    
}
