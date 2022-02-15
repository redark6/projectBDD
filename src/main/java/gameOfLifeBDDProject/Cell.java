package gameOfLifeBDDProject;

public class Cell {
	
	public final static boolean DEAD_CELL = false;
    public final static boolean LIVING_CELL = true;
	
	private boolean isAlive;
	
	public Cell(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public void setCellAlive() {
		this.isAlive = LIVING_CELL;
	}
	
	public void killCell() {
		this.isAlive = DEAD_CELL;
	}
	
	public boolean isCellAlive() {
		return this.isAlive;
	}

}
