import customer.Cart;
import customer.Customer;
import factorys.ItemFactory;
import factorys.PaymentFactory;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Customer customer;
    Mart mart = new Mart();
    // Payment와 Item 타입 객체에 대한 의존도를 낮추기 위해 Factory 클래스 생성
    PaymentFactory paymentFactory = new PaymentFactory();
    ItemFactory itemFactory = new ItemFactory();

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
        customer = new Customer(new Cart(),paymentFactory.createPayment(paymentCode));
        System.out.println("카드를 결제 수단으로 선택하였습니다\n");
        System.out.println("현재 잔액은 " + customer.getPayment().getMoney() + "원 입니다");
        break;
      }
      if(paymentCode == 0){
        System.out.println("방문해주셔서 감사합니다");
        return;
      }
      if(paymentCode != 0 && paymentCode != 1){
        System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요");
      }
    }


    
    while(true) {
      System.out.println("행동을 선택해주세요");
      System.out.println("0: 장바구니 목록 확인");
      System.out.println("-1: 결제하기");
      System.out.println("-2: 나가기");
      System.out.println("-3: 카드 충전하기");
      System.out.println("-4: 장바구니 비우기");
      System.out.println("1: 아메리카노 장바구니에 담기");
      System.out.println("2: 빵 장바구니에 담기");

      int itemCode = 0;
      String itemName;
      try {
        itemCode = scanner.nextInt();
      } catch (Exception e){
        System.out.println(e);
        continue;
      }
      switch (itemCode) {
        case 1 -> {
        itemName = "Americano";
        customer.getCart().insertCart(itemName, itemFactory.createItem(itemName));
        continue;
      }
        case 2 -> {
          itemName = "Bread";
          customer.getCart().insertCart(itemName,itemFactory.createItem(itemName));
          continue;
        }
        case 0 -> {
          System.out.println(customer.getCart().toString());
          continue;
        }
        case -1 -> {
          int paymentValue = mart.calc(customer.getCart());
          System.out.println("총 결제 금액은 " + paymentValue + "원 입니다\n결제 하시겠습니까?");
          int payCode = paying(scanner, customer, paymentValue);
          // payCode = 1 -> 결제, 2 -> 결제 취소, 3 -> 잔액 부족
          if(payCode != 1){
            continue;
          }
          customer.clearCart();
        }
        case -2 -> {
          System.out.println("방문해주셔서 감사합니다");
          return;
        }
        case -3 -> {
          System.out.println("충전 기능은 준비중입니다");
          continue;
        }
        case -4 -> {
          customer.clearCart();
          continue;
        }
        default -> {
          System.out.println("입력 오류");
          continue;
        }

      }
      // 다시 물건 구매하기로 돌아갈지 선택
      int replay = 0;
      while(true){
        System.out.println("다시 쇼핑 하시겠습니까?\n1: 네\n2: 아니오");
        replay = scanner.nextInt();
        if(replay != 1 && replay != 2){
          System.out.println("입력 오류");
          continue;
        }
        break;
      }
      // 다시 물건 구매로 돌아가기
      if(replay == 1){
        continue;
      }
      // 종료하기
      if(replay == 2){
        System.out.println("방문해주셔서 감사합니다");
        return;
      }
    }
  }

  private static int paying(Scanner scanner, Customer customer, int paymentValue) {
    int payCode = 0;
    while(true){
      System.out.println("1: 결제");
      System.out.println("2: 취소");
      try {
        payCode = scanner.nextInt();
      } catch (Exception e){
        System.out.println(e);
        continue;
      }
      // 결제 선택
      if(payCode == 1){
        int resultCode = customer.getPayment().pay(paymentValue);
        if(resultCode == 1) {
          break;
        }
        else {
          payCode = 3;
          break;
        }
      }
      // 결제 취소
      if(payCode == 2){
        System.out.println("뒤로 돌아갑니다");
        break;
      }
    }
      return payCode;
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