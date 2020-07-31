package bg.softuni.fluxmono;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class AsyncFlux {

  @Test
  public void syncFlux() {
    MyInteger sum = new MyInteger(0);

    Flux.
        just(1,2,3,4).
        reduce(MyInteger::sum).
        subscribe(sum::set);

    System.out.println(sum);
  }

  @Test
  public void asyncFlux() {
    MyInteger sum = new MyInteger(0);

    Flux.
        just(1,2,3,4).
        subscribeOn(Schedulers.elastic()).
        reduce(MyInteger::sum).
        subscribe(sum::set);

    System.out.println(sum);
  }

}

class MyInteger {

  private Integer initialValue;

  public MyInteger(Integer initialValue) {
    this.initialValue = initialValue;
  }

  public static int sum(int a, int b) {
    System.out.println("Summing " + a + " and " + b);
    return a + b;
  }

  public void set(Integer aNumber) {
    this.initialValue = aNumber;
  }


  @Override
  public String toString() {
    return "MyInteger{" +
        "initialValue=" + initialValue +
        '}';
  }
}
