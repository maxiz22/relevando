package ar.nix.relevando.models;

import ar.nix.relevando.database.MysqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.LinkedHashMap;

public abstract class DbModel {


    public abstract String getTable();
    protected Integer id;
    
	 
    // Método para guardar un registro
	public boolean save() {
	    String table = getTable();
	    Map<String, Object> sqlData = toSql();
	    
	    if (sqlData.isEmpty()) {
	        throw new IllegalStateException("No hay datos para guardar en la base de datos.");
	    }

	    StringBuilder sql = new StringBuilder("INSERT INTO " + table + " (");
	    StringBuilder placeholders = new StringBuilder();

	    for (String column : sqlData.keySet()) {
	        sql.append(column).append(", ");
	        placeholders.append("?, ");
	    }

	    // Eliminar la última coma y espacio
	    sql.setLength(sql.length() - 2);
	    placeholders.setLength(placeholders.length() - 2);

	    sql.append(") VALUES (").append(placeholders).append(")");

	    try (Connection conn = MysqlConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS)) {

	        int index = 1;
	        for (Object value : sqlData.values()) {
	            stmt.setObject(index++, value);
	        }

	        int affectedRows = stmt.executeUpdate();

	        if (affectedRows > 0) {
	            // Obtener la clave generada
	            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                	 Object generatedId = generatedKeys.getObject(1);
	                	
	                	 this.id = ((Number) generatedId).intValue();

	                }
	            }
	            return true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	    
	       return false;
	}

	    // Método para encontrar un registro
	    public ResultSet findOneFromDb(Integer idParam) {
	    	String table = getTable();
	        String whereClause = "id = ?";
	        Object[] params = { idParam };
	        String sql = "SELECT * FROM " + table + " WHERE " + whereClause + " LIMIT 1";
	        try (Connection conn = MysqlConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            for (int i = 0; i < params.length; i++) {
	                stmt.setObject(i + 1, params[i]);
	            }
	            return stmt.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    // Método para encontrar múltiples registros
	    public ResultSet findAllFromDb() {
	    	String table = getTable();
	        String sql = "SELECT * FROM " + table;
	
	        try  {
	        	Connection conn = MysqlConnection.getConnection();
	          	System.out.println("SQL: "+sql);
	        	PreparedStatement stmt = conn.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            return rs;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return null;
	    }
    
    public boolean deleteFromDb() {
    	String table = getTable();
        String whereClause = "id = ?";
        Object[] params = { this.id };
        String sql = "DELETE FROM " + table + " WHERE " + whereClause;
        try (Connection conn = MysqlConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public Map<String, Object> toSql() {
        Map<String, Object> columnValueMap = new LinkedHashMap<>();
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                String columnName = convertToColumnName(field.getName());
                Object value = field.get(this);
                columnValueMap.put(columnName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return columnValueMap;
    }

    //Atributos como por ejemplo fechaCreado en la base se denominan fecha_creado
    private String convertToColumnName(String fieldName) {
        StringBuilder columnName = new StringBuilder();
        for (char c : fieldName.toCharArray()) {
            if (Character.isUpperCase(c)) {
                columnName.append('_').append(Character.toLowerCase(c));
            } else {
                columnName.append(c);
            }
        }
        return columnName.toString();
    }
    

    
    
}
