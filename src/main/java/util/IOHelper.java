package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import com.nju.data.RiskDao;
import com.nju.data.StudentDao;
import com.nju.model.Risk;
import com.nju.model.Student;

public class IOHelper {
	private static ArrayList<String> getStringFromFile(File f, String charset) throws IOException {
		ArrayList<String> lines = new ArrayList<String>() ;
		FileInputStream fis = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(fis, charset);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine()) != null) {
			lines.add(line) ;
		}
		br.close();
		isr.close();
		fis.close();
		return lines ;
	}
	public static ArrayList<Risk> getAllRisks(){
		ArrayList<Risk> risks = new ArrayList<Risk>() ;
		try {
			ArrayList<String> lines = getStringFromFile(new File("risk.txt"), "UTF-8") ;
			for(String line:lines){
				String[] words = line.split(",") ;
				Risk risk = new Risk(Integer.parseInt(words[0]), words[1],  words[2],  words[3],  words[4],  words[5],  words[6],  words[7],  words[8]) ;
				risks.add(risk) ;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return risks ;
	}
	public static ArrayList<Student> getAllStudents(){
		ArrayList<Student> students = new ArrayList<Student>() ;
		try {
			ArrayList<String> lines = getStringFromFile(new File("student.txt"), "UTF-8") ;
			for(String line:lines){
				String[] words = line.split(",") ;
				Student student = new Student(Integer.parseInt(words[0]), words[1],  words[2].charAt(0),  words[3],  words[4]) ;
				students.add(student) ;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students ;
	}
	public static void saveObject(ArrayList<Object> objects,String fileName,Class clazz){
		try {
			FileOutputStream fos = new FileOutputStream(new File(fileName)) ;
			for(Object object:objects){
				String line = "" ;
				Field[] fs = clazz.getDeclaredFields() ;
				for(int i=0;i<fs.length;i++){
					Field f = fs[i] ;
					f.setAccessible(true) ;
					Object value = f.get(object) ;
					line += (value.toString()+",") ;
				}
				line.substring(0, line.length()-1) ;
				line += "\n" ;
				fos.write(line.getBytes("UTF-8")) ;
				fos.close() ;
				System.out.println("输出完毕");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		RiskDao rd = new RiskDao() ;
		StudentDao sd = new StudentDao() ;
		IOHelper.saveObject((ArrayList)rd.getAllRisks(), "risk.txt", Risk.class) ;
		IOHelper.saveObject((ArrayList)sd.getAllStudents(), "student.txt", Student.class) ;
	}
}
