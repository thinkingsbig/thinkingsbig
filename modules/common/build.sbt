name := "common"

version := "BUILD"

sources in (Compile, doc) := Seq.empty

publishArtifact in (Compile, packageDoc) := false

// MANAGED DEPENDENCIES
// Each library below is automatically downloaded from one of the resolvers defined in sbt
// See http://www.scala-sbt.org/0.13.2/docs/Getting-Started/Library-Dependencies.html#the-librarydependencies-key
// Libraries in this project are available to all projects
// Dependency is added for example
libraryDependencies ++= Seq(
  javaJdbc,
  cache
  // Add additional dependencies here; uses Apache Ivy info.
)

