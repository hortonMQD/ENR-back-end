package Model;

import java.util.UUID;

public class IDUtils {
	
	public static String getID() {
		//����Ψһid
        String id= UUID.randomUUID().toString();
        //�滻uuid�е�"-"
        id=id.replace("-", "");
        return id;
	}
}
