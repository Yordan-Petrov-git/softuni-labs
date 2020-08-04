package bg.softuni.dropdowns.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cities")
public class City {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, updatable = false)
  private long id;

  @Column(nullable = false)
  private String name;

  @JsonIgnore
  @OneToMany(mappedBy = "city",
      cascade = CascadeType.ALL,
      fetch = FetchType.EAGER)
  private List<Office> offices = new ArrayList<>();

  public long getId() {
    return id;
  }

  public City setId(long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public City setName(String name) {
    this.name = name;
    return this;
  }

  public List<Office> getOffices() {
    return offices;
  }

  public City setOffices(List<Office> offices) {
    this.offices = offices;
    return this;
  }
}
