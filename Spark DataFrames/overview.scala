import org.apache.spark.sql.SparkSession

// Spark session
val spark = SparkSession.builder().getOrCreate();

val df = spark.read.option("header","true").option("inferSchema","true").csv("../Data/CitiGroup2006_2008");

df.head(5);
df.columns;
df.describe().show();

// Show existing columns
df.select("Volume").show();
df.select("Date", "Close").show();

// Create a new column
val df2 = df.withColumn("HighPlusLow", df("High") + df("Low"));
df2.printSchema();
// Alias for a column
df2.select(df2("HighPlusLow").as("HPL")).show()
