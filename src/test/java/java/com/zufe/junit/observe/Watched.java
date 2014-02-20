package com.zufe.junit.observe;

import java.util.Observable;

public class Watched extends Observable {

	private String data = "";

	public String retrieveData() {
		return data;
	}

	public void changeData(String data) {
		if (!this.data.equals(data)) {
			this.data = data;
			setChanged();
		}
		notifyObservers();
	}
	
	public static void main(String[] args){
		
		Watched watched = new Watched();
		Watcher watcher = new Watcher(watched);
		
		watched.changeData("In C, we create bugs.");
		watched.changeData("In Java, we inherit bugs.");
		watched.changeData("In Java, we inherit bugs.");
		watched.changeData("In Visual Basic, we visualize bugs."); 
	}
}
