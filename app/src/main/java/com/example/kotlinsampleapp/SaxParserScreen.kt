package com.example.kotlinsampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xml.sax.SAXException
import java.io.IOException
import java.io.InputStream
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException

class SaxParserScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sax_parser_screen)

        val btnNext = findViewById<Button>(R.id.next)

        btnNext.setOnClickListener(){
            intent = Intent(this,SaxParserScreen::class.java)
            startActivity(intent)
        }

        // Try and Catch for avoiding the application to crash
        try {

            // This list will contain the data from the information.xml file
            val userList: ArrayList<HashMap<String, String?>> = ArrayList()

            // This listView will display the data from the information.xml file
            val lv = findViewById<ListView>(R.id.listView)

            // The information.xml file will be taken in the form of input stream
            val istream: InputStream = assets.open("users.xml")

            // Steps to convert this input stream into a list
            val builderFactory: DocumentBuilderFactory = DocumentBuilderFactory.newInstance()
            val docBuilder: DocumentBuilder = builderFactory.newDocumentBuilder()
            val doc: Document = docBuilder.parse(istream)
            val nList: NodeList = doc.getElementsByTagName("user")

            // Iterating through this list
            for (i in 0 until nList.length) {
                if (nList.item(0).nodeType === Node.ELEMENT_NODE) {
                    val user: HashMap<String, String?> = HashMap()
                    val elm: Element = nList.item(i) as Element
                    user["name"] = getNodeValue("name", elm)
                    user["designation"] = getNodeValue("designation", elm)
                    userList.add(user)
                }
            }

            // Using Adapter to broadcast the information extracted
            val adapter: ListAdapter = SimpleAdapter(
                this,
                userList,
                R.layout.list,
                arrayOf("name", "designation"),
                intArrayOf(R.id.name, R.id.designation)
            )
            lv.adapter = adapter
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ParserConfigurationException) {
            e.printStackTrace()
        } catch (e: SAXException) {
            e.printStackTrace()
        }
    }

    // A function to get the node value while parsing
    private fun getNodeValue(tag: String?, element: Element): String? {
        val nodeList = element.getElementsByTagName(tag)
        val node = nodeList.item(0)
        if (node != null) {
            if (node.hasChildNodes()) {
                val child = node.firstChild
                while (child != null) {
                    if (child.nodeType == Node.TEXT_NODE) {
                        return child.nodeValue
                    }
                }
            }
        }
        // Returns nothing if nothing was found
        return ""
    }
}