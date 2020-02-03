import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate();
val df = spark.read.option("header","true").option("inferSchema","true").csv("../Data/CitiGroup2006_2008");
df.printSchema();

/////////////////////
/////////////////////
import spark.implicits._

df.filter("Close > 480").show();
// df.filter($"Close" > 480 && $"High" < 480); // Scala
df.filter("Close < 480 AND High < 480").show(); // Spark SQL

// Save the filtered data into a scala object --> Array object
val filtered = df.filter("Close < 480 AND High < 480").collect();

// Correlation matrix
df.select(corr("High", "Low")).show();

// Operations and Useful Functions
// http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.functions$
