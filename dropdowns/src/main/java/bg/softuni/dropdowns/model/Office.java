package bg.softuni.dropdowns.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="offices")
public class Office {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, updatable = false)
  private Long id;

  @Column(nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name="city_id", nullable=false)
  private City city;

  public Long getId() {
    return id;
  }

  public Office setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Office setName(String name) {
    this.name = name;
    return this;
  }

  public City getCity() {
    return city;
  }

  public Office setCity(City city) {
    this.city = city;
    return this;
  }
}
