import org.apache.spark.sql.SparkSession;

val spark = SparkSession.builder().getOrCreate();
val df = spark.read.option("header","true").option("inferSchema","true").csv("../Data/Sales.csv");

df.printSchema();
df.show();

df.groupBy("Company").count().show();
df.groupBy("Company").mean().show(); // Average of numeric columns
df.groupBy("Company").max().show();
df.groupBy("Company").min().show();
df.groupBy("Company").sum().show();

df.select(sum("Sales")).show();

// Order by Sales column in descending order
df.orderBy($"Sales".desc).show();

// Other Aggregate Functions
// http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.functions$
