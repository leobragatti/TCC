import java.sql.*;

public class Conexao {
	
	Connection conn = null;
	public Conexao() throws Exception{
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tcc","postgres","voices");
	}
	
	public void incluir(int idPessoa, byte[] digital){
		PreparedStatement st;
		try {
			st = conn.prepareStatement("INSERT INTO \"PessoaDigital\"(\"idPessoa\", \"digital\") VALUES(?, ?)");
			st.setInt(1, idPessoa);
			st.setBytes(2, digital);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public byte[] buscar(){
		ResultSet rs;
		PreparedStatement st;
		byte[] digital = null;
		try {
			st = conn.prepareStatement("SELECT * FROM \"PessoaDigital\"");
			rs = st.executeQuery();
			if(rs.next())
				digital = rs.getBytes("digital");
			else
				System.out.println("Registro não encontrado");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return digital;
	}
}
