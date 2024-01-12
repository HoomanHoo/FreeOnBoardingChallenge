package factorys;

import items.Bread;
import items.Coffee;
import items.Item;

public class ItemFactory {

    public Item createItem (String itemName){
        if(itemName.equals("Americano")){
            return new Coffee();
        }
        if(itemName.equals("Bread")){
            return new Bread();
        }
        throw new IllegalArgumentException("존재하지 않는 상품입니다");
    }

}
