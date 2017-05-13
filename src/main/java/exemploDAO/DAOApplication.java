package exemploDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import ex1.Todo;
import exemplo1.factory.ConnectionFactory;

public class DAOApplication {

    public static void main( String[] args ) throws SQLException {

        Connection connection = ConnectionFactory.getConnection( ConnectionFactory.POSTGRES );
        
        /**
         * Deixando o delete aqui somente por conveniencia, não é banana.
         */
        System.out.println("Remove tabela");
        Statement stDelete = connection.createStatement();
        stDelete.execute( "drop table todo" );
        stDelete.close();
        
        System.out.println("Cria tabela");
        Statement stCreate = connection.createStatement();
        // sacrificou o 'auto_increment' no mysql
        // que no postgres é 'serial'
        stCreate.execute( "create table todo ( id integer primary key, descricao varchar(255) , resumo varchar(255) )" );
        stCreate.close();
        
        /**
         * Usando o Dao a partir daqui
         */
        TodoDAO todoDao = new TodoDAO( connection );
        
        Todo todo = new Todo(1, "Todo dao", "Esta taref foi criada com um dao");
        
        todoDao.insert( todo );
        
    }
}
