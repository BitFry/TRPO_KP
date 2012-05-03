/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trpo_kp.tables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "DOCROW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docrow.findAll", query = "SELECT d FROM Docrow d"),
    @NamedQuery(name = "Docrow.findById", query = "SELECT d FROM Docrow d WHERE d.id = :id"),
    @NamedQuery(name = "Docrow.findByCount", query = "SELECT d FROM Docrow d WHERE d.count = :count"),
    @NamedQuery(name = "Docrow.findByStatus", query = "SELECT d FROM Docrow d WHERE d.status = :status")})
@SequenceGenerator(name="DocrowSeq", sequenceName="DOCROW_SEQ1", initialValue=1000, allocationSize=1)
public class Docrow implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="DocrowSeq")
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "COUNT")
    private BigInteger count;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private BigInteger status;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "rowId", fetch = FetchType.LAZY)
    private Billrownumber billrownumber;
    @JoinColumn(name = "WAR_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Warrant warId;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Product productId;
    @JoinColumn(name = "PO_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Paymentorder poId;
    @JoinColumn(name = "BILL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Bill billId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "rowId", fetch = FetchType.LAZY)
    private Warrownumber warrownumber;

    public Docrow() {
    }

    public Docrow(BigDecimal id) {
        this.id = id;
    }

    public Docrow(BigDecimal id, BigInteger count, BigInteger status) {
        this.id = id;
        this.count = count;
        this.status = status;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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

    public Billrownumber getBillrownumber() {
        return billrownumber;
    }

    public void setBillrownumber(Billrownumber billrownumber) {
        this.billrownumber = billrownumber;
    }

    public Warrant getWarId() {
        return warId;
    }

    public void setWarId(Warrant warId) {
        this.warId = warId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Paymentorder getPoId() {
        return poId;
    }

    public void setPoId(Paymentorder poId) {
        this.poId = poId;
    }

    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
    }

    public Warrownumber getWarrownumber() {
        return warrownumber;
    }

    public void setWarrownumber(Warrownumber warrownumber) {
        this.warrownumber = warrownumber;
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
        if (!(object instanceof Docrow)) {
            return false;
        }
        Docrow other = (Docrow) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trpo_kp.tables.Docrow[ id=" + id + " ]";
    }
    public double getSumIncludingTaxes(){
        long count = this.getCount().longValue();
        double price = this.getProductId().getPrice();
        double nds = this.getProductId().getNds();
        double excise = this.getProductId().getExcise();
        return (price*count + price*count*nds + price*count*excise);
    }
}
