package jain.pranjal.studentregestration;

/**
 * Created by hp on 7/12/2019.
 */

public class MyData
{
    private String name;
    private byte[] image;
    private String regno;
    private int id;

    public MyData(String name, byte[] image,String regno,int id)
    {
        this.name= name;
        this.image= image;
        this.regno=regno;
        this.id=id;

    }
    public String GetName()
    {
        return name;
    }
    public byte[] GetImage()
    {
        return image;
    }
    public String GetRegno(){return regno;}
    public int GetId(){return id;}

    public void SetName(String name)
    {
        this.name= name;
    }
    public void SetImage(byte[] image)
    {
        this.image= image;
    }
    public void SetRegno(String regno){ this.regno = regno;}
    public void SetId(int id){ this.id= id;}

}
