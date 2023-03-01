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
				redescontroller.ip();
				break;
			case 2: 
				redescontroller.ping();
				break;
			case 9:
				break;
			}
		} while (opcao != 9);
	}

}