package economics.action;

import economics.controller.MessagePuller;
import economics.dependencies.XmlToGdpUnmarshaller;
import economics.model.Observations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.velocity.VelocityView;

import java.io.IOException;


@Controller
public class GdpPullingAction {
    private MessagePuller messagePuller;
    private XmlToGdpUnmarshaller xmlToObjectsConverter;

    @Autowired
    public GdpPullingAction(MessagePuller messagePuller, XmlToGdpUnmarshaller xmlToObjectsConverter) {
        this.messagePuller = messagePuller;
        this.xmlToObjectsConverter = xmlToObjectsConverter;
    }

    @RequestMapping("/gdp")
    public ModelAndView performAction() throws IOException {
       return new ModelAndView("gdp").addObject(getGDPDataFromFed());
    }

    public Observations getGDPDataFromFed() throws IOException {
        String xmlFromFed = messagePuller.pullMessageFromFed();
        return xmlToObjectsConverter.convertGdpFromXmlToObject(xmlFromFed);
    }
}
