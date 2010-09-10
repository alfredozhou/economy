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
   public ModelAndView performAction() throws IOException {
      DateTime today = new DateTime();
      DateTime lastYear = today.minusYears(1);
      ModelAndView modelAndView = new ModelAndView("calculation");
      modelAndView.addObject("value", ingredients.calculate(lastYear));
      modelAndView.addObject("year", lastYear);
      return modelAndView;
   }

}
