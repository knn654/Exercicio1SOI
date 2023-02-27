package view;

import controller.RedesController;

public class Main {
	
	public static void main(String[] args) {
		RedesController redescontroller = new RedesController();
		String nomeSistema = redescontroller.os();
		System.out.println(nomeSistema);
		
		String processo = "IPCONFIG";
		redescontroller.ip(processo);
	}
	

}
