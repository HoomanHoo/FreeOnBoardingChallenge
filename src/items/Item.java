package items;

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
