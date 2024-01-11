package customer;

public class Customer {
  private Cart cart;
  private Payment payment;

  public Customer(Cart cart) {
    this.cart = cart;
  }

  public Cart getCart() {
    return cart;
  }

  public Payment getPayment() {
    return payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }
}
