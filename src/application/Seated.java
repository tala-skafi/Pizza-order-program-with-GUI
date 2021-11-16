//name:tala fareed skafi , number 1161242, sec 8
package application;

public  class Seated extends PizzaOrder {
	public double serviceCharge;
	public Seated() {}
	public Seated(String customerName,   int pizzaSize, int numberOfToppings, double toppingPrice, double serviceCharge) {
	
		super(customerName ,pizzaSize,numberOfToppings ,toppingPrice);
	this.serviceCharge=serviceCharge;
	}
	
	

 @Override
 public String toString(){
	 return super.toString();
 }
 @Override
 public void printOrderReport() {}
 
 @Override
 public double calculateOrderPrice() {
	 return super.calculateOrderPrice() +serviceCharge;
 }

}
