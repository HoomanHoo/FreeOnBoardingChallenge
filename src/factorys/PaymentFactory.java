package factorys;

import customer.Card;
import customer.Payment;

public class PaymentFactory {
    public Payment createPayment(int paymentCode){
        if(paymentCode == 1){
            return new Card();
        }
        throw new IllegalArgumentException("유효하지 않은 선택입니다");
    }
}
