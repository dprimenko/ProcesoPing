import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ping {

	public static void main(String[] args) {
		Process proceso = null;
		try {
			proceso = new ProcessBuilder("ping" + args[0]).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		BufferedReader in = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
		
		try {
			
			for (int i = 0; i < 5; i++) {
				System.out.println(in.readLine());
			}	
			if (proceso != null) {
				proceso.destroy();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
