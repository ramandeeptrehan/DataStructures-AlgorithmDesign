package com.ramantrehan.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class Tuple {
	int numberOfItems;
	float price;
	
	public Tuple(int numberOfItems, float price) {
		this.numberOfItems = numberOfItems;
		this.price = price;
	}
	
	public int getNumberOfItems() {
		return numberOfItems;
	}
	
	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Tuple [numberOfItems=" + numberOfItems + ", price=" + price + "]";
	}
}

class SellOrderComparator implements Comparator<Tuple> {
	@Override
	public int compare(Tuple tuple1, Tuple tuple2) {
		return Double.compare(tuple1.getPrice(), tuple2.getPrice());
	}
}

class BuyOrderComparator implements Comparator<Tuple> {
	@Override
	public int compare(Tuple tuple1, Tuple tuple2) {
		return Double.compare(tuple2.getPrice(), tuple1.getPrice());
	}
}

public class TradingSystem {
	
	private PriorityQueue<Tuple> sellOrders; //min heap
	private PriorityQueue<Tuple> buyOrders; //max heap
	
	public TradingSystem() {
		this.sellOrders = new PriorityQueue<>(new SellOrderComparator());
		this.buyOrders = new PriorityQueue<>(new BuyOrderComparator());
	}

	
	private int sell(int numberOfItems, float price) {
		
		int remainingItems = numberOfItems;
		
		while(!buyOrders.isEmpty() && remainingItems>0 && buyOrders.peek().getPrice() >= price) {
			Tuple buyOrder = buyOrders.peek();
			
			if(buyOrder.getNumberOfItems() <= remainingItems) {
				//buyOrder is done fully
				remainingItems -= buyOrder.getNumberOfItems();
				buyOrders.poll();
			} else {
				buyOrder.numberOfItems -= remainingItems;
				remainingItems = 0;
			}
		}
		
		if(remainingItems!=0) {
			//persist sell order
			Tuple sellOrder = new Tuple(remainingItems, price);
			sellOrders.add(sellOrder);
		}
		
		return numberOfItems - remainingItems;
	}
	
	private int buy(int numberOfItems, float price) {
		int remainingItems = numberOfItems;
		
		while(!sellOrders.isEmpty() && remainingItems>0 && sellOrders.peek().getPrice() <= price) {
			Tuple sellOrder = sellOrders.peek();
			if(sellOrder.getNumberOfItems()<=remainingItems) {
				//poll sell order
				remainingItems -= sellOrder.getNumberOfItems();
				sellOrders.poll();
			} else {
				sellOrder.numberOfItems -= remainingItems;
				remainingItems = 0;
			}
		}
		
		if(remainingItems!=0) {
			//persist buy order
			Tuple tuple = new Tuple(remainingItems, price);
			buyOrders.add(tuple);
		}
		
		return numberOfItems - remainingItems;
	}
	
	public static void main(String[] args) {
		TradingSystem obj = new TradingSystem();
		
		System.out.println("sell(1,(float)0.10) "+ obj.sell(1,(float)0.10));
        System.out.println("sell(1,(float)0.11) "+ obj.sell(1,(float)0.11));
        System.out.println("sell(1,(float)0.12) "+ obj.sell(1,(float)0.12));
        System.out.println("sell(1,(float)0.13) "+ obj.sell(1,(float)0.13));
        System.out.println("sell(1,(float)0.14) "+ obj.sell(1,(float)0.14));
        System.out.println("sell(1,(float)0.15) "+ obj.sell(1,(float)0.15));
        System.out.println("sell(1,(float)0.16) "+ obj.sell(1,(float)0.16));
        System.out.println("sell(1,(float)0.17) "+ obj.sell(1,(float)0.17));
        
        System.out.println("buy(100,(float)0.5) "+ obj.buy(100,(float)0.5));      
        System.out.println("sell(93,(float)0.2) "+ obj.sell(93,(float)0.2));
	}
}
