package common;

public class Invoice {
	double Discount = 0.0;
	String strDiscount = null;
	int Quantity = 0;
	double Total = 0.0;
	
	public Invoice(int quantity, double discount, double total, String strdiscount) {
		this.Quantity = quantity;
		this.Discount = discount;
		this.Total = total;
		this.strDiscount = strdiscount;
		
	}
	
	public int getQuantity() {
		return Quantity;
	}
	public double getDiscount() {
		return Discount;
	}
	public double getTotal() {
		return Total;
	}
	public String getStrDiscount() {
		return strDiscount;
	}
	
	

}
