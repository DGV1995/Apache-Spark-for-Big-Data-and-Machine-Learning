import org.apache.spark.sql.SparkSession;

val spark = SparkSession.builder().getOrCreate();
val df = spark.read.option("header","true").option("inferSchema","true").csv("../Data/CitiGroup2006_2008");

df.printSchema();

// Get the month
df.select(month(df("Date"))).show();
// Get the year
df.select(year(df("Date"))).show();

val df2 = df.withColumn("Year", year(df("Date")));
val dfavgs = df2.groupBy("Year").mean();
dfavgs.select("Year", "avg(Close)").show();

val df3 = df.withColumn("Year", year(df("Date")));
val dfmins = df3.groupBy("Year").min();
dfmins.select("Year", "min(Close)").show();
