package edu.sjsu.manager;

import java.util.ArrayList;

public class ConcreteSubject implements Subject {

	private ArrayList<Observer> observers = new ArrayList<>();
	
	private 
	
	@Override
	public void attach(Observer ob) {
		observers.add(ob);
		
	}

	@Override
	public void detach(Observer ob) {
		observers.remove(ob);
		
	}

	@Override
	public void notifyObservers() {
		for(Observer observer :observers){
			observer.update();
		}
		
	}

}
