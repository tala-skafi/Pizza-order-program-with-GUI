//name:tala fareed skafi , number 1161242, sec 8
package application;



public  class Delivery extends PizzaOrder {
	
double 	tipRate;
public Delivery () {super();}
public Delivery (String customerName, int  pizzaSize, int numberOfToppings, double toppingPrice, double tipRate){
	super(customerName ,pizzaSize,numberOfToppings ,toppingPrice);
	this.tipRate=tipRate;
}
public Delivery (double d) {}
public double getTipRate() {
	return tipRate;
}

public void setTipRate(double tipRate) {
	this.tipRate = tipRate;
}
@Override
public double calculateOrderPrice() {
	return super.calculateOrderPrice() + tipRate/100 *OrderPrice;

}
@Override
public void printOrderReport() {
	String size;
	if (pizzaSize ==1) {
		size="small";
	}
		else 
			if(pizzaSize ==2) {
				size="medium";
						}
			else 
				if(pizzaSize ==3) {
					size="large";
							}
				else 
					 {
						size="wrong size";
								}
	
	System.out.println("the customer name is: " + customerName );
	System.out.println("the pizza size: " + size );
	System.out.println("the number of topping is: " + numberOfToppings );
	System.out.println("the topping price is" + toppingPrice );
	System.out.println("the tip rate is"+tipRate);
	System.out.println("the price of the order is: " + calculateOrderPrice() );
}
@Override
public void printOrderInfo() {
	super.printOrderInfo();
}

}
	





