name := "test"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "mysql" % "mysql-connector-java" % "5.1.18",
   "org.mindrot" % "jbcrypt" % "0.3m",
   "net.logstash.logback" % "logstash-logback-encoder" % "3.2"
)



play.Project.playJavaSettings
