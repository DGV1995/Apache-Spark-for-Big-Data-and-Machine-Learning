import org.apache.spark.sql.SparkSession;

val spark = SparkSession.builder().getOrCreate();
val df = spark.read.option("header","true").option("inferSchema","true").csv("../Data/ContainsNull.csv");

df.printSchema();
df.show();

// Remove every rows that have any null value
df.na.drop().show();
// Remove every rows that have 2 or more null values
df.na.drop(2).show();

df.show();
// Fill with value 100 every null number columns
df.na.fill(100).show();
df.na.fill("Peter").show();
val df2 = df.na.fill("New name", Array("Name"));
df2.na.fill(400, Array("Sales")).show();
