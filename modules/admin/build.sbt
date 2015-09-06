name := "admin"

version := "BUILD"

sources in (Compile, doc) := Seq.empty

publishArtifact in (Compile, packageDoc) := false

libraryDependencies ++= Seq(
      // Add additional dependencies here; uses Apache Ivy info.
      // Example: "com.twilio.sdk" % "twilio-java-sdk" % "3.4.1"
    )

