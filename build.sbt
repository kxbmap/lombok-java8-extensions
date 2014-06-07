name := "lombok-java8-extensions"

version := "1.0-SNAPSHOT"

autoScalaLibrary := false

crossPaths := false

Seq(Compile, Test) map { c =>
  unmanagedSourceDirectories in c := Seq((javaSource in c).value)
}

javacOptions ++= Seq(
  "-encoding", "utf8",
  "-source", "1.8",
  "-target", "1.8",
  "-deprecation",
  "-Xlint:all,-processing"
)

libraryDependencies ++= Seq(
  "org.projectlombok" % "lombok" % "1.14.0" % "provided",
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.10" % "test"
)
