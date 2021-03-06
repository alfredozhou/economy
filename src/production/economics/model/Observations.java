//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.10 at 03:33:45 PM EDT 
//


package economics.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}observation" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="count" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="file_type" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="limit" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="observation_end" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="observation_start" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="offset" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="order_by" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="output_type" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="realtime_end" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="realtime_start" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="sort_order" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="units" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "observation"
})
@XmlRootElement(name = "observations")
public class Observations {

    @XmlElement(required = true)
    protected List<Observation> observation;
    @XmlAttribute(name = "count", required = true)
    protected BigInteger count;
    @XmlAttribute(name = "file_type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String fileType;
    @XmlAttribute(name = "limit", required = true)
    protected BigInteger limit;
    @XmlAttribute(name = "observation_end", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String observationEnd;
    @XmlAttribute(name = "observation_start", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String observationStart;
    @XmlAttribute(name = "offset", required = true)
    protected BigInteger offset;
    @XmlAttribute(name = "order_by", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String orderBy;
    @XmlAttribute(name = "output_type", required = true)
    protected BigInteger outputType;
    @XmlAttribute(name = "realtime_end", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String realtimeEnd;
    @XmlAttribute(name = "realtime_start", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String realtimeStart;
    @XmlAttribute(name = "sort_order", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String sortOrder;
    @XmlAttribute(name = "units", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String units;

    /**
     * Gets the value of the observation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the observation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObservation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Observation }
     * 
     * 
     */
    public List<Observation> getObservation() {
        if (observation == null) {
            observation = new ArrayList<Observation>();
        }
        return this.observation;
    }

    /**
     * Gets the value of the count property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCount(BigInteger value) {
        this.count = value;
    }

    /**
     * Gets the value of the fileType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * Sets the value of the fileType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileType(String value) {
        this.fileType = value;
    }

    /**
     * Gets the value of the limit property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLimit() {
        return limit;
    }

    /**
     * Sets the value of the limit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLimit(BigInteger value) {
        this.limit = value;
    }

    /**
     * Gets the value of the observationEnd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservationEnd() {
        return observationEnd;
    }

    /**
     * Sets the value of the observationEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservationEnd(String value) {
        this.observationEnd = value;
    }

    /**
     * Gets the value of the observationStart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservationStart() {
        return observationStart;
    }

    /**
     * Sets the value of the observationStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservationStart(String value) {
        this.observationStart = value;
    }

    /**
     * Gets the value of the offset property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOffset() {
        return offset;
    }

    /**
     * Sets the value of the offset property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOffset(BigInteger value) {
        this.offset = value;
    }

    /**
     * Gets the value of the orderBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * Sets the value of the orderBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderBy(String value) {
        this.orderBy = value;
    }

    /**
     * Gets the value of the outputType property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOutputType() {
        return outputType;
    }

    /**
     * Sets the value of the outputType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOutputType(BigInteger value) {
        this.outputType = value;
    }

    /**
     * Gets the value of the realtimeEnd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRealtimeEnd() {
        return realtimeEnd;
    }

    /**
     * Sets the value of the realtimeEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRealtimeEnd(String value) {
        this.realtimeEnd = value;
    }

    /**
     * Gets the value of the realtimeStart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRealtimeStart() {
        return realtimeStart;
    }

    /**
     * Sets the value of the realtimeStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRealtimeStart(String value) {
        this.realtimeStart = value;
    }

    /**
     * Gets the value of the sortOrder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortOrder() {
        return sortOrder;
    }

    /**
     * Sets the value of the sortOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortOrder(String value) {
        this.sortOrder = value;
    }

    /**
     * Gets the value of the units property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnits() {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnits(String value) {
        this.units = value;
    }

}
