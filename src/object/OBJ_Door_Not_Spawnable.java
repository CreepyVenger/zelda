package object;

import main.GamePanel;

public class OBJ_Door_Not_Spawnable extends OBJ_Door{
    
    private String name;

    public OBJ_Door_Not_Spawnable(GamePanel gp){
        super(gp);

        this.name="Door_Not_Spawnable";
    }

    public String getname(){return this.name;}
    public String getdescription(){return this.description;}
}
