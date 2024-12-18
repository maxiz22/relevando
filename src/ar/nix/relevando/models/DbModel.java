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

public class DbModel {

	protected Integer id;
    public String getTable() {
    	return "tabla_no_definida";
    }
  
	 
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
    // Método para guardar un registro
	public boolean save() {
	    String table = getTable();
	    Map<String, Object> sqlData = toSql();
	    
	    if (sqlData.isEmpty()) {
	        throw new IllegalStateException("No hay datos para guardar en la base de datos.");
	    }

	    boolean isUpdate = (this.getId() != null && this.getId() > 0); // Determina si es una actualización
	    StringBuilder sql = new StringBuilder();
	    
	    
	    if (isUpdate) {
	        // Construir la consulta SQL para UPDATE
	        sql.append("UPDATE ").append(table).append(" SET ");
	        for (String column : sqlData.keySet()) {
	            sql.append(column).append(" = ?, ");
	        }
	        sql.setLength(sql.length() - 2); // Eliminar la última coma
	        sql.append(" WHERE id = ?"); // Asume que `id` es la clave primaria
	    } else {
	        // Construir la consulta SQL para INSERT
	        sql.append("INSERT INTO ").append(table).append(" (");
	        StringBuilder placeholders = new StringBuilder();
	        for (String column : sqlData.keySet()) {
	            sql.append(column).append(", ");
	            placeholders.append("?, ");
	        }
	        sql.setLength(sql.length() - 2); // Eliminar la última coma
	        placeholders.setLength(placeholders.length() - 2); // Eliminar la última coma
	        sql.append(") VALUES (").append(placeholders).append(")");
	    }
	    
	    try {
	    	Connection conn = MysqlConnection.getConnection();
	        PreparedStatement stmt = conn.prepareStatement(sql.toString(), isUpdate ? PreparedStatement.NO_GENERATED_KEYS : PreparedStatement.RETURN_GENERATED_KEYS);
	         // Asignar valores a los parámetros
	        int index = 1;
	        for (Object value : sqlData.values()) {
	            stmt.setObject(index++, value);
	        }
	        
	        if (isUpdate) {
	            stmt.setObject(index, this.getId()); // Asigna el id al final para el WHERE
	        }

	        int affectedRows = stmt.executeUpdate();

	        if (affectedRows > 0) {
	       
	        	if (!isUpdate) {
	        	     // Obtener id generado
		            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
		                if (generatedKeys.next()) {
		                	 Object generatedId = generatedKeys.getObject(1);
		                	
		                	 this.id = ((Number) generatedId).intValue();
	
		                }
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
        String whereClause = "id = "+idParam;
        String sql = "SELECT * FROM " + table + " WHERE " + whereClause + " LIMIT 1";
        try {
        	Connection conn = MysqlConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Encontrar todos los registros
    public ResultSet findAllFromDb() {
    	String table = getTable();
        String sql = "SELECT * FROM " + table;
        try  {
        	Connection conn = MysqlConnection.getConnection();
        	PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
    }
    
    //Borrar registro
    public boolean deleteFromDb(Integer idParam) {
    	String table = getTable();
        String whereClause = "id = "+idParam;
        String sql = "DELETE FROM " + table + " WHERE " + whereClause;
        try  {
        	System.out.println(sql);
        	Connection conn = MysqlConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //Extraer columnas de los modelos parametrizado
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
