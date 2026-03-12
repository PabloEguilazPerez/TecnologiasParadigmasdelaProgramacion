package tpp.nopatterns;

public class Order {
	private String id;
	private String status = "CREATED";
	private boolean paid;
	private String driver;
	private String customerEmail;

	public Order(String id, String email) {
		this.id = id;
		this.customerEmail = email;
	}

	public String getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}
}