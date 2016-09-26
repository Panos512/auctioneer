


package com.oxMappers;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "category",
    "currently",
    "buyPrice",
    "firstBid",
    "numberOfBids",
    "bids",
    "location",
    "country",
    "started",
    "ends",
    "seller",
    "description"
})
@XmlRootElement(name = "Item")
public class ItemJax {

    @XmlAttribute(name = "ItemID", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String itemID;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Category", required = true)
    protected List<CategoryJax> category;
    @XmlElement(name = "Currently", required = true)
    protected String currently;
    @XmlElement(name = "Buy_Price")
    protected String buyPrice;
    @XmlElement(name = "First_Bid", required = true)
    protected String firstBid;
    @XmlElement(name = "Number_of_Bids", required = true)
    protected String numberOfBids;
    @XmlElement(name = "Bids", required = true)
    protected BidsJax bids;
    @XmlElement(name = "Location", required = true)
    protected LocationJax location;
    @XmlElement(name = "Country", required = true)
    protected String country;
    @XmlElement(name = "Started", required = true)
    protected String started;
    @XmlElement(name = "Ends", required = true)
    protected String ends;
    @XmlElement(name = "Seller", required = true)
    protected SellerJax seller;
    @XmlElement(name = "Description", required = true)
    protected String description;

    /**
     * Gets the value of the itemID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * Sets the value of the itemID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemID(String value) {
        this.itemID = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the category property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CategoryJax }
     * 
     * 
     */
    public List<CategoryJax> getCategory() {
        if (category == null) {
            category = new ArrayList<CategoryJax>();
        }
        return this.category;
    }

    /**
     * Gets the value of the currently property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrently() {
        return currently;
    }

    /**
     * Sets the value of the currently property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrently(String value) {
        this.currently = value;
    }

    /**
     * Gets the value of the buyPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyPrice() {
        return buyPrice;
    }

    /**
     * Sets the value of the buyPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyPrice(String value) {
        this.buyPrice = value;
    }

    /**
     * Gets the value of the firstBid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstBid() {
        return firstBid;
    }

    /**
     * Sets the value of the firstBid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstBid(String value) {
        this.firstBid = value;
    }

    /**
     * Gets the value of the numberOfBids property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfBids() {
        return numberOfBids;
    }

    /**
     * Sets the value of the numberOfBids property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfBids(String value) {
        this.numberOfBids = value;
    }

    /**
     * Gets the value of the bids property.
     * 
     * @return
     *     possible object is
     *     {@link BidsJax }
     *     
     */
    public BidsJax getBids() {
        return bids;
    }

    /**
     * Sets the value of the bids property.
     * 
     * @param value
     *     allowed object is
     *     {@link BidsJax }
     *     
     */
    public void setBids(BidsJax value) {
        this.bids = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link LocationJax }
     *     
     */
    public LocationJax getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationJax }
     *     
     */
    public void setLocation(LocationJax value) {
        this.location = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the started property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStarted() {
        return started;
    }

    /**
     * Sets the value of the started property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStarted(String value) {
        this.started = value;
    }

    /**
     * Gets the value of the ends property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnds() {
        return ends;
    }

    /**
     * Sets the value of the ends property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnds(String value) {
        this.ends = value;
    }

    /**
     * Gets the value of the seller property.
     * 
     * @return
     *     possible object is
     *     {@link SellerJax }
     *     
     */
    public SellerJax getSeller() {
        return seller;
    }

    /**
     * Sets the value of the seller property.
     * 
     * @param value
     *     allowed object is
     *     {@link SellerJax }
     *     
     */
    public void setSeller(SellerJax value) {
        this.seller = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
