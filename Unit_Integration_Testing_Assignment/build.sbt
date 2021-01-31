name := "Unit_Integration_Testing_Assignment"

version := "0.1"

scalaVersion := "2.13.4"

lazy val UniTesting = project.in(file("UnitTesting"))
  .settings(
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.3" % Test
  )

lazy val UnitTesting_IntegrationTesting = project.in(file("UnitTesting_IntegrationTesting"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.3" % Test,
      "org.mockito" %% "mockito-scala" % "1.5.12" % Test
    )
  )

lazy val root = project.in(file(".")).aggregate(UniTesting,UnitTesting_IntegrationTesting)