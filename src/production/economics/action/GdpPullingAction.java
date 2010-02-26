package economics.action;

import economics.controller.MessagePuller;
import economics.model.Observations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;


public class GdpPullingAction extends SimpleFormController {
    private MessagePuller puller;

    private String responseFromFed;

    @Autowired
    public GdpPullingAction(MessagePuller messagePuller) {
        puller = messagePuller;
    }

    @Override
    protected void doSubmitAction(Object command) throws Exception {
       responseFromFed = puller.pullMessageFromFed();
    }

    public String getResponseFromFed() {
        return responseFromFed;
    }
}
