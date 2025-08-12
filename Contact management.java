import java.util.ArrayList;
class Contact
{
public static void main(String[] args)
{
String con[10]=new String[10];
ArrayList<String>con=new ArrayList<String>();
con.add("Nithya");
con.add("Muthu");
con.add("Java");
con.add("Vaishnavi");
con.add("Python");
for (String con1:con)
{
System.out.println(con1);
}
System.out.println("Retrieve:"+con.get(3));
System.out.println("Update details:"+con.set(4,"Clanguage"));
System.out.println("Delete:"+con.remove(2));
}
}
