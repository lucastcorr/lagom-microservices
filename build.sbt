import com.lightbend.lagom.core.LagomVersion
import sbt.Keys.javacOptions

val buildOrganization = "pt.timestamp.challenge"

version in ThisBuild := "1.0.0"

organization in ThisBuild := buildOrganization

scalaVersion in ThisBuild := "2.12.6"

javacOptions in ThisBuild := Seq("-parameters")

updateOptions in ThisBuild := updateOptions.value.withGigahorse(false)

/* ********************************************************************************************** */
/* ****************************************** VERSIONS ****************************************** */
/* ********************************************************************************************** */


val userAPIVersion = "1.0.0"
val userIMPLVersion = "1.0.0"

val postAPIVersion = "1.0.0"
val postIMPLVersion = "1.0.0"

val emojiAPIVersion = "1.0.0"
val emojiIMPLVersion = "1.0.0"

val notificationAPIVersion = "1.0.0"
val notificationIMPLVersion = "1.0.0"

/* ********************************************************************************************** */
/* ************************************** DEV CONFIGURATIONS ************************************ */
/* ********************************************************************************************** */



lagomKafkaEnabled in ThisBuild := true
lagomCassandraPort in ThisBuild := 4011
lagomCassandraJvmOptions in ThisBuild := Seq("-Dcassandra.jmx.local.port=4100")

lagomCassandraCleanOnStart in ThisBuild := true

/* ********************************************************************************************** */
/* ***************************************** DEPENDENCIES *************************************** */
/* ********************************************************************************************** */

val junit5Version = "5.3.1"
val configurations = "com.typesafe" % "config" % "1.3.0"

val akkaCluster = "com.typesafe.akka" %% "akka-cluster-tools" % "2.5.15"
val junit5Jupiter = Seq("org.junit.jupiter" % "junit-jupiter-api" % junit5Version % Test,
  "org.junit.jupiter" % "junit-jupiter-params" % junit5Version % Test,
  "org.junit.jupiter" % "junit-jupiter-engine" % junit5Version % Test
)

val junitInterface = Seq("org.junit.platform" % "junit-platform-runner" % "1.3.2" % Test,
  "net.aichler" % "jupiter-interface" % "0.8.2" % Test
)

val lombok = "org.projectlombok" % "lombok" % "1.18.22"
val vavr = "io.vavr" % "vavr" % "0.10.4"
val vavrJackson = "io.vavr" % "vavr-jackson" % "0.10.3"



/* ********************************************************************************************** */
/* ************************************** PROJECT DEFINITION ************************************ */
/* ********************************************************************************************** */

lazy val `challenge-backend` = (project in file("."))
  .aggregate(
    `user-api`, `user-impl`,
    `post-api`, `post-impl`,
    `emoji-api`, `emoji-impl`,
    `notification-api`, `notification-impl`,
  )

/* ********************************************************************************************** */
/* ***************************************** USER SERVICE *************************************** */
/* ********************************************************************************************** */


lazy val `user-api` = (project in file("user-api"))
  .enablePlugins(BuildInfoPlugin)
  .settings(
    version := userAPIVersion,
    libraryDependencies ++= Seq(
      lagomJavadslApi,
      lagomJavadslJackson,
      configurations,
      vavr,
      vavrJackson,
      lombok
    ),
    libraryDependencies ++= junit5Jupiter,
    libraryDependencies ++= junitInterface
  )

lazy val `user-impl` = (project in file("user-impl"))
  .enablePlugins(LagomJava, BuildInfoPlugin)
  .settings(
    version := userIMPLVersion,
    libraryDependencies ++= Seq(
      lagomJavadslJackson,
      lagomJavadslPersistenceCassandra,
      lagomJavadslKafkaBroker,
      lagomLogback,
      lagomJavadslTestKit,
      lagomJavadslCluster,
      filters,
      configurations,
      logback
    ),
    libraryDependencies ++= junit5Jupiter,
    libraryDependencies ++= junitInterface,
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`user-api`)



/* ********************************************************************************************** */
/* ***************************************** POST SERVICE *************************************** */
/* ********************************************************************************************** */


lazy val `post-api` = (project in file("post-api"))
  .enablePlugins(BuildInfoPlugin)
  .settings(
    version := postAPIVersion,
    libraryDependencies ++= Seq(
      lagomJavadslApi,
      lagomJavadslJackson,
      configurations,
      vavr,
      vavrJackson,
      lombok
    ),
    libraryDependencies ++= junit5Jupiter,
    libraryDependencies ++= junitInterface
  )

lazy val `post-impl` = (project in file("post-impl"))
  .enablePlugins(LagomJava, BuildInfoPlugin)
  .settings(
    version := userIMPLVersion,
    libraryDependencies ++= Seq(
      lagomJavadslJackson,
      lagomJavadslPersistenceCassandra,
      lagomJavadslKafkaBroker,
      lagomLogback,
      lagomJavadslTestKit,
      lagomJavadslCluster,
      filters,
      configurations,
      logback
    ),
    libraryDependencies ++= junit5Jupiter,
    libraryDependencies ++= junitInterface,
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`post-api`)

/* ********************************************************************************************** */
/* ***************************************** EMOJI SERVICE ************************************** */
/* ********************************************************************************************** */


lazy val `emoji-api` = (project in file("emoji-api"))
  .enablePlugins(BuildInfoPlugin)
  .settings(
    version := emojiAPIVersion,
    libraryDependencies ++= Seq(
      lagomJavadslApi,
      lagomJavadslJackson,
      configurations,
      vavr,
      vavrJackson,
      lombok
    ),
    libraryDependencies ++= junit5Jupiter,
    libraryDependencies ++= junitInterface
  )

lazy val `emoji-impl` = (project in file("emoji-impl"))
  .enablePlugins(LagomJava, BuildInfoPlugin)
  .settings(
    version := emojiIMPLVersion,
    libraryDependencies ++= Seq(
      lagomJavadslJackson,
      lagomJavadslPersistenceCassandra,
      lagomJavadslKafkaBroker,
      lagomLogback,
      lagomJavadslTestKit,
      lagomJavadslCluster,
      filters,
      configurations,
      logback
    ),
    libraryDependencies ++= junit5Jupiter,
    libraryDependencies ++= junitInterface,
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`emoji-api`)

/* ********************************************************************************************** */
/* ************************************* NOTIFICATION SERVICE *********************************** */
/* ********************************************************************************************** */

lazy val `notification-api` = (project in file("notification-api"))
  .enablePlugins(BuildInfoPlugin)
  .settings(
    version := notificationAPIVersion,
    libraryDependencies ++= Seq(
      lagomJavadslApi,
      lagomJavadslJackson,
      configurations,
      vavr,
      vavrJackson,
      lombok
    ),
    libraryDependencies ++= junit5Jupiter,
    libraryDependencies ++= junitInterface
  )

lazy val `notification-impl` = (project in file("notification-impl"))
  .enablePlugins(LagomJava, BuildInfoPlugin)
  .settings(
    version := notificationIMPLVersion,
    libraryDependencies ++= Seq(
      lagomJavadslJackson,
      lagomJavadslPersistenceCassandra,
      lagomJavadslKafkaBroker,
      lagomLogback,
      lagomJavadslTestKit,
      lagomJavadslCluster,
      filters,
      configurations,
      logback
    ),
    libraryDependencies ++= junit5Jupiter,
    libraryDependencies ++= junitInterface,
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`notification-api`)