//name:tala fareed skafi , number 1161242, sec 8
package application;
import javafx.application.Application;

import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.geometry.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


public class Driver extends Application  {
	
	public static void main (String [] s )throws NumberFormatException {
		launch(s);
		
	
	}
	public static void sortOrders(ArrayList<PizzaOrder> s) {
		Collections.sort(s);
	}
	
	@Override
	public void start (Stage p) {
		p.setTitle("pizza order");
		ArrayList<PizzaOrder> orders =new ArrayList<>();
		try {
			Image pizza1=new Image("https://media.istockphoto.com/vectors/pizza-slices-icon-set-vector-id176933045");
			ImageView pizza=new ImageView(pizza1);
			   Label t= new Label("pizza order !");
			   t.setAlignment(Pos.TOP_RIGHT);
			   Font f=new Font("Times New Roman ", 80);
			   t.setFont(f);
			 
	   HBox lap = new HBox(10);
	   Label cn=new Label("Costumer Name :");
	   TextField tf=new TextField();
	   tf.setPrefColumnCount(20);
	   lap.getChildren().addAll(cn,tf);
	   lap.setAlignment(Pos.TOP_LEFT);
			RadioButton r1=new RadioButton("toGo");
			RadioButton r2=new RadioButton("Seated");
			RadioButton r3=new RadioButton("Delivery");
			r1.setSelected(true);
			r1.setOnAction(e->{
				});
			ToggleGroup tg = new ToggleGroup();
			r1.setToggleGroup(tg);
			r2.setToggleGroup(tg);
			r3.setToggleGroup(tg);
			VBox x = new VBox(10);
			x.getChildren().addAll(r1,r2,r3);
			x.setAlignment(Pos.TOP_LEFT);
		  CheckBox y= new CheckBox("Onions");
		  CheckBox y2= new CheckBox("Olives");
		  CheckBox y3= new CheckBox("GreenPapers");
		  
		  VBox ch=new VBox(10);
		  ch.getChildren().addAll(y,y2,y3);
		  shape(y,y2,y3);
		   ComboBox cb = new ComboBox();
		  cb.getItems().addAll("S","M","L");
		  cb.getSelectionModel().selectFirst();
		  HBox btns=new HBox(10);
		  Button btn1=new Button("ProcessOrder");
		  Button btn2=new Button("PrintOrders");
		  Button btn3=new Button("Reset ");
		  btns.setAlignment(Pos.BOTTOM_CENTER);
		  btns.getChildren().addAll(btn1,btn2,btn3);
		  VBox tall=new VBox(20);
		   tall.getChildren().addAll(t,x,lap, ch );
			 GridPane tala=new GridPane();
			 tala.setPadding( new Insets(30));
			 tala.setAlignment(Pos.BASELINE_LEFT);
			 tala.add(tall,1,1);
			 tala.add(cb,1,150);
			 BorderPane f5=new BorderPane();
			 StackPane stp = new StackPane();
			 stp.getChildren().addAll(pizza,f5);
			 f5.setBottom(btns);
			 f5.setLeft(tala);
			 Label seated =new Label("serviceCharge ");
			 seated.setMinWidth(50);
			 seated.setMinHeight(50);
				HBox set1 =new HBox(10);
				TextField tf2=new TextField();
				HBox del1 =new HBox(10);
				TextField tf1=new TextField();
				Label del =new Label("tipRate");
	r2.setOnAction(e->{
		del1.getChildren().removeAll(del,tf1);
		tf2.setPrefColumnCount(10);
		set1.getChildren().addAll(seated,tf2);
		set1.setAlignment(Pos.CENTER_LEFT);
		f5.setCenter(set1);});
	r3.setOnAction(e->{
		set1.getChildren().removeAll(seated,tf2);
		tf1.setPrefColumnCount(10);
		del1.getChildren().addAll(del,tf1);
		del1.setAlignment(Pos.CENTER_LEFT);
		f5.setCenter(del1);});
	 r1.setOnAction(e->{
			del1.getChildren().removeAll(del,tf1);
			set1.getChildren().removeAll(seated,tf2);
		});
	 HBox price=new HBox();
	 Label theprice=new Label("the order price is");
	 TextField  pr=new TextField();
	 
	 pr.setPrefColumnCount(10);
	 pr.setText("0.0");
	
	 price.getChildren().addAll(theprice,pr);
	 price.setAlignment(Pos.BOTTOM_CENTER);
	btn1.setOnAction(e->{
		 f5.setRight(price);
		  int c;
		  double topp=0;
		int size;
		  if(r1.isSelected()) {
			 c= toppingP(y,y2,y3,topp);
			 if (y.isSelected()) { topp+=10; } if (y2.isSelected()) { topp+=10; }  if (y3.isSelected()) { topp+=10;	   }
			  size=pizzaSize(cb);
			  ToGo tgo= new ToGo(tf.getText(),size,c,topp);
			  
			  orders.add(tgo);
			double val=tgo.calculateOrderPrice();
			String t5=Double.toString(val);
			 pr.setText(t5);
			 
		  }
		  else if (r2.isSelected()) {
			  c= toppingP(y,y2,y3,topp);
				 if (y.isSelected()) { topp+=50; } if (y2.isSelected()) { topp+=60; }  if (y3.isSelected()) { topp+=70;	   }
				  size=pizzaSize(cb);
				 try {   if(!isNumeric(tf2.getText())) {throw new InputMismatchException ();}
					 double  sCh= Double.parseDouble(tf2.getText());
				        Seated std =new Seated (tf.getText(),size,c,topp,sCh);
						orders.add(std);
						double val1=std.calculateOrderPrice();
						String t5=Double.toString(val1);
						 pr.setText(t5);
				 }
				 catch(InputMismatchException  e1) {
					 Alert alert = new Alert(AlertType.WARNING);
				 alert.setTitle("Warning");
				 alert.setHeaderText("wrong value");
				 alert.setContentText("you entered a wrong value , try again !");

				 alert.showAndWait();}
							  
		 }
		 else if(r3.isSelected()) {
			  c= toppingP(y,y2,y3,topp);
				 if (y.isSelected()) { topp+=50; } if (y2.isSelected()) { topp+=60; }  if (y3.isSelected()) { topp+=70;	   }
				 size=pizzaSize(cb);
			 try {
				 if(!isNumeric(tf1.getText())) {throw new InputMismatchException ();}
				 double  tipRate= Double.parseDouble(tf1.getText());
				  Delivery dlv=new Delivery(tf.getText(),size,c,topp,tipRate);
				  orders.add(dlv); 
				  double val2=dlv.calculateOrderPrice();
					String t5=Double.toString(val2);
					 pr.setText(t5);
			 }
			 catch(InputMismatchException  e1) { Alert alert = new Alert(AlertType.WARNING);
			 alert.setTitle("Warning");
			 alert.setHeaderText("wrong value");
			 alert.setContentText("you entered a wrong value , try again !");

			 alert.showAndWait();}
				
			  }
		  });
	btn2.setOnAction(e->{
		sortOrders(orders);
		Stage neww= new Stage();
		BorderPane p2=new BorderPane();
		neww.setTitle("OrderSorting <3");
		 Scene s=new Scene(p2,900,500);
		neww.setScene(s);
		 neww.show();
		 VBox ver=new VBox(10);
		 VBox ver2=new VBox(10);
		 String [] m=new String[orders.size()] ;
		 double [] cal=new double [orders.size()];
		 String file = "ordersfile.txt";
		 PrintWriter out=null;
		 try 
		 {
			 out =new PrintWriter(file);
			
		 }
		 catch(FileNotFoundException e3) {e3.printStackTrace();
			System.out.println("wrong");
		 }
		
		
		 for(int i=0; i<orders.size(); i++) {
			cal[i]= orders.get(i).calculateOrderPrice();
			 m[i]= orders.get(i).getCustomerName();
			 ver.getChildren().add(new Text("*The costumer name is:"+(m[i])));
			 ver.getChildren().add(new Text("and his order price is is:"+String.valueOf(cal[i])));
			 out.println("the costumer name " +m[i]+ "  his order price is  " +String.valueOf(cal[i]));
			  }
		 out.close();
		 p2.setPadding(new Insets(100));
		 p2.setCenter(ver);
		 p2.setLeft(ver2);
		
	});
	btn3.setOnAction(e->{
		tf.setText("");
		tf1.setText("");
		tf2.setText("");
		r1.setSelected(true);
		cb.getSelectionModel().selectFirst();
		pr.setText("0.0");
		y.setSelected(false); 
		y2.setSelected(false); 
		y3.setSelected(false); 
		});
	
	       Scene s=new Scene(stp,900,600);
		   p.setScene(s);
		   p.show();
		} catch(Exception e) {
			e.printStackTrace();
		}	
		
  }
	
	public int pizzaSize(ComboBox cb) {
		int size=0;
		  
		  if(cb.getValue().toString()=="S") {
			  size=1;
		  }
		  else if(cb.getValue().toString()=="M") {
			  size=2;
		  }
		  else if(cb.getValue().toString()=="L") {
			  size=3;
		  }
		  else size=0;
		return size;
	}
	
	public int toppingP(CheckBox y,CheckBox y2,CheckBox y3 , double topp) {
		int c=0;
		topp=0;
		 if (y.isSelected()) {
			  c+=1;
			  topp+=50; }
		  if (y2.isSelected()) {
			  c+=1;
			  topp+=60; }
		  if (y3.isSelected()) {
			  c+=1;
			  topp+=70;	  
			  }
		  return c;
		  }
	public void shape(CheckBox y,CheckBox y2,CheckBox y3) {
		Circle r = new Circle(5);
		  r.setFill(Color.TAN);
		  Circle r10 = new Circle(5);
		  r10.setFill(Color.GREEN);
		  Circle r11 = new Circle(5);
		  r11.setFill(Color.LIGHTGREEN);
		  y.setGraphic(r);
		  y2.setGraphic(r10);
		  y3.setGraphic(r11);
	}
	
	public static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
}

