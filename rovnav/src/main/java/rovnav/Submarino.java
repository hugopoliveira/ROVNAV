package rovnav;

public class Submarino 
{
    public static void main( String[] args )
    {
    	Navigation nav = new Navigation();
    	
    	for (String command : args) {
    		Coordinate coordinate = nav.newPosition(command);
    		System.out.println("Comando: " + command);
    		System.out.println(coordinate.toString());
    		
    	}
    }
}
