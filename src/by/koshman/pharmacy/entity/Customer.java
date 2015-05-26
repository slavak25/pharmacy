package by.koshman.pharmacy.entity;
import java.sql.Date;

public class Customer {	
	private static final long serialVersionUID = 1L;	
	private int id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String address;
	private String phone;
	private String email;
	private byte leftEye;
	private byte rightEye;	
	
	public Customer(){}
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public Date getDateOfBirth(){
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public byte getLeftEye(){
		return leftEye;
	}
	public void setLeftEye(byte leftEye){
		this.leftEye = leftEye;
	}
	public byte getRightEye(){
		return rightEye;
	}
	public void setRightEye(byte rightEye){
		this.rightEye = rightEye;
	}	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;		
		if (id != other.id)
			return false;
		if (leftEye != other.leftEye)
			return false;
		if (rightEye != other.rightEye)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;		
		} else if (!firstName.equals(other.firstName))
				return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;		
		} else if (!lastName.equals(other.lastName))
				return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;		
		} else if (!dateOfBirth.equals(other.dateOfBirth))
				return false;
		if (address == null) {
			if (other.address != null)
				return false;		
		} else if (!address.equals(other.address))
				return false;
		if (phone == null) {
			if (other.phone != null)
				return false;		
		} else if (!phone.equals(other.phone))
				return false;
		if (email == null) {
			if (other.email != null)
				return false;		
		} else if (!email.equals(other.email))
				return false;		
		
		return true;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + leftEye;
		result = prime * result + rightEye;		
		return result;
		}
	
	 @Override
	 public String toString() {
		 StringBuilder s = new StringBuilder();
		 s.append("Customer: \n");
		 s.append("id: " + getId() +  "\n");
		 s.append("firstName: " + getFirstName() +  "\n");
		 s.append("lastName: " + getLastName() +  "\n");
		 s.append("dateOfBirth: " + getDateOfBirth() +  "\n");
		 s.append("address: " + getAddress() +  "\n");
		 s.append("phone: " + getPhone() +  "\n");
		 s.append("email: " + getEmail() +  "\n");
		 s.append("lefteye: " + getLeftEye() +  "\n");
		 s.append("rightEye: " + getRightEye() +  "\n");
		 return s.toString();
	 }
}
