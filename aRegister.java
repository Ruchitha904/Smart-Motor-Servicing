
import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class aRegister extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String an=request.getParameter("aName");  
String ap=request.getParameter("aPass");  
String ac=request.getParameter("acontact");  
String aa=request.getParameter("aaddress"); 
String av=request.getParameter("abranch");
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into registeradmin values(?,?,?,?,?)");  
  
ps.setString(1,an);  
ps.setString(2,ap);  
ps.setString(3,ac);
ps.setString(4,aa);
ps.setString(5,av);
          
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered...");  
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  

