package sbtmkdirs

import scala.io.StdIn.readLine
import java.io.File
import FileUtils.SLASH
import Utils.*

final var projectName          = ""
final var bCreateGitignoreFile = false
final var bCreateReadmeFile    = false
final var bCreateResourcesDir  = false
final var bCreateJavaDir       = false
final var bCreateScalaTestFile = false
final var bGoAhead             = false

@main def Sbtmkdirs(args: String*) =

  if args.length == 1 then projectName = args(0)

  // print("This script creates an SBT project directory beneath the current directory.")

  while !bGoAhead do

    println("")
    projectName = getProjectName(projectName)

    val sCreateGitignoreFile = readLine("Create .gitignore File? (Y/n): ")
    bCreateGitignoreFile = isYes(sCreateGitignoreFile, true)

    val sCreateReadmeFile = readLine("Create README.md File? (Y/n): ")
    bCreateReadmeFile = isYes(sCreateReadmeFile, true)

    val sCreateResourcesDir = readLine("Create ‘resources’ subdirs? (y/N): ")
    bCreateResourcesDir = isYes(sCreateResourcesDir, false)

    val sCreateJavaDir = readLine("Create ‘java’ subdirs? (y/N): ")
    bCreateJavaDir = isYes(sCreateJavaDir, false)

    val summary = s"""
        |-----------------------------------------------
        |Directory/Project name:   ${projectName}
        |Create .gitignore file?:  ${booleanAsYOrN(bCreateGitignoreFile)}
        |Create README.md file?:   ${booleanAsYOrN(bCreateReadmeFile)}
        |Create ‘resources’ dirs?: ${booleanAsYOrN(bCreateResourcesDir)}
        |Create ‘java’ dirs?:      ${booleanAsYOrN(bCreateJavaDir)}
        |-----------------------------------------------
        |Create Project? (Y/n): """.stripMargin
    val sProceed = readLine(summary)

    bGoAhead = isYes(sProceed, true)
  end while
  /*
   * Left the loop, time to create everything.
   * -----------------------------------------
   */

  // create the required dirs and build.sbt
  createDirs(projectName + SLASH + "src" + SLASH + "main" + SLASH + "scala")
  createDirs(projectName + SLASH + "src" + SLASH + "test" + SLASH + "scala")
  createDir(projectName + SLASH + "project")
  FileUtils.writeFile(
    projectName + SLASH + "build.sbt",
    Data.buildDotSbtData(projectName)
  )

  // create other dirs as requested
  if bCreateJavaDir then
    createDirs(projectName + SLASH + "src" + SLASH + "main" + SLASH + "java")
    createDirs(projectName + SLASH + "src" + SLASH + "test" + SLASH + "java")

  if bCreateResourcesDir then
    createDirs(projectName + SLASH + "src" + SLASH + "main" + SLASH + "resources")
    createDirs(projectName + SLASH + "src" + SLASH + "test" + SLASH + "resources")

  if bCreateGitignoreFile then
    FileUtils.writeFile(
      projectName + SLASH + ".gitignore",
      Data.gitignoreString
    )

  if bCreateReadmeFile then
    FileUtils.writeFile(
      projectName + SLASH + "README.md",
      Data.readmeData(projectName)
    )

  println("Project created.")
