package featureImplementations.steps;

import java.util.List;

import featureImplementations.ScenarioContext;
import io.cucumber.java.en.Given;

public class GameOfLifeLivingCellSteps {
	

    private ScenarioContext context;

    public GameOfLifeLivingCellSteps(ScenarioContext context) {
        this.context = context;
    }
	
	@Given("a game of life field with a living cell at \\({int} , {int})")
	public void a_game_of_life_field_with_a_living_cell_at(Integer row, Integer column) {
		this.context.field.setCellAlive(row,column);
	}
	

	@Given("a game of life field with a living cell at \\({int} , {int}) and it is living neigbours at")
	public void a_game_of_life_field_with_a_living_cell_at_and_it_is_living_neigbours_at(Integer row, Integer column, List<List<String>> neigbours) {
		this.context.field.setCellAlive(row,column);
		for (List<String> position: neigbours) {
			this.context.field.setCellAlive(Integer.parseInt(position.get(0)), Integer.parseInt(position.get(1)));
		}
	}
	
}
