import java.util.HashMap;

public class HashMapApp
{
    public static void main(String[] args)
    {
        HashMap<String, String> map = new HashMap<>();
        
        map.put("Justin", "1234");
        map.put("John", "9876");

        System.out.println(map.get("Justin"));
        System.out.println(map.get("John"));
    }
}