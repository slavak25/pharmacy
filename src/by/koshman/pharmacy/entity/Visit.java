package by.koshman.pharmacy.entity;
import java.sql.Date;

public class Visit {
	private static final long serialVersionUID = 1L;
	private int id;	
	private Date visitDate;
	private float amount;
	private String status;
	private int customerId;
	
	public Visit() {}
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}	
	public Date getVisitDate(){
		return visitDate;
	}
	public void setVisitDate(Date visitDate){
		this.visitDate = visitDate;
	}
	public float getAmount(){
		return amount;
	}
	public void setAmount(float amount){
		this.amount = amount;		
	}
	public String getStatus(){
		return status;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public int getCustomerId(){
		return customerId;
	}
	public void setCustomerId(int customerId){
		this.customerId = customerId;
	}	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visit other = (Visit) obj;		
		if (id != other.id)
			return false;
		if (customerId != other.customerId)
			return false;	
		if (amount != other.amount)
			return false;
		if (visitDate == null) {
			if (other.visitDate != null)
				return false;		
		} else if (!visitDate.equals(other.visitDate))
				return false;
		if (status == null) {
			if (other.status != null)
				return false;		
		} else if (!status.equals(other.status))
				return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((visitDate == null) ? 0 : visitDate.hashCode());
		result = prime * result + (int)amount;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + customerId;
		return result;		
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
	     s.append("Visit: \n");
		 s.append("id: " + getId() +  "\n");
		 s.append("visitDate: " + getVisitDate() +  "\n");
		 s.append("amount: " + getAmount() +  "\n");
		 s.append("status: " + getStatus() +  "\n");
		 s.append("customerId: " + getCustomerId() +  "\n");
		return s.toString();
	}	
}

