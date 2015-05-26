package by.koshman.pharmacy.entity;

public class Order {
	private int id;
	private float amount;
	private OrderStatus status;
	
	public Order() {}
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public float getAmount(){
		return amount;
	}
	public void setAmount(float amount){
		this.amount = amount;		
	}
	public OrderStatus getStatus(){
		return status;
	}
	public void setStatus(OrderStatus status){
		this.status = status;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;		
		if (id != other.id)
			return false;
		if (amount != other.amount)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;		
		} else if (!status.equals(other.status))
				return false;
		
		return true;
	}
	
	public int hashCode() {
		return (int)(31 * id + amount + ((status == null) ? 0 : status.hashCode()));
	}
	
	public String toString() {
		return getClass().getName() + " id:" + id + "@Amount" + amount +  " Status:" + status;
	}
}
