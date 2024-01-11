import customer.Cart;
import items.Item;
import java.util.List;
import java.util.Map;

public class Mart {


  public int calc(Cart cart){
    Map<String, List<Item>> items = cart.getItems();
    String[] names = items.keySet().toArray(new String[0]);

    int payValue = 0;

    for(int i = 0; i < names.length; i++){
      List<Item> itemList = items.get(names[i]);
      payValue += (itemList.get(0).getValue() * itemList.size());
    }
    return payValue;

  }
}
