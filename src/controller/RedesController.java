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
	public void ip() {
		int contador = 0;
		try {
			if (os().contains("Windows")) {
				String processo = "IPCONFIG";
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
			} else {
					String processo = "ifconfig";
					Process p = Runtime.getRuntime().exec(processo);
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					while (linha != null) {
						if (linha.contains("enp")) {
							System.out.println(linha);
						} else if (linha.contains("eth")){
							contador = 1;
						}
						if (linha.contains("inet ") && contador == 0) {
							System.out.println(linha);
						}
						linha = buffer.readLine();
					}

					buffer.close();
					leitor.close();
					fluxo.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			
			}
	}
	public void ping() {
		try {
			String processo = "";
			if (os().contains("Windows")) {
				processo = "ping -4 -n 10 www.google.com.br";
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					String[] armazenador = linha.split("ms, ", -2);
					linha = buffer.readLine();
			        for (String divisor : armazenador) {
			        	if(divisor.contains("dia")) {
			        		System.out.println(divisor);
			        	}
			        }
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} else {
				processo = "ping -4 -c 10 www.google.com.br";
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					if(linha.contains("méd")) {
						System.out.println(linha.substring(8, 11));
						System.out.println(linha.substring(29, 34));
					}
					linha = buffer.readLine();
				}
		        buffer.close();
				leitor.close();
				fluxo.close();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}