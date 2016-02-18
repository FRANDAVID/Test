package json;

/**
 * Created by weijin on 16/2/15.
 */
public class Stu {
    private String name;
    private int age;
    private float id;
    public Stu(){

    }
    public Stu(String name) {

        this.name = name;
        this.age = 0;
    }

    public void setName(String name){
        this.name = name;
    }


    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getName() {
        return name;

    }
}
