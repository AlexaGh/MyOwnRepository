package agregationAncComposition;

import java.util.ArrayList;

public class Room implements Drawable {

	private int x;
	private int y;
	private double height;
	private double width;
	
	public ArrayList<Structure> struct = new ArrayList<>();
	public ArrayList<Furniture> furn = new ArrayList<>();
	@Override
	public void redraw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

}
