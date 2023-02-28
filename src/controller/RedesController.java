package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public String os() {
		String nome = System.getProperty("os.name");
		return nome;
		
	}
	public void ip(String processo) {
		int contador = 0;
		try {
			Process p = Runtime.getRuntime().exec(processo);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				if (linha.contains("Sem nome")) {
					contador = 1;
				} else if (linha.contains("Ethernet")){
					System.out.println(linha);
				}
				if (linha.contains("IPv4") && contador == 0) {
					System.out.println(linha);
				} 
					linha = buffer.readLine();
			}

			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	public void ping(String processo) {
		try {
			Process p = Runtime.getRuntime().exec(processo);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			// Falta checar e dividir a linha do ping
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}

			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
