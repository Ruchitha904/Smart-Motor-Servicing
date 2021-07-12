import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class aservice extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String ff=request.getParameter("ffname");
String fff=request.getParameter("fffname");
try
{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into aservice values(?,?)");  
  
ps.setString(1,ff);
ps.setString(2,fff);
        
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully...");  
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}
