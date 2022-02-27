package featureImplementations.steps;


import static org.junit.Assert.assertEquals;

import featureImplementations.ScenarioContext;
import gameOfLifeBDDProject.Cell;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StandardSteps {
	
    private ScenarioContext context;

    public StandardSteps(ScenarioContext context) {
        this.context = context;
    }
    
	@Given("a game of life field without any living cell")
	public void a_game_of_life_field_without_any_living_cell() {
		// the field is already construt with dead cells
	}
    
	@When("this field pass to the next generation")
	public void this_field_pass_to_the_next_generation() {
		this.context.field.nextGeneration();
	}
	
	@Then("i should found no living cells")
	public void i_should_found_no_living_cells() {
		int livingCells = 0;
		for (int i = 0; i < this.context.field.getRow(); i++) {
			for (int j = 0; j < this.context.field.getColumn(); j++) {
				if(this.context.field.isCellAlive(i, j)) {
					livingCells+= 1;
				}
			}
		}
		assertEquals(0, livingCells);
	}

	@Then("the cell at \\({int} , {int}) should be dead")
	public void the_cell_at_should_be_dead(Integer row, Integer column) {
		assertEquals(Cell.DEAD_CELL, this.context.field.isCellAlive(row, column));
	}

	@Then("the cell at \\({int} , {int}) should be alive")
	public void the_cell_at_should_be_alive(Integer row, Integer column) {
		assertEquals(Cell.LIVING_CELL, this.context.field.isCellAlive(row, column));
	}

}
