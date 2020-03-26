package com.turingtecnologia.leshto.todolist.db;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConnectionFactory {
	public static void main(String[] args) {
		Connection conn = ConnectionFactory.getConnection();
		
		if (conn == null) {
			System.err.println("ERRO: falha ao estabelecer conexão com o DB."
					+ "\n Verifique se o JDBC está instalado e o banco de dados está ligado!");
		}
		else {
			System.out.println("Conexão estabelecida com sucesso!");
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
}
