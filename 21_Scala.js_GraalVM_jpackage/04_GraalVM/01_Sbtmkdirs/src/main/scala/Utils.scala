package sbtmkdirs

import java.io.File
import scala.io.StdIn.readLine

object Utils:

    /**
     * stay in a loop until you have a valid project name.
     * `defaultProjectName` may well be blank.
     */
    def getProjectName(defaultProjectName: String): String =

        var lastProjectName = defaultProjectName
        var newProjectName = ""
        val invalidProjectNameMsg = "Invalid project name (can’t contain blank spaces).\n"
        val projectNameCantBeBlankMsg = "Project Name can’t be blank.\n"

        while true do

            promptForProjectName(lastProjectName)
            newProjectName = readLine()

            // two situations: gave us a blank name, or some text
            if isBlank(newProjectName) then
                if isValidProjectName(lastProjectName) then
                    // didn’t supply a new project name, they want to accept the default
                    return lastProjectName
                else
                    // newProjectName is blank and lastProjectName is invalid
                    System.err.println(projectNameCantBeBlankMsg)
                    lastProjectName = ""
                end if
            else
                // gave us a new newProjectName
                if isValidProjectName(newProjectName) then
                    return newProjectName  //name is valid, return it
                else
                    // they gave you a new name, but it’s not valid
                    System.err.println(invalidProjectNameMsg)
                    lastProjectName = ""
                end if
            end if

        end while

        ""  //to make the compiler happy
    end getProjectName


    def isValidProjectName(name: String): Boolean =
        if name.trim == "" then
            false
        else if containsWhitespace(name) then 
            false 
        else 
            true

    def containsWhitespace(s: String): Boolean = s.matches(".*\\s.*")
    def booleanAsYOrN(b: Boolean) = if b then "y" else "n"
    def createDir(canonDirName: String): Boolean = (File(canonDirName)).mkdir
    def createDirs(canonDirName: String): Boolean = (File(canonDirName)).mkdirs

    def isYes(userInput: String, default: Boolean): Boolean =
        if userInput.trim.equalsIgnoreCase("Y") || userInput.trim.equalsIgnoreCase("yes") then
            true
        else if userInput.trim.equalsIgnoreCase("N") || userInput.trim.equalsIgnoreCase("no") then
            false
        else if isBlank(userInput) then
            default
        else
            // note that the user can type in "foo" or anything else
            default
        end if

    def isBlank(s: String): Boolean = s.trim == ""

    def promptForProjectName(currentProjectName: String): Unit =
        if currentProjectName == "" then
            print(s"Directory/Project Name: ")
        else
            print(s"Directory/Project Name ($currentProjectName): ")
        end if


