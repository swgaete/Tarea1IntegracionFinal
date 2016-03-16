import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Scanner;

public class JavaApplication1 {
	static boolean SonIguales;
	 public static void main(String[] args)throws Exception
	    {
	        
	        Scanner sc = new Scanner(System.in);
	        String mensaje;
	        System.out.print("Introduzca el mensaje: ");
	        mensaje = sc.nextLine();	        
	    	String hash;
	        System.out.print("Introduzca el hash: ");	
	        hash = sc.nextLine();	
	        
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(mensaje.getBytes());
	        
	        byte byteData[] = md.digest();
	 
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        StringBuffer hexString = new StringBuffer();
	    	for (int i=0;i<byteData.length;i++) {
	    		String hex=Integer.toHexString(0xff & byteData[i]);
	   	     	if(hex.length()==1) hexString.append('0');
	   	     	hexString.append(hex);
	    	}
	        String FinalHash = hexString.toString();
	         if(hash.toLowerCase().equalsIgnoreCase(FinalHash)){         
	            System.out.println("Valido: True");
	            System.out.println("Mensaje: "+mensaje);
	            SonIguales(true);
	         
	          
	        }else{
	            System.out.println("Valido: False"); 
	            System.out.println("Mensaje : " +mensaje);
	            System.out.println("Formato real calculado Hex : " + hexString.toString());
	            SonIguales(false);
	           
	        }
	         
	         
	    }
	 
	 public static boolean SonIguales(boolean year) {
	        if (year)
	        	return  true;

	        else
	        	return false;

	    }
	 
	
}
