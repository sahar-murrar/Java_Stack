public class ProjectTest{
    public static void main(String [] args){
        Project p = new Project();
        p.setName("Sahar");
        System.out.println(p.getName());
        Project p2= new Project("Nadia");
        System.out.println(p2.getName());
        Project p3 = new Project("Ahmad", "Murrar");
        System.out.println("******************************");
        System.out.println(p3.getName());
        System.out.println(p3.getDescription());
        System.out.println(p3.elevatorPitch());
        
    }
}