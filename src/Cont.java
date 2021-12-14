import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;

public class Cont {
	
	private static String encodeHex(byte[] digest) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < digest.length; i++) {
	        sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
	    }
	    return sb.toString();
	}
	
	private static String getHash(String data)
	{
		byte [] encodedhash;
		try {
			 MessageDigest md = MessageDigest.getInstance("SHA-256");
		     byte[] buffer = data.getBytes("UTF-8");
		     md.update(buffer);
		     byte [] digest = md.digest();
		    return encodeHex(digest);
			
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	public static String logInPerson(String name, String password)
	{
		
		FileInputStream fis ;
		Scanner sc;
	
		try {
			fis = new FileInputStream("users.csv");
			sc = new Scanner(fis);
			boolean found = false;
			
			while(sc.hasNextLine()&&!found)
			{
			
				String s = sc.nextLine();
				String[]data = s.split(",");
				if(data[1].equals(getHash(password)))
				{
					System.out.println("User : "+ data[0]+" was logged in!");
					found = true;
					return s;
				}
				
			}
			if(!found)
			{
				System.out.println("Incorect credentials!");
			}
			
		} catch(IOException er)
		{
			System.out.println(er);
		}
		
		return null;
	}
	
	
}
