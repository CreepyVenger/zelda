package main;

import entity.Entity;

public class EmptyItem extends Entity implements PickableItems{

    private String name;

    public EmptyItem(GamePanel gp){
        super(gp);
        this.name="Empty";
        this.description = "[" + name + "]\nIt is empty...";
    }
    public void pick(Inventory inventory){}
    public void drop(Inventory inventory){}
    public String getname(){
        return this.name;
    }
    public String getdescription(){
        return this.description;
    }

}