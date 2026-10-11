package com.github.jadilson22a.mercadinho;

import java.sql.Connection;

import com.github.jadilson22a.mercadinho.data.Conexao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Connection conexao = Conexao.conectar();
        if(conexao.equals(null)) {
        	System.out.println("Erro de conexao!");
        }else {
        	System.out.println("Conectado!");
        }
    }
}
