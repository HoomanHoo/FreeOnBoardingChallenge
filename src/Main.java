import customer.Card;
import customer.Cart;
import customer.Customer;
import items.Coffee;
import items.Bread;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Customer customer = new Customer(new Cart());
    Mart mart = new Mart();

    while (true){
      System.out.println("결제 수단을 선택해주세요");
      System.out.println("1: 카드");
      System.out.println("0: 나가기");

      int paymentCode = 0;
      try{
        paymentCode = scanner.nextInt();
      } catch(Exception e){
        System.out.println(e);
        scanner.nextLine();
        continue;
      }
      if(paymentCode == 1){
        customer.setPayment(new Card());
        System.out.println("카드를 결제 수단으로 선택하였습니다\n");
        System.out.println("현재 잔액은 " + customer.getPayment().getMoney() + "원 입니다");
        break;
      }
      else if(paymentCode == 0){
        System.out.println("방문해주셔서 감사합니다");
        return;
      }
    }


    
    while(true) {
      System.out.println("장바구니에 담을 물건을 선택해주세요");
      System.out.println("0: 장바구니 목록 확인");
      System.out.println("-1: 결제하기");
      System.out.println("-2: 나가기");
      System.out.println("-3: 카드 충전하기");
      System.out.println("1: 아메리카노");
      System.out.println("2: 빵");

      int itemCode = 0;
      try {
        itemCode = scanner.nextInt();
      } catch (Exception e){
        System.out.println(e);
        continue;
      }
      // 아메리카노 선택
      if(itemCode == 1){
        customer.getCart().insertCart("Americano", new Coffee());
      }
      // 볼펜 선택
      else if (itemCode == 2) {
        customer.getCart().insertCart("Bread",new Bread());
      }
      // 장바구니 확인
      else if (itemCode == 0) {
        System.out.println(customer.getCart().toString());
      }
      // 결제하기
      else if (itemCode == -1) {

        int paymentValue = mart.calc(customer.getCart());
        
        System.out.println("총 결제 금액은 " + paymentValue + "원 입니다\n결제 하시겠습니까?");
        while(true){
          System.out.println("1: 결제");
          System.out.println("2: 취소");
          int payCode = 0;
          try {
            payCode = scanner.nextInt();
          } catch (Exception e){
            System.out.println(e);
            continue;
          }
          if(payCode == 1){
            int balance = customer.getPayment().pay(paymentValue);
            if(balance >= 0) {
              System.out.println("잔액은 " + balance + "원 입니다");
              break;
            }
            else {
              System.out.println("잔액은 " + balance + "원 입니다\n충전해주세요");
              break;
            }
          }
        }

        break;
      }
      // 카드 충전하기
      else if(itemCode == -3){
        break;
      }

      // 나가기
      else if (itemCode == -2) {
        System.out.println("방문해주셔서 감사합니다");
        return;
      }
      // 입력 오류
      else {
        System.out.println("정확한 상품 코드를 입력해주세요");
      }
    }
  }
}
/*
마트 계산 시스템

마트 계산 프로세스
- 고객이 상품을 카트에 담는다.
- 마트오너는 계산하기 전 지불 정보를 만든다.
- 고객은 지불 정보를 바탕으로 결제한다.(결제 수단은 오직 카드뿐이다.)

가이드
1. 마트 계산 시스템을 구성하는 메세지는 무엇일까?
2. 마트 계산 시스템에는 어떤 객체가 필요하고, 각 객체는 어떤 책임을 가져야할까?(Hint. 고객, 상품, 카트, 마트오너 + etc)
3. 어떻게 협력해야할까?

추가 요구사항
- 유통기한 1일전 70% 할인
- 02~05시 특별 30% 할인
- 다수의 할인 정책을 지원하는 상품의 경우 최대 할인율을 제공하는 할인 정책으로 결정
 */