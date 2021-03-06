import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.io.IOException;

public class JavaApplication1 {
	static boolean SonIguales;	//variable para ver si son iguales
	 public static void main(String[] args)throws Exception
	    {
		 	System.out.println("Parte 3.1 Tarea \n"); 
	        Scanner sc = new Scanner(System.in);
	        String mensaje;
	        System.out.print("Introduzca el mensaje: ");
	        mensaje = sc.nextLine();	        
	    	String hash;
	        System.out.print("Introduzca el hash: ");	
	        hash = sc.nextLine().toLowerCase();	//se pasa a minuscula el hash
	        String FinalHash=Hash(mensaje); 
	        StringBuffer hexString = new StringBuffer();
	        
	         if(hash.toLowerCase().equalsIgnoreCase(FinalHash)){   //devuelve mensaje y el boolean true  si son iguales   
	            System.out.println("Valido: True");
	            System.out.println("Mensaje: "+mensaje);
	            SonIguales(true);
	         
	          
	        }else{										//devuelve mensaje y boolean false si son desiguales
	            System.out.println("Valido: False"); 	
	            System.out.println("Mensaje : " +mensaje);
	            System.out.println("Formato real calculado Hex : \n" + FinalHash.toString()+"\n");
	            SonIguales(false);
	           
	        }
	        System.out.println("Parte 3.3 Tarea \n"); 
	        String FicheroTxt= leerFicheroUrl();
	        System.out.println("Fichero obtenido desde la url: "+FicheroTxt);
	        System.out.println("Hash obtenido desde la url: "+Hash(FicheroTxt));
	        
	           
	    }
	 
	 public static boolean SonIguales(boolean aux) { //retorna boolean
	        if (aux)
	        	return  true;

	        else
	        	return false;

	    }
	 public static String leerFicheroUrl() { //lee el fichero 
		    String str1="";
		    String str2="";
		    try {
		    URL url = new URL("https://s3.amazonaws.com/files.principal/texto.txt");

		    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
		    
		    while ((str1 = in.readLine()) != null) {
		    	
		        str2 = str2 + str1 +"\n";
		 
		    }
		    in.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return str2;
		}
	 
	 public static String Hash(String mensaje) throws NoSuchAlgorithmException{ //transforma el string a hash
		 
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
	        return FinalHash;
	 }	 
	
	 
	
}
