/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trpo_kp.tables;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "WARROW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Warrow.findAll", query = "SELECT w FROM Warrow w"),
    @NamedQuery(name = "Warrow.findById1", query = "SELECT w FROM Warrow w WHERE w.id1 = :id1"),
    @NamedQuery(name = "Warrow.findByRowId", query = "SELECT w FROM Warrow w WHERE w.rowId = :rowId"),
    @NamedQuery(name = "Warrow.findByRownumber", query = "SELECT w FROM Warrow w WHERE w.rownumber = :rownumber"),
    @NamedQuery(name = "Warrow.findById", query = "SELECT w FROM Warrow w WHERE w.id = :id"),
    @NamedQuery(name = "Warrow.findByProductId", query = "SELECT w FROM Warrow w WHERE w.productId = :productId"),
    @NamedQuery(name = "Warrow.findByBillId", query = "SELECT w FROM Warrow w WHERE w.billId = :billId"),
    @NamedQuery(name = "Warrow.findByWarId", query = "SELECT w FROM Warrow w WHERE w.warId = :warId"),
    @NamedQuery(name = "Warrow.findByPoId", query = "SELECT w FROM Warrow w WHERE w.poId = :poId"),
    @NamedQuery(name = "Warrow.findByCount", query = "SELECT w FROM Warrow w WHERE w.count = :count"),
    @NamedQuery(name = "Warrow.findByStatus", query = "SELECT w FROM Warrow w WHERE w.status = :status")})
public class Warrow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ID1")
    private BigInteger id1;
    @Basic(optional = false)
    @Column(name = "ROW_ID")
    private BigInteger rowId;
    @Column(name = "ROWNUMBER")
    private BigInteger rownumber;
    @Basic(optional = false)
    @Column(name = "ID")
    @Id
    private BigInteger id;
    @Basic(optional = false)
    @Column(name = "PRODUCT_ID")
    private BigInteger productId;
    @Basic(optional = false)
    @Column(name = "BILL_ID")
    private BigInteger billId;
    @Column(name = "WAR_ID")
    private BigInteger warId;
    @Column(name = "PO_ID")
    private BigInteger poId;
    @Basic(optional = false)
    @Column(name = "COUNT")
    private BigInteger count;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private BigInteger status;

    public Warrow() {
    }

    public BigInteger getId1() {
        return id1;
    }

    public void setId1(BigInteger id1) {
        this.id1 = id1;
    }

    public BigInteger getRowId() {
        return rowId;
    }

    public void setRowId(BigInteger rowId) {
        this.rowId = rowId;
    }

    public BigInteger getRownumber() {
        return rownumber;
    }

    public void setRownumber(BigInteger rownumber) {
        this.rownumber = rownumber;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    public BigInteger getBillId() {
        return billId;
    }

    public void setBillId(BigInteger billId) {
        this.billId = billId;
    }

    public BigInteger getWarId() {
        return warId;
    }

    public void setWarId(BigInteger warId) {
        this.warId = warId;
    }

    public BigInteger getPoId() {
        return poId;
    }

    public void setPoId(BigInteger poId) {
        this.poId = poId;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }
    
}
