package com.nju.data;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class DepartBServerMain {
	
	
	public static void main(String[] args) {
		
		try {
			ProvideService departBService = new DepartBProvideImpl();
			 LocateRegistry.createRegistry(8002);
			 Naming.bind("rmi://localhost:8002/departBService",departBService); 
			 System.out.println("departB服务器已启动");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

