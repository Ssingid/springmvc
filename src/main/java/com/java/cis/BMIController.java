package com.java.cis;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BMIController {

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String input(Locale locale, Model model) {
        System.out.println("Home Page Requested, locale = " + locale);
        return "input";
    }
    @RequestMapping(value = "/bmi", method = RequestMethod.POST)
    public String result(@RequestParam("height") double heightInInches,
                         @RequestParam("weight") double weightInPounds,
                         Model model) {
        double bmi = weightInPounds / (heightInInches * heightInInches) * 703;
        model.addAttribute("bmi", bmi);
        return "result";
    }

    @RestController
    public static class BMIRestController {
        @RequestMapping(value = "/bmi2", method = RequestMethod.POST)
        public String getBMI(@RequestParam("height") double height,
                             @RequestParam("weight") double weight) {
            double bmiCalculator = (double) Math.round((weight / (height * height) * 703) * 100) / 100;
            System.out.println(bmiCalculator);
            return "bmi value is: " + bmiCalculator;
        }
    }
}


// Dispatcher Servlet
// View Resolver
// mvc