package Model;

import java.util.UUID;

public class IDUtils {
	
	public static String getID() {
		//生成唯一id
        String id= UUID.randomUUID().toString();
        //替换uuid中的"-"
        id=id.replace("-", "");
        return id;
	}
}
