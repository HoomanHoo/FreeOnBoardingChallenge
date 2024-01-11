package customer;

public class Card implements Payment {
  private int money = 10000;

  public void chargeMoney(int chargeValue){
    this.money += chargeValue;
  }

  public int pay(int payValue){
    if(this.money < payValue){
      System.out.println("잔액이 부족합니다");
      return this.money;
    }
      System.out.println("결제가 완료되었습니다");
      return (this.money - payValue);
    }

  public int getMoney() {
    return money;
  }
}
