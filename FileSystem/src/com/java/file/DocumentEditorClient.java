package com.java.file;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class DocumentEditor {
	private List<String> documentElement;
	private String renderDocument;

	public DocumentEditor() {
		super();
		this.documentElement = new ArrayList<String>();
		this.renderDocument = "";
	}

	// Adds text as a plain string
	public void addText(String text) {
		documentElement.add(text);
	}
	// Adds an image represented by its file path

	public void addImage(String imagepath) {
		documentElement.add(imagepath);
	}

	// Renders the document by checking the type of each element at runtime

	public String renderDocument() {
		if (renderDocument.isEmpty()) {

			StringBuilder result = new StringBuilder();

			for (String element : documentElement) {
				if (element.length() > 4 && (element.endsWith(".png") || element.endsWith(".jpg"))) {
					result.append("[Image:").append(element).append("]\n");
				} else {
					result.append(element).append("\n");
				}
			}
			renderDocument = result.toString();

		}

		return renderDocument;
	}

	public void saveToFile() {

		FileWriter writer;
		try {
			writer = new FileWriter("document.txt");
			writer.write(renderDocument());
			writer.close();
			System.out.println("Document saved to document.txt");

		} catch (IOException e) {
			System.out.println("Error : Unable to open file for Writing.");
		}
	}
}

public class DocumentEditorClient {

	public static void main(String args[]) {

		DocumentEditor editor = new DocumentEditor();
		editor.addText("Hello world we are adding text .");
		editor.addImage("picture.jpg");
		editor.addText("This is document editor");
		System.out.println(editor.renderDocument());
		editor.saveToFile();
	}

}