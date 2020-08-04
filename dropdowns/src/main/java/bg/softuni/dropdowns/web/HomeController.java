package bg.softuni.dropdowns.web;

import bg.softuni.dropdowns.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @Autowired
  private CityRepository cityRepository;

  @GetMapping("/")
  public String home(Model model) {

    model.addAttribute("cities",
        cityRepository.findAll());

    return "index/index";
  }
}
