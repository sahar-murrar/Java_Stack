public class Project{
    private String name;
    private String description;
    private double initialCost ;
    //constructors 
    public Project(){

    }
    public Project(String name){
        this.name=name;
    }
    public Project(String name, String description){
        this.name=name;
        this.description=description;
    }
    //instance method
    public String elevatorPitch(){
        return (this.name +" ("+this.initialCost +") : " + this.description);
    }
    //setters and geters
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name= name;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description= description;
    }
     public Double getInitialCost(){
        return this.initialCost;
    }
    public void setInitialCost(String description){
        this.initialCost= initialCost;
    }

}