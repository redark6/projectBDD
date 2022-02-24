package gameOfLifeBDDProject;

public class Field {	
	private Cell[][] field;
	private int row;
	private int column;
	
	public Field(int row, int column) {
		this.row = row;
		this.column = column;
		this.field = new Cell[row][column];
		this.initField();
	}
	
	private void initField() {
		for (int r = 0; r < this.row; r++) {
			for (int c = 0; c < this.column; c++) {
				this.field[r][c] = new Cell(Cell.DEAD_CELL);
			}
		}
	}
	
	private int countLivingNeighboursCells(int row,int column) {
		int livingCells = 0;
		
		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = column - 1; c <= column + 1; c++) {
				if(!isCellOutsideOfField(r,c) && (r != row || c != column) && this.field[r][c].isCellAlive())
					livingCells++;
			}
		}
		
		return livingCells;
	}
	
	private boolean isCellOutsideOfField(int row,int column) {
		return ( row < 0 || row > this.row -1 ) || ( column < 0 || column > this.column -1 );
	}
	
	public void nextGeneration() {
		Cell[][] nextGenerationField = new Cell[this.row][this.column];
		
		for (int r = 0; r < this.row; r++) {
			for (int c = 0; c < this.column; c++) {
				
				int livingNeighboursCells = countLivingNeighboursCells(r,c);

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
	
	public boolean isCellAlive(int row,int column) {
		return this.field[row][column].isCellAlive();
	}
	
	public void showField() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(this.field[i][j].toString());
			}
			System.out.println();
		}
		System.out.println();
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

}
