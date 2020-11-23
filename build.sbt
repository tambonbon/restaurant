name := "futures_practice"

version := "0.1"

scalaVersion := "2.13.3"
libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % "2.13.3",
  "org.scalatest" %% "scalatest" % "3.2.2" % Test,
  "org.mockito" %% "mockito-scala" % "1.16.3" % Test,
  "net.codingwell" %% "scala-guice" % "4.2.11"
)