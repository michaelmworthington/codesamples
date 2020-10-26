import Dependencies._

logLevel := Level.Debug

//resolvers += "Nexus" at "http://localhost:8083/nexus/repository/maven-public/"
externalResolvers := List("Nexus" at "http://localhost:8083/nexus/repository/maven-public/")


lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
    libraryDependencies += scalaTest % Test,

    libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.18",

    //libraryDependencies += "com.typesafe" % "play-plugins-mailer" % "2.1.0"
    
    libraryDependencies += "commons-io" % "commons-io" % "2.4",

    libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.0.2"

    //libraryDependencies += "com.typesafe.activator" % "activator-common" % "1.0-faa3de1a81a06ea0def6c9b24732f8f937a6a55c"



  )
