package main;

import java.util.ArrayList;

import entity.Entity;

public class Inventory extends ArrayList<Entity>{

    private ArrayList<Entity> inventory=new ArrayList<>();
    private GamePanel gp;
    
    public Inventory(Integer sizeinventory){
        for (Integer i=0;i<sizeinventory;i++){
            this.inventory.add(new EmptyItem(this.gp));
            /* Make sure to have a method with the same name as the class (which inherits the "PickableObjects" class) "Empty" 
            to create an inventory filled with "null" slots. */ 
        }
        // For this method, make sure to modify the "PickableObjects" class to the appropriate class in your code.
    }

    public ArrayList<Entity> getInventory(){
        return this.inventory;
    }

    public Integer indexofitem(String itemname){
        for (Integer index=0;index<this.inventory.size();index++){
            Entity object=this.inventory.get(index);
            String item=object.getname();
            if (itemname==item){
                return index;
            }
        }
        return null;
    }

    public void pickitem(Entity item){
        for (Integer i=0;i<this.inventory.size();i++){
            Entity object=this.inventory.get(i);
            if (object instanceof EmptyItem){
                this.inventory.set(i,item);
                /*here, put code that "unspawns" the item from the map */
                break;
            }
            if (i==(this.inventory.size()-1)){
                System.out.println("The inventory is full already.");
            }
        }
        // For this method, make sure to modify the "PickableObjects" class to the appropriate class in your code.
    }
    
    public void deleteItem(String itemName){
        Integer indexitem=indexofitem(itemName);
        if (indexitem!=null && indexitem<this.inventory.size()){
            this.inventory.set(indexitem,new EmptyItem(this.gp));
        }
        else {
            System.out.println("Cannot delete non-exhistant item.");
        }
    }
    
    public void deleteItemIndex(Integer index){
        if (index<this.inventory.size()){
            this.inventory.set(index,new EmptyItem(this.gp));
        }
        else {
            System.out.println("Index is out of bounds of the inventory.");
        }
    }
    
    public void dropitem(String itemName){
        deleteItem(itemName);
        /*here, put code line that spawns the dropped item on the map*/
    }
    
}
