package customer;

public class Card implements Payment {
  private int money = 10000;

  public void chargeMoney(int chargeValue){
    this.money += chargeValue;
  }

  public int pay(int payValue){
    if(this.money < payValue){
      System.out.println("잔액이 부족합니다");
      System.out.println("잔액은 " + this.money + "원 입니다\n충전해주세요");
      return 2;
    }
    this.money -= payValue;
    System.out.println("결제가 완료되었습니다");
    System.out.println("잔액은 " + this.money + "원 입니다");

    return 1;
  }

  @Override
  public void charge(int chargeValue) {
    this.money += chargeValue;
    System.out.println(chargeValue + "원 충전 완료되었습니다. 잔액은 " + this.money + "원 입니다");
  }

  public int getMoney() {
    return money;
  }
}
