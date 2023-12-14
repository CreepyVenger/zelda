package main;

public interface PickableItems{
    
    public void pick(Inventory inventory);
    public void drop(Inventory inventory);
    public String getname();
}