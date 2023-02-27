package controller;

public class RedesController {
	
	public String os() {
		String nome = System.getProperty("os.name");
		return nome;
		
	}
}
