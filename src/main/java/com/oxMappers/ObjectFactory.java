


package com.oxMappers;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.examples package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.examples
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BidderJax }
     * 
     */
    public BidderJax createBidder() {
        return new BidderJax();
    }

    /**
     * Create an instance of {@link LocationJax }
     * 
     */
    public LocationJax createLocation() {
        return new LocationJax();
    }

    /**
     * Create an instance of {@link CategoryJax }
     * 
     */
    public CategoryJax createCategory() {
        return new CategoryJax();
    }

    /**
     * Create an instance of {@link BidsJax }
     * 
     */
    public BidsJax createBids() {
        return new BidsJax();
    }

    /**
     * Create an instance of {@link BidJax }
     * 
     */
    public BidJax createBid() {
        return new BidJax();
    }

    /**
     * Create an instance of {@link ItemJax }
     * 
     */
    public ItemJax createItem() {
        return new ItemJax();
    }

    /**
     * Create an instance of {@link SellerJax }
     * 
     */
    public SellerJax createSeller() {
        return new SellerJax();
    }

    /**
     * Create an instance of {@link ItemsJax }
     * 
     */
    public ItemsJax createItems() {
        return new ItemsJax();
    }

}
