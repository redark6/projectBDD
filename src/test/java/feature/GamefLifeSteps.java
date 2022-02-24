package feature;

import static org.junit.Assert.assertEquals;

import java.util.List;

import gameOfLifeBDDProject.Cell;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

public class GamefLifeSteps {
	

    private ScenarioContext context;

    public GamefLifeSteps(ScenarioContext context) {
        this.context = context;
    }
    
	@Given("a game of life field without any living cell")
	public void a_game_of_life_field_without_any_living_cell() {
		// the field is already made
	}

	@Given("a game of life field of {int} colums and {int} rows with a living cell at \\({int} , {int})")
	public void a_game_of_life_field_of_colums_and_rows_with_a_living_cell_at(Integer int1, Integer int2, Integer int3, Integer int4) {
		this.context.field.setCellAlive(int3, int4);
	}

	@Given("a game of life field of {int} colums and {int} rows with a dead cell at \\({int} , {int}) and it is living neigbours at")
	public void a_game_of_life_field_of_colums_and_rows_with_a_dead_cell_at_and_it_is_living_neigbours_at(Integer int1, Integer int2, Integer int3, Integer int4, List<List<String>> neigbours) {
		this.context.field.killCell(int3, int4);
		
		//List<List<String>> neigboursList = null;
		//DataTable.create(neigboursList);
		for (List<String> position: neigbours) {
			this.context.field.setCellAlive(Integer.parseInt(position.get(0)), Integer.parseInt(position.get(1)));
		}

		// Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new io.cucumber.java.PendingException();
	}
	
	@Given("a game of life field of {int} colums and {int} rows with a living cell at \\({int} , {int}) and it is living neigbours at")
	public void a_game_of_life_field_of_colums_and_rows_with_a_living_cell_at_and_it_is_living_neigbours_at(Integer int1, Integer int2, Integer int3, Integer int4, List<List<String>> neigbours) {
		this.context.field.setCellAlive(int3, int4);
		
		//List<List<String>> neigboursList = null;
		//DataTable.create(neigboursList);
		for (List<String> position: neigbours) {
			this.context.field.setCellAlive(Integer.parseInt(position.get(0)), Integer.parseInt(position.get(1)));
		}
		
		//dataTable.forEach(position ->{
		//	this.context.field.setCellAlive(position.get(0), position.get(1));
		//});
		// Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new io.cucumber.java.PendingException();
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
	public void the_cell_at_should_be_dead(Integer int1, Integer int2) {
		assertEquals(Cell.DEAD_CELL, this.context.field.isCellAlive(int1, int2));
	}

	@Then("the cell at \\({int} , {int}) should be alive")
	public void the_cell_at_should_be_alive(Integer int1, Integer int2) {
		assertEquals(Cell.LIVING_CELL, this.context.field.isCellAlive(int1, int2));
	}

}
