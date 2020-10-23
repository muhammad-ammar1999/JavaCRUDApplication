 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrudapplication;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author muhammadammar
 */
@Entity
@Table(name = "stock", catalog = "Inventory", schema = "")
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findById", query = "SELECT s FROM Stock s WHERE s.id = :id"),
    @NamedQuery(name = "Stock.findByQuantity", query = "SELECT s FROM Stock s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "Stock.findByPurchasingprice", query = "SELECT s FROM Stock s WHERE s.purchasingprice = :purchasingprice"),
    @NamedQuery(name = "Stock.findBySallingprice", query = "SELECT s FROM Stock s WHERE s.sallingprice = :sallingprice"),
    @NamedQuery(name = "Stock.findByDate", query = "SELECT s FROM Stock s WHERE s.date = :date"),
    @NamedQuery(name = "Stock.findByOutletid", query = "SELECT s FROM Stock s WHERE s.outletid = :outletid")})
public class Stock implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "itemdetails")
    private String itemdetails;
    @Column(name = "quantity")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "purchasingprice")
    private Double purchasingprice;
    @Column(name = "sallingprice")
    private Double sallingprice;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "outletid")
    @Temporal(TemporalType.TIME)
    private Date outletid;

    public Stock() {
    }

    public Stock(Integer id) {
        this.id = id;
    }

    public Stock(Integer id, Date outletid) {
        this.id = id;
        this.outletid = outletid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getItemdetails() {
        return itemdetails;
    }

    public void setItemdetails(String itemdetails) {
        String oldItemdetails = this.itemdetails;
        this.itemdetails = itemdetails;
        changeSupport.firePropertyChange("itemdetails", oldItemdetails, itemdetails);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        Integer oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public Double getPurchasingprice() {
        return purchasingprice;
    }

    public void setPurchasingprice(Double purchasingprice) {
        Double oldPurchasingprice = this.purchasingprice;
        this.purchasingprice = purchasingprice;
        changeSupport.firePropertyChange("purchasingprice", oldPurchasingprice, purchasingprice);
    }

    public Double getSallingprice() {
        return sallingprice;
    }

    public void setSallingprice(Double sallingprice) {
        Double oldSallingprice = this.sallingprice;
        this.sallingprice = sallingprice;
        changeSupport.firePropertyChange("sallingprice", oldSallingprice, sallingprice);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Date oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public Date getOutletid() {
        return outletid;
    }

    public void setOutletid(Date outletid) {
        Date oldOutletid = this.outletid;
        this.outletid = outletid;
        changeSupport.firePropertyChange("outletid", oldOutletid, outletid);
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
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javacrudapplication.Stock[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
