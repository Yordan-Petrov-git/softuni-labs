package bg.softuni.dropdowns;

import bg.softuni.dropdowns.model.City;
import bg.softuni.dropdowns.model.Office;
import bg.softuni.dropdowns.repository.CityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DropdownsApplicationInit implements CommandLineRunner {

  final
  CityRepository cityRepository;

  public DropdownsApplicationInit(CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    City sofia = new City().setName("Sofia");
    Office mladost = new Office().setCity(sofia).setName("Mladost");
    Office lulin = new Office().setCity(sofia).setName("Lulin");
    Office centre = new Office().setCity(sofia).setName("Centre");
    sofia.setOffices(List.of(mladost, lulin, centre));

    City plovdiv = new City().setName("Plovdiv");
    Office trakiq = new Office().setCity(plovdiv).setName("Trakiq");
    Office smirnenski = new Office().setCity(plovdiv).setName("Smirnenski");
    plovdiv.setOffices(List.of(trakiq, smirnenski));

    City varna = new City().setName("Varna");
    Office asparuhovo = new Office().setCity(varna).setName("Asparuhovo");
    Office galata = new Office().setCity(varna).setName("Galata");
    varna.setOffices(List.of(asparuhovo, galata));

    cityRepository.saveAll(List.of(sofia, plovdiv, varna));

  }
}
