resolvers += Resolver.jcenterRepo

// The Lagom plugin
addSbtPlugin("com.lightbend.lagom" % "lagom-sbt-plugin" % "1.5.5")
// Needed for importing the project into Eclipse
//addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")
// Platform Tooling plugin
//addSbtPlugin("com.lightbend.rp" % "sbt-reactive-app" % "1.6.1")//lightbend reactive platform was discontinued and removed support on lagom 1.5
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.4.0") //1.3.5
// Sbt-buildinfo generates Scala source from your build definitions.
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.9.0")

addSbtPlugin("net.aichler" % "sbt-jupiter-interface" % "0.8.2")
addSbtPlugin("com.github.sbt" % "sbt-jacoco" % "3.1.0")
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.2")

