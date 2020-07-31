package bg.softuni.reactive;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class SimpleSubscriber<T> implements Subscriber<T> {

  private List<T> consumedElements =
      new LinkedList<>();
  private Subscription subscription;

  @Override
  public void onSubscribe(Subscription subscription) {
    this.subscription = subscription;
    subscription.request(1);
  }

  @Override
  public void onNext(T item) {
    consumedElements.add(item);
    subscription.request(1);
  }

  @Override
  public void onError(Throwable throwable) {
    throwable.printStackTrace();
  }

  @Override
  public void onComplete() {
    System.out.println("I'm complete!!!!");
    consumedElements.forEach(System.out::println);
    System.out.println("----------------");

  }

  public int getConsumedElementsCount() {
    return consumedElements.size();
  }

  public List<T> getConsumedElements() {
    return consumedElements;
  }
}
