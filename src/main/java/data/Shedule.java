package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "horaire")
public class Shedule {
	private Long id;
	public Shedule(String open, String close) {
		ouverture = open;
		fermeture = close;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
	public void setId(Long id) {
        this.id = id;
    }
	
	private String ouverture;
	private String fermeture;
	public String getOuverture() {
		return ouverture;
	}
	public void setOuverture(String ouverture) {
		this.ouverture = ouverture;
	}
	public String getFermeture() {
		return fermeture;
	}
	public void setFermeture(String fermeture) {
		this.fermeture = fermeture;
	}
}
