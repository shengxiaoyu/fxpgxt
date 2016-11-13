package com.nju.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.nju.model.Course;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.util.XMLErrorHandler;
import org.xml.sax.SAXException;

public class DepartBRequireImpl implements RequireService {

	private CenterService centerservice = null;
	
	public DepartBRequireImpl(){
		try {
			centerservice = (CenterService) Naming.lookup("rmi://localhost:8010/centerMain");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Map<String, List<Course>> getOtherCourses(int studentId) {
		List<Course> alist = getAShareCourses(studentId,true);
		List<Course> clist = getCShareCourses(studentId,true);
		Map<String, List<Course>> m = new HashMap<String, List<Course>>();
		m.put("A",alist);
		m.put("C", clist);
		return m;
	}

	@Override
	public List<Course> getMyOtherCourses(int studentId) {
		List<Course> alistAll = getAShareCourses(studentId,false);
		List<Course> clistAll = getCShareCourses(studentId,false);
		ArrayList<Course> res = new ArrayList<Course>();
		res.addAll(alistAll);
		res.addAll(clistAll);
		return res;
	}

	@Override
	public boolean chooseOtherCourse(int studentId, int courseId,
			String department) throws RemoteException{
		if(department.equals("A")){
			return centerservice.chooseACourse(studentId, courseId);
		}else{
			return centerservice.chooseCCourse(studentId, courseId);
		}
	}

	@Override
	public boolean dropOtherCourse(int studentId, int courseId,
			String department) throws RemoteException{
		if(department.equals("A")){
			return centerservice.dropACourse(studentId, courseId);
		}else{
			return centerservice.dropCCourse(studentId, courseId);
		}
	}
	
	
	
	
	
	private List<Course> getAShareCourses(int studentId,boolean all){
		try {
			List<Course> res = new ArrayList<Course>();
			Document doc = DocumentHelper.parseText(centerservice.BgetASharedCourse(studentId));
			Writer w = new FileWriter("departBGetAShareCourse.xml");
			OutputFormat opf = OutputFormat.createPrettyPrint();
			opf.setEncoding("UTF-8");
			XMLWriter xw = new XMLWriter(w, opf);
			xw.write(doc);
			xw.close();
			w.close();
			SAXReader saxReader = new SAXReader();
			saxReader.setValidation(true);
			saxReader.setFeature("http://xml.org/sax/features/validation", true);
			saxReader.setFeature("http://apache.org/xml/features/validation/schema",true);
			saxReader.setProperty("http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation", "departBCourse.xsd");
			XMLErrorHandler errorHandler = new XMLErrorHandler();
			saxReader.setErrorHandler(errorHandler);
			Document document = saxReader.read(new File("departBGetAShareCourse.xml"));
			XMLWriter writer = new XMLWriter(OutputFormat.createPrettyPrint());
			if(errorHandler.getErrors().hasContent()){
				writer.write(errorHandler.getErrors());	
				return null;
			}
			Element root = document.getRootElement();
			for(Iterator i = root.elementIterator();i.hasNext();){
				Element foo = (Element) i.next();
				ArrayList<String> list = new ArrayList<String>();
				for(Iterator j = foo.elementIterator();j.hasNext();){
					Element tmp = (Element) j.next();
					list.add(tmp.getStringValue());
				}
				int id  =Integer.parseInt(list.get(0));
				String name = list.get(1);
				int point = Integer.parseInt(list.get(3));
				int time = Integer.parseInt(list.get(2));
				String teacher = list.get(4);
				String place = list.get(5);
				int share = Integer.parseInt(list.get(6));
				
				Course co = new Course(id,name,point,teacher,place,share,time);
				if(all||(share == 2)){
					res.add(co);
				}
			}
			return res;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
	
	
	
	
	private List<Course> getCShareCourses(int studentId,boolean all){
		try {
			List<Course> res = new ArrayList<Course>();
			Document doc = DocumentHelper.parseText(centerservice.BgetCSharedCourse(studentId));
			Writer w = new FileWriter("departBGetCShareCourse.xml");
			OutputFormat opf = OutputFormat.createPrettyPrint();
			opf.setEncoding("UTF-8");
			XMLWriter xw = new XMLWriter(w, opf);
			xw.write(doc);
			xw.close();
			w.close();
			SAXReader saxReader = new SAXReader();
			saxReader.setValidation(true);
			saxReader.setFeature("http://xml.org/sax/features/validation", true);
			saxReader.setFeature("http://apache.org/xml/features/validation/schema",true);
			saxReader.setProperty("http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation", "departBCourse.xsd");
			XMLErrorHandler errorHandler = new XMLErrorHandler();
			saxReader.setErrorHandler(errorHandler);
			Document document = saxReader.read(new File("departBGetCShareCourse.xml"));
			XMLWriter writer = new XMLWriter(OutputFormat.createPrettyPrint());
			if(errorHandler.getErrors().hasContent()){
				writer.write(errorHandler.getErrors());	
				return null;
			}
			Element root = document.getRootElement();
			for(Iterator i = root.elementIterator();i.hasNext();){
				Element foo = (Element) i.next();
				ArrayList<String> list = new ArrayList<String>();
				for(Iterator j = foo.elementIterator();j.hasNext();){
					Element tmp = (Element) j.next();
					list.add(tmp.getStringValue());
				}
				int id  =Integer.parseInt(list.get(0));
				String name = list.get(1);
				int point = Integer.parseInt(list.get(3));
				int time = Integer.parseInt(list.get(2));
				String teacher = list.get(4);
				String place = list.get(5);
				int share = Integer.parseInt(list.get(6));
				
				Course co = new Course(id,name,point,teacher,place,share,time);
				if(all||(share == 2)){
					res.add(co);
				}
			}
			return res;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
}

