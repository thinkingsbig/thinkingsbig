name := """Thinking Bigs"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.webjars" %% "webjars-play" % "2.3.0",
  "org.webjars" % "jquery" % "2.1.3",
  "org.webjars" % "requirejs" % "2.1.11-1",
  "org.webjars" % "angularjs" % "1.3.11" exclude("org.webjars", "jquery"),
  "org.webjars" % "bootstrap" % "3.3.2" exclude("org.webjars", "jquery"),
  "org.webjars" % "angular-bootstrap-datetimepicker" % "0.3.8",
  "org.webjars" % "angular-translate" % "2.7.2"
)     

// SCALA COMPILER OPTIONS
scalacOptions ++= Seq(
  "-feature",                   // Shows warnings in detail in the stdout
  "-language:reflectiveCalls"   // Address the warning generated on the primary route files after introducing subprojects; see https://groups.google.com/d/msg/play-framework/nNr2NdBtWuw/JfbPLaX35XcJ
)


// SETUP MULTIPLE PROJECTS
// sbt and Play Framework support the concept of sub-projects. Each subproject represents a major module in our project.

// Root project. Container for all the projects
lazy val root = (project.in(file(".")))
  .enablePlugins(PlayJava)
  .aggregate(common, admin, user)
  .dependsOn(common, admin, user)

// Contains all files and libraries shared across other projects
lazy val common = (project.in(file("modules/common")))
  .enablePlugins(PlayJava)
  
// Admin Portal
lazy val admin = (project.in(file("modules/admin")))
  .enablePlugins(PlayJava)
  .dependsOn(common)

// Tour Portal
lazy val user = (project.in(file("modules/user")))
  .enablePlugins(PlayJava)
  .dependsOn(common)

pipelineStages := Seq(rjs, digest, gzip)
