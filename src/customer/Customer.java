package customer;

public class Customer {
  private Cart cart;
  private Payment payment;

  public Customer(Cart cart, Payment payment) {
    this.cart = cart;
    this.payment = payment;
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

  public void clearCart(){
    this.cart.clearCart();
  }
}
