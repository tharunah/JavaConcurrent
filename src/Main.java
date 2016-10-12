import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.sun.swing.internal.plaf.synth.resources.synth_sv;

/**
1. Modify the program to support TextField with border  
2. Modify the program to support TextField with scrollbar
 
*/

/*public interface GraphicalComponent {

     void paint();
     void addComponent( Object content );

}*/


 class TextField implements GraphicalComponent {

    private List<String> line = new LinkedList();

    @Override
    public void paint() {
        System.out.println("Start TextField .....");
        line.stream().forEach( System.out::println );
        System.out.println("End TextField .....");
    }
    
    @Override
    public void addComponent(Object content) {
        assert(content instanceof String);
        this.line.add( (String) content );    
    }
}



 
 class Boarder extends ComponentDecoder 
 {

	public Boarder(GraphicalComponent gComp) {
		super(gComp);
	}

	
	@Override
	public void paint() {
		System.out.println("Boarder Start here");
		System.out.println("-------------------");
		gComp.paint();
		System.out.println("---------------------");
		System.out.println("boarder ends here");
	}


	 
 }
 
 
 

public class Main {

	 public static void main( String[] args ) {
	        GraphicalComponent component = constructAndAddLine();
	        GraphicalComponent boader = new Boarder(component);
	        boader.paint();
	    }

	    private static GraphicalComponent constructAndAddLine() {
	        GraphicalComponent toReturn = new TextField();
	          toReturn.addComponent( "This is First Line" );
	        toReturn.addComponent( "This is Second Line" );
	        toReturn.addComponent( "This is Third Line" );
	        toReturn.addComponent( "This is Fourth Line" );
	         toReturn.addComponent( "This is Fifth Line" );
	         
	        
	        
	        return toReturn;
	    }

}
