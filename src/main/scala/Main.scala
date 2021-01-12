import java.sql._
import scala.collection.mutable.ListBuffer
object Main extends App {
  var con: Connection = _

  try {
    val connectionString = "jdbc:hive2://localhost:10000/default"
    Class.forName("org.apache.hive.jdbc.HiveDriver")
    con = DriverManager.getConnection(connectionString, "", "")

    val statement = con.createStatement()
    var resultSet = statement.executeQuery("select * from viewcount")

    var viewCountList = ListBuffer[Tuple2[String, Int]]()

    while (resultSet.next) {
      val nameString = resultSet.getString("name")
      val split = nameString.split("\t")
      viewCountList = viewCountList :+ ((split(0), split(1).toInt))
    }
    viewCountList = viewCountList.sortWith(_._2 > _._2)
    println("TOP TEN VIEWED WIKIPEDIA PAGES:")
    println("===============================")
    println(viewCountList(0))
    println(viewCountList(1))
    println(viewCountList(2))
    println(viewCountList(3))
    println(viewCountList(4))
    println(viewCountList(5))
    println(viewCountList(6))
    println(viewCountList(7))
    println(viewCountList(8))
    println(viewCountList(9))
    println("===============================")
  } catch {
    case e: Exception => e.printStackTrace()
  } 
  
  con.close();
}