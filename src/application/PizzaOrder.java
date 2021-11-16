//name:tala  fareed skafi , number 1161242, sec 8
package application;
import java.util.*;
public  abstract class PizzaOrder implements Comparable<PizzaOrder> {
 protected String 	customerName;
 public Date 	dateOrdered;
 int 	pizzaSize;
 int 	numberOfToppings;
 double toppingPrice;
 double OrderPrice;
 public PizzaOrder () {super();}
 public PizzaOrder (String s ,int p , int n, double t)
 {
	 this.customerName=  s;
	 this.pizzaSize=p;
     this.numberOfToppings=n;
     this.toppingPrice=t;
     dateOrdered=new Date();
 }
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public Date getDateOrdered() {
	return dateOrdered;
}
public void setDateOrdered(Date dateOrdered) {
	this.dateOrdered = dateOrdered;
}
public int getPizzaSize() {
	return pizzaSize;
}
public void setPizzaSize(int pizzaSize) {
	this.pizzaSize = pizzaSize;
}
public int getNumberOfToppings() {
	return numberOfToppings;
}
public void setNumberOfToppings(int numberOfToppings) {
	this.numberOfToppings = numberOfToppings;
}
public double getToppingPrice() {
	return toppingPrice;
}
public void setToppingPrice(double toppingPrice) {
	this.toppingPrice = toppingPrice;
}
@Override
public String toString() {
	return "PizzaOrder [customerName=" + customerName + ", dateOrdered=" + dateOrdered + ", pizzaSize=" + pizzaSize
			+ ", numberOfToppings=" + numberOfToppings + ", toppingPrice=" + toppingPrice + "]";
}
public  double  calculateOrderPrice(){

OrderPrice= pizzaSize * numberOfToppings * toppingPrice ;
			return OrderPrice;
}

void printOrderReport() {
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
	System.out.println("the price of the order is: " + OrderPrice );
}
void printOrderInfo() {
	System.out.println("the customer name is:" +customerName + "  and his order price is" +calculateOrderPrice() );
	
}
@Override
public int compareTo(PizzaOrder o) {
	if(calculateOrderPrice()> o.calculateOrderPrice())
		return 1;
	if(calculateOrderPrice()< o.calculateOrderPrice())
	return -1;
	return 0;
}
}
