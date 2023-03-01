package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController redescontroller = new RedesController();
		String nomeSistema = redescontroller.os();
		System.out.println("Você está usando " + nomeSistema);
		String processo = "";
		int opcao;
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(
					"Digite a opção desejada:\n" + "1 - Método IP\n" + "2 - Método Ping\n" + "9 - Finalizar"));
			switch (opcao) {
			case 1:
				if (nomeSistema.contains("Windows")) {
					processo = "IPCONFIG";
				} else {
					processo = "IFCONFIG";
				}
				redescontroller.ip(processo);
				break;
			case 2: 
				if (nomeSistema.contains("Windows")) {
					processo = "PING -4 -n 10 www.google.com.br";
				} else {
					processo = "PING -4 c 10 www.google.com.br";
				}
				redescontroller.ping(processo);
				break;
			case 9:
				break;
			}
		} while (opcao != 9);
	}

}
