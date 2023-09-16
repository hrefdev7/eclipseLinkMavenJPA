/**
 * 
 */
package entity;

/**
* @author Achref Hawari
 *
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Karhba {
    @Override
	public String toString() {
		return "Karhba [Id=" + Id + ", marque=" + marque + ", model=" + model + "]";
	}
	@Id
    @GeneratedValue
    private long Id;
    private String marque;
    private String model;
    
    
    
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
    



}