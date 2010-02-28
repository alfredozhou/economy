package economics.dependencies;

import economics.model.Observations;
import org.springframework.stereotype.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Repository
public class XmlToGdpUnmarshaller {
    private Unmarshaller unmarshaller;

    public XmlToGdpUnmarshaller() {
        init();
    }

    private void init() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance("economics.model");
            unmarshaller = jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public Observations convertGdpFromXmlToObject(String gdpXml) {
        try {
            return (Observations) unmarshaller.unmarshal(new StringReader(gdpXml));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
