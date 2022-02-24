package gameOfLifeBDDProject;

public class Main {

	public static void main(String[] args) {
		Field field = new Field(3,3);
		field.setCellAlive(0, 0);
		field.setCellAlive(0, 1);
		field.setCellAlive(1, 0);
		field.showField();
		field.nextGeneration();
		field.showField();
	}

}
