package economics.action;

import economics.controller.*;
import economics.dependencies.XmlToGdpUnmarshaller;
import economics.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.velocity.VelocityView;

import java.io.IOException;
import java.util.*;


@Controller
public class GdpPullingAction {
   private GDPRepository repository;

   @Autowired
    public GdpPullingAction(GDPRepository repository) {
      this.repository = repository;
    }

    @RequestMapping("/gdp")
    public ModelAndView performAction() throws IOException {
       return new ModelAndView("gdp").addObject("observations", getGDPDataFromFed());
    }

    public List<Observation> getGDPDataFromFed() throws IOException {
       return repository.getGdpFromDb();
    }
}
