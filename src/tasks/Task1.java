package tasks;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Task1{
	public static void main(String[] args) {
		int quantitySum = 0;
		double totalSum = 0.0;
		double totalDiscount = 0.0;
		double totalDiscount2 = 0.0;
		
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> products = new HashMap<>();
        products.put("A", 20);
        products.put("B", 40);
        products.put("C", 50);

        HashMap<String, Integer> productQuantities = new HashMap<>();
        for (HashMap.Entry<String, Integer> entry : products.entrySet()) {
            String product = (String) entry.getKey();
            System.out.print(" Enter the quantity of Product " + product + ": ");
            int quantity = sc.nextInt();
            quantitySum = quantitySum + quantity;
            productQuantities.put(product, quantity);
        }
        sc.close();
        System.out.println();
        
        for (String product : productQuantities.keySet()) {
            int value = productQuantities.get(product);
            double total = value*products.get(product);
            totalSum = totalSum + total;
            System.out.println(" Product " + product + " -> Quantity: " + value + ", Total: $" + total);
        }
        System.out.println();
        System.out.println(" Subtotal: $" + totalSum);
        
        HashMap<String,Double> discountMap = new HashMap<String,Double>();
        ArrayList<Double> discountOrder = new ArrayList<Double>();
        if(totalSum >= 200) {
        	
        	double discount = 0;
        	double price = 0;
        	
        	for (String key : products.keySet()) {
                int singleQuantity = productQuantities.get(key);
                if(quantitySum>30 && singleQuantity>15) {
                	price = (singleQuantity-15) * products.get(key);
                	discount = (int) (price * 0.5);
                	totalDiscount = totalDiscount + discount;
                	discountMap.put("tiered_50_discount", totalDiscount);
                }
                
                if(singleQuantity>10) {
                	double Discount2 = (products.get(key) * singleQuantity) * 0.05;
                	totalDiscount2 = totalDiscount2 + Discount2;
                	discountMap.put("bulk_5_discount", totalDiscount2);
                }
            }
        	
        	if(quantitySum>20) {
            	double totalDiscount1 = totalSum * 0.10;
            	discountMap.put("bulk_10_discount", totalDiscount1);
            }
        	discount = totalSum - 10;
        	discountMap.put("flat_10_discount", totalDiscount);
        }
        
        discountOrder.add(discountMap.getOrDefault("bulk_5_discount",0.0));
        discountOrder.add(discountMap.getOrDefault("bulk_10_discount",0.0));
        discountOrder.add(discountMap.getOrDefault("tiered_50_discount",0.0));
        discountOrder.add(discountMap.getOrDefault("flat_10_discount",0.0));
        Collections.sort(discountOrder);
        double disAmt = discountOrder.get(discountOrder. size()-1 );
        String disLabel = "Not";
        
        if(disAmt != 0.0) {
        	for(String key: discountMap.keySet()) {
                if(disAmt == discountMap.get(key)) {
                	disLabel = key;
                	break;
                }
              }
        }
        
        System.out.println(" Discount( " + disLabel +" ) applied " + " and Discount Amount: $" + disAmt);
        
        double shippingFee = 0.0;
        double giftWrap = quantitySum ;
        do {
        	shippingFee = shippingFee + 5.0;
        	quantitySum = quantitySum - 10;
        }while(quantitySum>=10);
        double totalCost = totalSum - disAmt + shippingFee + giftWrap;
        
        System.out.println(" Shipping Fee: $"+shippingFee+" and Gift Wrap Fee: $"+giftWrap);
        System.out.println(" Total: $"+totalCost);
        
	}
}