package jfsaaved;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateEntry
 */
@WebServlet("/UpdateEntry")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		Vector<Integer> ids = new Vector<Integer>();
		PrintWriter out = response.getWriter();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT `id` FROM `players`");
			while(resultSet.next())
				ids.add(resultSet.getInt("id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String playerID = request.getParameter("id");
		String name = request.getParameter("name");
		String gold = request.getParameter("gold");
		String score = request.getParameter("score");
		String errorMsg = null;
		
		
		if(name == null || name.equals("")){
			errorMsg = "Name can't be null or empty";
		}
		if(gold == null || gold.equals("")){
			errorMsg = "Gold can't be null or empty";
		}
		if(score == null || score.equals("")){
			errorMsg = "Score can't be null or empty";
		}
		
		if(playerID == null){
			try{
	
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `players`(`name`,`gold`,`high_score`) VALUES ( ? , ? , ? )");
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, Integer.parseInt(gold));
				preparedStatement.setInt(3,Integer.parseInt(score));
				boolean returnedObject = preparedStatement.execute();
				
	            if(!returnedObject){
	            	if(!ids.isEmpty()){
	            		out.println(ids.lastElement()+1);
	                	out.println("Insert Successful");
	            	}else{
	            		Statement getLastId = connection.createStatement();
	            		ResultSet rs = getLastId.executeQuery("SELECT * FROM `players`");
	            		while(rs.next())
	            			out.println(rs.getInt("id"));
	            		out.println("Insert Successful");
	            	}
	            }

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.println("Insert Unsuccessful test");
			}
			
		}else{
			try{
				
				PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `players` SET `name`= ? ,`gold`= ? ,`high_score`= ? WHERE `id`= ? ");
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, Integer.parseInt(gold));
				preparedStatement.setInt(3,Integer.parseInt(score));
				preparedStatement.setInt(4, Integer.parseInt(playerID));
				int success = preparedStatement.executeUpdate();
				out.println(success);
				
				if(success == 1){
					out.println("Update Success");
				}else{
					PreparedStatement addThis = connection.prepareStatement("INSERT INTO `players`(`name`,`gold`,`high_score`) VALUES ( ? , ? , ? )");
					addThis.setString(1, name);
					addThis.setInt(2, Integer.parseInt(gold));
					addThis.setInt(3,Integer.parseInt(score));
					boolean returnedObject = addThis.execute();
					
		            if(!returnedObject){
		            	if(!ids.isEmpty()){
		            		out.println(ids.lastElement()+1);
		                	out.println("Insert Successful");
		            	}else{
		            		Statement getLastId = connection.createStatement();
		            		ResultSet rs = getLastId.executeQuery("SELECT * FROM `players`");
		            		while(rs.next())
		            			out.println(rs.getInt("id"));
		            		out.println("Insert Successful");
		            	}
		            }
				}
	            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.println("Update Unsuccessful");
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
