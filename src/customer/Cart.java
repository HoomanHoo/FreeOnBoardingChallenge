package customer;

import items.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
  private Map<String, List<Item>> items = new HashMap<>();

  public void insertCart(String itemName, Item item){
    if(items.containsKey(itemName)){
      List<Item> itemList = items.get(itemName);
      itemList.add(item);
      items.replace(itemName, itemList);
      System.out.println(itemName + " 이 장바구니에 추가되었습니다");
    }
    else{
      List<Item> itemList = new ArrayList<>();
      itemList.add(item);
      items.put(itemName, itemList);
      System.out.println(itemName + " 의 수량 1개 추가");
    }
  }

  public void clearCart(){
    this.items.clear();
  }

  public Map<String, List<Item>> getItems() {
    return items;
  }

  @Override
  public String toString() {
    List<String> keyList = new ArrayList<>();
    List<Integer> valueCount = new ArrayList<>();
    items.forEach((k, v) -> {
      keyList.add(k);
      valueCount.add(items.get(k).size());
    });
    String str = "";
    for (int i = 0; i < keyList.size(); i++){
      str += keyList.get(i) + "의 수량은 " + valueCount.get(i) + " 개 입니다\n";
    }
    return str;
  }
}
