package serialization;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class SwaggerAPI_pet implements Serializable {
	  
	private int id;
	private int petId;
	private int quantity;
	private String shipDate;
	private String status;
	private String complete;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int i) {
		this.quantity = i;
	}
	public String getShipDate() {
		return shipDate;
	}
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComplete() {
		return complete;
	}
	public void setComplete(String complete) {
		this.complete = complete;
	}
	@Override
	public String toString() {
		return "SwaggerAPI_pet [id=" + this.id + ", petId=" + this.petId + ", quantity=" + this.quantity + ", shipDate=" + this.shipDate
				+ ", status=" + status + ", complete=" + complete + "]";
	}
	
	
	
	
}
