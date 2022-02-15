package gameOfLifeBDDProject;

public class Field {	
	private Cell[][] field;
	private int height;
	private int width;
	
	public Field(int height, int width) {
		this.height = height;
		this.width = width;
		this.field = new Cell[height][width];
		this.initField();
	}
	
	private void initField() {
		for (int r = 0; r < this.height; r++) {
			for (int c = 0; c < this.width; c++) {
				this.field[r][c] = new Cell(Cell.DEAD_CELL);
			}
		}
	}
	
	private int countLivingNeighboursCells(int row,int column) {
		int livingCells = 0;
		
		for (int r = row - 1; r < row + 1; r++) {
			for (int c = column - 1; c < column + 1; c++) {
				if(!isCellOutsideOfField(r,c) && (r != row && c != column) && this.field[r][c].isCellAlive())
					livingCells++;
			}
		}
		
		return livingCells;
	}
	
	private boolean isCellOutsideOfField(int row,int column) {
		return ( row < 0 || row > this.height ) || ( column < 0 || column > this.width );
	}
	
	public void nextGeneration() {
		Cell[][] nextGenerationField = new Cell[this.height][this.width];
		
		for (int r = 0; r < this.height; r++) {
			for (int c = 0; c < this.width; c++) {
				
				int livingNeighboursCells = countLivingNeighboursCells(r,c);
				System.out.println(livingNeighboursCells);
				System.out.println(r +" "+ c);

				boolean isCellAlive = this.isCellAlive(r,c);
				
				if(cellWillDieOfUnderpopulation(isCellAlive,livingNeighboursCells)) {
					nextGenerationField[r][c] = new Cell(Cell.DEAD_CELL);
				}else if(cellWillSurvive(isCellAlive,livingNeighboursCells)) {
					nextGenerationField[r][c] = new Cell(Cell.LIVING_CELL);
				}else if(cellWillDieOfOvercrowding(isCellAlive,livingNeighboursCells)) {
					nextGenerationField[r][c] = new Cell(Cell.DEAD_CELL);
				}else if(cellWillComeBackFromTheUnderworld(isCellAlive,livingNeighboursCells)){
					nextGenerationField[r][c] = new Cell(Cell.LIVING_CELL);
				}else {
					nextGenerationField[r][c] = this.field[r][c];
				}
			}
		}
		this.field = nextGenerationField;
	}
	
	private boolean cellWillDieOfUnderpopulation(boolean isCellAlive,int livingNeighboursCells) {
		return isCellAlive && livingNeighboursCells < 2;
	}
	
	private boolean cellWillSurvive(boolean isCellAlive,int livingNeighboursCells) {
		return isCellAlive && ( livingNeighboursCells == 2 || livingNeighboursCells == 3 );
	}
	
	private boolean cellWillDieOfOvercrowding(boolean isCellAlive,int livingNeighboursCells) {
		return isCellAlive && livingNeighboursCells > 3;
	}
	
	private boolean cellWillComeBackFromTheUnderworld(boolean isCellAlive,int livingNeighboursCells) {
		return !isCellAlive && livingNeighboursCells == 3;
	}
	
	public void setCellAlive(int row,int column) {
		if(!isCellOutsideOfField(row,column)) {
			this.field[row][column].setCellAlive();
		}
	}
	
	public void killCell(int row,int column) {
		if(!isCellOutsideOfField(row,column)) {
			this.field[row][column].killCell();
		}
	}
	
	private boolean isCellAlive(int row,int column) {
		return this.field[row][column].isCellAlive();
	}
}
