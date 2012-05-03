/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trpo_kp.tables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByUint", query = "SELECT p FROM Product p WHERE p.uint = :uint"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByNds", query = "SELECT p FROM Product p WHERE p.nds = :nds"),
    @NamedQuery(name = "Product.findByExcise", query = "SELECT p FROM Product p WHERE p.excise = :excise")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "UINT")
    private String uint;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private double price;
    @Basic(optional = false)
    @Column(name = "NDS")
    private double nds;
    @Basic(optional = false)
    @Column(name = "EXCISE")
    private double excise;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId", fetch = FetchType.LAZY)
    private List<Docrow> docrowList;
    @JoinColumn(name = "SUP_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Agency supId;

    public Product() {
    }

    public Product(BigDecimal id) {
        this.id = id;
    }

    public Product(BigDecimal id, String name, String uint, double price, double nds, double excise) {
        this.id = id;
        this.name = name;
        this.uint = uint;
        this.price = price;
        this.nds = nds;
        this.excise = excise;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUint() {
        return uint;
    }

    public void setUint(String uint) {
        this.uint = uint;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getNds() {
        return nds;
    }

    public void setNds(double nds) {
        this.nds = nds;
    }

    public double getExcise() {
        return excise;
    }

    public void setExcise(double excise) {
        this.excise = excise;
    }

    @XmlTransient
    public List<Docrow> getDocrowList() {
        return docrowList;
    }

    public void setDocrowList(List<Docrow> docrowList) {
        this.docrowList = docrowList;
    }

    public Agency getSupId() {
        return supId;
    }

    public void setSupId(Agency supId) {
        this.supId = supId;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trpo_kp.tables.Product[ id=" + id + " ]";
    }
    
}
