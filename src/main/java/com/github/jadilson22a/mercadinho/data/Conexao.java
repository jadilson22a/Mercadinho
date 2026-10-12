package com.github.jadilson22a.mercadinho.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import io.github.cdimascio.dotenv.Dotenv;

public class Conexao {

	private final static Dotenv dotenv = Dotenv.load();
	private final static String username = dotenv.get("DB_USERNAME");
	private final static String password = dotenv.get("DB_PASSWORD");
	private final static String url = dotenv.get("DB_URL");
	
	public static void conectar() {
		try {
            // 2. Lê o conteúdo do arquivo XML template
            String xmlTemplate = new String(
            		Files.readAllBytes(
            				Paths.get("src/main/resources/META-INF/persistence.template.xml")));
            
            // 3. Substitui os placeholders pelos valores reais do .env
            String xmlFinal = xmlTemplate
                .replace("${DB_URL}", url)
                .replace("${DB_USERNAME}", username)
                .replace("${DB_PASSWORD}", password);
            
            // 4. Salva o novo arquivo XML pronto para o uso do seu sistema
            Files.write(Paths.get("src/main/resources/META-INF/persistence.xml"), xmlFinal.getBytes());
            
            System.out.println("Arquivo persistence.xml gerado com sucesso através do dotenv!");
            
        } catch (IOException e) {
            System.err.println("Erro ao processar os arquivos XML: " + e.getMessage());
        }
	}
}
