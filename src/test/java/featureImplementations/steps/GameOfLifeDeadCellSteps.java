package featureImplementations.steps;

import java.util.List;

import featureImplementations.ScenarioContext;
import io.cucumber.java.en.Given;

public class GameOfLifeDeadCellSteps {

    private ScenarioContext context;

    public GameOfLifeDeadCellSteps(ScenarioContext context) {
        this.context = context;
    }

    @Given("a game of life field with a dead cell at \\({int} , {int})")
    public void a_game_of_life_field_with_a_dead_cell_at(Integer row, Integer column) {
		this.context.field.killCell(row,column);
    }

    @Given("a game of life field with a dead cell at \\({int} , {int}) and it is living neigbours at")
    public void a_game_of_life_field_with_a_dead_cell_at_and_it_is_living_neigbours_at(Integer row, Integer column, List<List<String>> neigbours) {
		this.context.field.killCell(row, column);
		for (List<String> position: neigbours) {
			this.context.field.setCellAlive(Integer.parseInt(position.get(0)), Integer.parseInt(position.get(1)));
		}
    }
}
