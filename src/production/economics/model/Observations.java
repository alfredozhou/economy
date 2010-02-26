//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.01.20 at 04:06:53 AM GMT 
//


package economics.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element ref="{}realtime_start"/>
 *         &lt;element ref="{}realtime_end"/>
 *         &lt;element ref="{}observation_start"/>
 *         &lt;element ref="{}observation_end"/>
 *         &lt;element ref="{}units"/>
 *         &lt;element ref="{}output_type"/>
 *         &lt;element ref="{}file_type"/>
 *         &lt;element ref="{}order_by"/>
 *         &lt;element ref="{}sort_order"/>
 *         &lt;element ref="{}count"/>
 *         &lt;element ref="{}limit"/>
 *         &lt;element ref="{}offset"/>
 *         &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{}observation"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "realtimeStart",
    "realtimeEnd",
    "observationStart",
    "observationEnd",
    "units",
    "outputType",
    "fileType",
    "orderBy",
    "sortOrder",
    "count",
    "limit",
    "offset",
    "observation"
})
@XmlRootElement(name = "observations")
public class Observations {

    @XmlElement(name = "realtime_start", required = true)
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar realtimeStart;
    @XmlElement(name = "realtime_end", required = true)
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar realtimeEnd;
    @XmlElement(name = "observation_start", required = true)
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar observationStart;
    @XmlElement(name = "observation_end", required = true)
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar observationEnd;
    @XmlElement(required = true)
    private String units;
    @XmlElement(name = "output_type", required = true)
    private String outputType;
    @XmlElement(name = "file_type", required = true)
    private String fileType;
    @XmlElement(name = "order_by", required = true)
    private String orderBy;
    @XmlElement(name = "sort_order", required = true)
    private String sortOrder;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    private BigInteger count;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    private BigInteger limit;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    private BigInteger offset;
    private List<Observation> observation;

    /**
     * Gets the value of the realtimeStart property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRealtimeStart() {
        return realtimeStart;
    }

    /**
     * Sets the value of the realtimeStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRealtimeStart(XMLGregorianCalendar value) {
        this.realtimeStart = value;
    }

    /**
     * Gets the value of the realtimeEnd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRealtimeEnd() {
        return realtimeEnd;
    }

    /**
     * Sets the value of the realtimeEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRealtimeEnd(XMLGregorianCalendar value) {
        this.realtimeEnd = value;
    }

    /**
     * Gets the value of the observationStart property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getObservationStart() {
        return observationStart;
    }

    /**
     * Sets the value of the observationStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setObservationStart(XMLGregorianCalendar value) {
        this.observationStart = value;
    }

    /**
     * Gets the value of the observationEnd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getObservationEnd() {
        return observationEnd;
    }

    /**
     * Sets the value of the observationEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setObservationEnd(XMLGregorianCalendar value) {
        this.observationEnd = value;
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

    /**
     * Gets the value of the outputType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputType() {
        return outputType;
    }

    /**
     * Sets the value of the outputType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputType(String value) {
        this.outputType = value;
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

    @Override
    public String toString() {
        return getObservation().toString();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
