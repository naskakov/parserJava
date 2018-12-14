package parser;

import java.io.File;
import java.io.IOException;
//import java.io.PrintWriter;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

//import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ParserDOM {
	public static void main(String[] args) throws IOException {
	Random random = new Random();
	// Random random1 = new Random();
	String a[] = { "Ermakovich", "Kovalevich", "Busko", "Kindruck", "Lavrynovych", "Kotsuba", "Melanic", "Sumar",
			"Sumarevich" };
	String b[] = { "Victor", "Artem", "Oleg", "Alexander", "Ivan", "Maxim", " Vlad" };
	String c[] = { "football", "hockey"  };
	String d[] = { "goalkeeper", "defender", "centre forward", "extreme forward" };
	String e[] = { "Anatolyevich", "Aleksandrovich", "Vladimirovich", "Viktorovich", "Dmitrievich", "Sergeevich" };
	String  f[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" };
	String g[] = { "main", " spare" };
	String h[] = { "1st uneshaesky", "2nd digit", "3rd digit", "KMS", "master of sports" };
	try {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

		// Корневой элемент
		Document document = documentBuilder.newDocument();
		Element rootElement = document.createElement("sport");
		document.appendChild(rootElement);
		for (int i = 0; i < 100; i++) {
			// Child's корневого элемента
			Element sport_info = document.createElement("sport_info");
			rootElement.appendChild(sport_info);

			// Установка атрибута элемента blog
			// Attr attr = document.createAttribute("id");
			// attr.setValue("1");
			// stud_info.setAttributeNode(attr);

			Element first_name_student = document.createElement("name");
			first_name_student.appendChild(document.createTextNode(b[random.nextInt(7)]));
			sport_info.appendChild(first_name_student);
			
			Element last_name_student = document.createElement("surname");
			last_name_student.appendChild(document.createTextNode(a[random.nextInt(9)]));
			sport_info.appendChild(last_name_student);
			
			Element patronymic_student = document.createElement("patronymic");
			patronymic_student.appendChild(document.createTextNode(e[random.nextInt(6)]));
			sport_info.appendChild(patronymic_student);
			
			Element birthday = document.createElement("title");
			birthday.appendChild(document.createTextNode(f[random.nextInt(20)]));
			sport_info.appendChild(birthday);

			Element composition = document.createElement("composition");
			composition.appendChild(document.createTextNode(g[random.nextInt(2)]));
			sport_info.appendChild(composition);

			Element faculty = document.createElement("typeOfSport");
			faculty.appendChild(document.createTextNode(c[random.nextInt(2)]));
			sport_info.appendChild(faculty);

			

			

			Element position = document.createElement("rasryad");
			position.appendChild(document.createTextNode(h[random.nextInt(5)]));
			sport_info.appendChild(position);

			

			Element team = document.createElement("position");
			team.appendChild(document.createTextNode(d[random.nextInt(4)]));
			sport_info.appendChild(team);
		}
		// Теперь запишем контент в XML файл
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource domSource = new DOMSource(document);
		StreamResult streamResult = new StreamResult(new File("iblog.xml"));

		transformer.transform(domSource, streamResult);
		System.out.println("Файл сохранен!");
	} catch (ParserConfigurationException pce) {
		System.out.println(pce.getLocalizedMessage());
		pce.printStackTrace();
	} catch (TransformerException te) {
		System.out.println(te.getLocalizedMessage());
		te.printStackTrace();
	}

}
} 
