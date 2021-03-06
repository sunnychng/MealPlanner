package dmacc.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class MealPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MEAL_ID")
	private long id;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable
		(
				name="INGREDIENTS_LIST",
				joinColumns= { @JoinColumn(name="MEAL_ID", referencedColumnName="MEAL_ID") },
				inverseJoinColumns= { @JoinColumn(name="RECIPE_ID", referencedColumnName="RECIPE_ID", unique=true) }
		)
	private List<Recipes> recipesList;
	
	
	public MealPlan() {
		super();
	}
	
	public MealPlan(long id) {
		super();
		this.id = id;
	}

	public MealPlan(long id, List<Recipes> recipesList) {
		super();
		this.id = id;
		this.recipesList = recipesList;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the recipesList
	 */
	public List<Recipes> getRecipesList() {
		return recipesList;
	}
	/**
	 * @param recipesList the recipesList to set
	 */
	public void setRecipesList(List<Recipes> recipesList) {
		this.recipesList = recipesList;
	}
	@Override
	public String toString() {
		return "MealPlan [id=" + id + ", recipesList=" + recipesList + "]";
	}
	

	
	
}
