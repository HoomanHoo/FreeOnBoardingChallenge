package items;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Item {
  protected String name;
  protected int value;
  protected LocalDateTime expireDate;

  public Item(){
    this.expireDate = (LocalDateTime.now().plusDays((long) (Math.random() * 7)));
  }

  public LocalDateTime getExpireDate() {
    return expireDate;
  }

  public String getName() {
    return name;
  }

  public int getValue() {
    return value;
  }

  public int calcSale(){
    LocalDateTime currentTime = LocalDateTime.now();
    int currentHour = currentTime.getHour();

    // (유통기한 - 현재 시간)이 하루 이하일때
    if((Duration.between(currentTime, expireDate)).toDays() <= 1){
      return (int) (this.value * 0.7);
    }
    // 현재 시간이 02~05시 일때
    if(2 <= currentHour && currentHour <= 5){
      return (int) (this.value * 0.3);
    }
    // 위의 두 조건을 만족하지 않을 때
    return this.value;
  }

  @Override
  public String toString() {
    return "Item{" +
        "name='" + name + '\'' +
        ", value=" + value +
        ", expireDate=" + expireDate +
        '}';
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Item){
      return (Objects.equals(name, ((Item) obj).name) && value == ((Item)obj).value);
    }
    return false;
  }
}
