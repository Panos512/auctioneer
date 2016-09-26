package com.oxMappers;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bid"
})
@XmlRootElement(name = "Bids")
public class BidsJax {

    @XmlElement(name = "Bid")
    protected List<BidJax> bid;

    /**
     * Gets the value of the bid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBid().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BidJax }
     * 
     * 
     */
    public List<BidJax> getBid() {
        if (bid == null) {
            bid = new ArrayList<BidJax>();
        }
        return this.bid;
    }

}
