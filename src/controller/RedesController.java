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
		try {
			Process p = Runtime.getRuntime().exec(processo);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
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
