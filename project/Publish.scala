import sbt._, Keys._

object Publish {
  val settings = Seq[Setting[_]](
    publishMavenStyle := true,
    publishTo := {
      if (isSnapshot.value)
        Some(Opts.resolver.sonatypeSnapshots)
      else
        Some(Opts.resolver.sonatypeStaging)
    },
    licenses := Seq(
      "Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")
    ),
    scmInfo := Some(ScmInfo(
      browseUrl  = url("https://github.com/kxbmap/lombok-java8-extensions"),
      connection = "scm:git:git@github.com:kxbmap/lombok-java8-extensions.git"
    )),
    homepage              := Some(url("https://github.com/kxbmap/lombok-java8-extensions")),
    organizationHomepage  := Some(url("https://github.com/kxbmap")),
    pomIncludeRepository  := { _ => false },
    pomExtra :=
      <developers>
        <developer>
          <id>kxbmap</id>
          <name>Tsukasa Kitachi</name>
          <url>https://github.com/kxbmap</url>
        </developer>
      </developers>
  )
}
