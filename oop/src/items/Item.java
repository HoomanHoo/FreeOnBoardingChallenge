package items;

import java.util.Date;
import java.util.Objects;

public class Item {
  protected String name;
  protected int value;



  public String getName() {
    return name;
  }

//  public void setName(String name) {
//    this.name = name;
//  }

  public int getValue() {
    return value;
  }

//  public void setValue(int value) {
//    this.value = value;
//  }


  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Item){
      return (Objects.equals(name, ((Item) obj).name) && value == ((Item)obj).value);
    }
    return false;
  }
}
