import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName = "angularlynda"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
    "commons-io" % "commons-io" % "2.4"
    //"com.fasterxml.jackson.core" % "jackson-databind" % "2.0.2"

  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here

   )

}
