package exemploDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ex1.Todo;

public class TodoDAO {

    private Connection connection;

    private String insertSql = "insert into todo ( id,  descricao, resumo ) values (?, ?, ? )";
    
    public TodoDAO( Connection connection ) {

        super();
        this.connection = connection;
    }

    public void insert( Todo todo ) throws SQLException {
        // presistir
        PreparedStatement stInsert = connection.prepareStatement( insertSql );
        stInsert.setInt( 1, todo.getId() );
        stInsert.setString( 2, todo.getDescricao() );
        stInsert.setString( 3, todo.getResumo() );
        stInsert.execute();
        stInsert.close();
    }

    public Todo findById( int id ) {

        // buscar
        return new Todo();
    }

    public void update( Todo todo ) {

        // atualizar
    }

    public void delete( Todo todo ) {

        // remover o objeto
    }

    public List< Todo > list() {

        List< Todo > todos = new ArrayList<>();
        // o codigo avai aqui
        return todos;
    }
}
