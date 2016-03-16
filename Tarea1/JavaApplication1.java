import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Scanner;

public class JavaApplication1 {
	 public static void main(String[] args)throws Exception
	    {
	        
	        Scanner sc = new Scanner(System.in);
	        String password;
	        System.out.print("Introduzca el mensaje: ");
	        password = sc.nextLine();
	    	String hash;
	        System.out.print("Introduzca el hash: ");	
	        hash = sc.nextLine();	
	        
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(password.getBytes());
	        
	        byte byteData[] = md.digest();
	 
	        //convert the byte to hex format method 1
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        
	        //convert the byte to hex format method 2
	        StringBuffer hexString = new StringBuffer();
	    	for (int i=0;i<byteData.length;i++) {
	    		String hex=Integer.toHexString(0xff & byteData[i]);
	   	     	if(hex.length()==1) hexString.append('0');
	   	     	hexString.append(hex);
	    	}
	        String FinalHash = hexString.toString();
	         if(hash.toLowerCase().equalsIgnoreCase(FinalHash)){         
	            System.out.println("Valido: True");
	            System.out.println("Mensaje : " +hash);
	           
	        }else{
	        	System.out.println("Valido: False");
	            System.out.println("Formato real Hex : " + hexString.toString());
	            System.out.println("Mensaje : " +hash);
	           
	        }	 
	         
	        
	         
	    }
	 
	 
	 
	
}

