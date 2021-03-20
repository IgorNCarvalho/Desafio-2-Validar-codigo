import java.io.*;
import java.util.*;

public class Main {
	
	public static ArrayList<String> word = new ArrayList<>();
	
	// Validação do código
	
	public static boolean Validacao(String caracter) {

        Pilha stack = new Pilha();

        char[] letras = caracter.toCharArray();
        for (Character letra : letras) {

            if (letra == '('|| letra == '{'|| letra == '['|| letra == '<') {

            	stack.empilhar(letra);
            } else if (letra == ')'|| letra == ']'|| letra == '}'|| letra == '>') {

                try {

                    char verifica = stack.desempilhar();

                    if (letra == ')' && verifica == '(') {
                        continue;
                    } else if (letra == '}' && verifica == '{') {
                        continue;
                    } else if (letra == ']' && verifica == '[') {
                        continue;
                    } else if (letra == '>' && verifica == '<') {
                        continue;
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return true;
    }

	public static void main(String[] args) {

		//Leitura do arquivo texto 
		
		String path = "dados.txt";
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(path));
			
			String line = br.readLine();
			System.out.println("Leitura do arquivo texto: ");
			word.add(line);
			
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
				word.add(line);
			}
		}
		catch(IOException e) {
			System.out.println("Erro: " + e.getMessage());	
		}
		finally {
			System.out.println();
			try {
				if(br != null)
				{
					br.close();
				}
				if(fr != null)
				{
					fr.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// Salvando em novo arquivo texto
	
			String pathh = "check.txt";
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathh))){
				
				for(String caracter : word)
				{
					if(caracter== null )
					{
						break;
					}
					else {
						bw.write(caracter);
						bw.write(Validacao(caracter)?"\nválido" : "\ninválido");
						bw.newLine();
					}			
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
}
		
		
		
		
		
		
