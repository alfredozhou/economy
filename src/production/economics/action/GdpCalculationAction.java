package economics.action;

import economics.dependencies.*;
import org.joda.time.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.io.*;

/**
 * Date: Sep 10, 2010
 * Time: 1:19:13 PM
 */
@Controller
public class GdpCalculationAction {
   private GdpIngredients ingredients;

   @Autowired
   public GdpCalculationAction(GdpIngredients ingredients) {
      this.ingredients = ingredients;
   }

   @RequestMapping("/calculate")
   public ModelAndView performAction(String dateWanted) throws IOException {
      DateTime dateTime = gdpTimeWanted(dateWanted);
      ModelAndView modelAndView = new ModelAndView("calculation");
      modelAndView.addObject("year", dateTime);
      modelAndView.addObject("gdpComponent", ingredients.get(dateTime));
      return modelAndView;
   }

   private DateTime gdpTimeWanted(String dateWanted) {
      if (dateWanted == null) {
         DateTime today = new DateTime();
         return today.minusYears(1);
      }
      return new DateTime(dateWanted);
   }

}
