package bg.softuni.rest.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="authors")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id", nullable = false, updatable = false)
  private long id;

  @Column(nullable = false)
  private String name;

  @OneToMany
  private List<Book> books = new ArrayList<>();

  public long getId() {
    return id;
  }

  public Author setId(long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Author setName(String name) {
    this.name = name;
    return this;
  }

  public List<Book> getBooks() {
    return books;
  }

  public Author setBooks(List<Book> books) {
    this.books = books;
    return this;
  }
}
