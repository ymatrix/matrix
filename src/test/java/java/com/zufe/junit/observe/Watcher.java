package com.zufe.junit.observe;

import java.util.Observable;
import java.util.Observer;

public class Watcher implements Observer {

	public Watcher(Watched w){
		w.addObserver(this);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		System.out.println("观察者被执行："+((Watched)arg0).retrieveData());
	}

}
