package com.alvinalexander.myapp

import java.awt.{ BorderLayout, Dimension }
import javax.swing.*
import javax.swing.SwingUtilities

@main def mySwingApp =
  val frame      = JFrame("My App")
  val textArea   = JTextArea("Hello, Scala 3 world")
  val scrollPane = JScrollPane(textArea)
  SwingUtilities.invokeLater(new Runnable {
    def run =
      frame.getContentPane.add(scrollPane, BorderLayout.CENTER)
      frame.setSize(Dimension(400, 300))
      frame.setLocationRelativeTo(null)
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
      frame.setVisible(true)
  })
