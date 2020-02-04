// Use Netflix_2001_2016.csv file

// Start a simple SparkSession
import org.apache.spark.sql.SparkSession;
val spark = SparkSession.builder().getOrCreate();

// Load the file
val df = spark.read.option("header","true").option("inferSchema","true").csv("../Data/Netflix_2001_2016.csv");

// What are the column names?
df.columns;
// What does the schema look like?
df.printSchema();
// Print out the first 5 rows
df.show(5); // or df.head(5);
// Use describe() to learn about the dataframe
df.describe().show();

// Create a new dataframe with a column called HV Ratio that is the ratio of the High Price vs volume of stock
// traded for a day
val df2 = df.withColumn("HV Ratio", df("High")/df("Volume"));
df2.show(5);

// Whay day had the Peak High in Price?
df.orderBy($"High".desc).show();

// What is the mean of th Close column?
df.select(mean("Close")).show();
// What is the max and the min of the Volume column?
df.select(max("Volume")).show();
df.select(min("Volume")).show();

// For scala/Spark $ Syntax
import spark.implicits._;
// How many days was the Close lower than $600?
df.filter("Close < 600").count();
// What percentage of the time was the High greater that $500?
(df.filter("High > 500").count()*1.0 / df.count()) * 100;

// What is the Pearson correlation between High and Volume?
df.select(corr("High", "Volume")).show();

// What is the max High per year?
val df3 = df.withColumn("Year", year(df("Date")));
val yearmaxs = df3.select("Year", "High").groupBy("Year").max();
yearmaxs.select("Year", "max(High)").show()

// What is the average Close for each Calendar month?
val df4 = df.withColumn("Month", month(df("Date")));
val monthavgs = df4.select("Month", "Close").groupBy("Month").mean();
monthavgs.select("Month", "avg(Close)").orderBy("Month").show();
