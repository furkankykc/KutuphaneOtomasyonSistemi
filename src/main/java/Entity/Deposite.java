package Entity;

import java.util.Date;

public class Deposite {
	Date depositeDate;
	Date deliveryDate;
	
	public Deposite(Date depositeDate,Date deliveryDate){
		this.depositeDate = depositeDate;
		this.deliveryDate = deliveryDate;
	}
	
	public Deposite(){
		this.depositeDate = null;
		this.deliveryDate = null;
	}

	public Date getDepositeDate() {
		return depositeDate;
	}

	public void setDepositeDate(Date depositeDate) {
		this.depositeDate = depositeDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Override
	public String toString() {
		return "Deposite [depositeDate=" + depositeDate + ", deliveryDate=" + deliveryDate + "]";
	}

}

