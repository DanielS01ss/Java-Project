import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;
import java.io.File;

enum LOAD_TYPE {
	HARDCODAT, KEYBOARD, FILE
}

enum DISPLAY_TYPE  {
	CONSOLA, FISIER, GUI
}

enum ACCOUNT_TYPE{
	STUDENT,PROFESOR
}

public class TestClass {
	public static void main(String[] args) {
		
		IDisplayManager displayManager = Settings.displayHashMap.get(Settings.displayType);
		IDataLoader dataManager = Settings.dataLoaderHashMap.get(Settings.loadType);
		displayManager.displayStudents(dataManager.createStudentsData());
		String accountData = Cont.logInPerson("Daniel", "Parola123");
		if(accountData!=null)
		{
			String[]s = accountData.split(",");
			if(Integer.parseInt(s[2])==0)
			{
				//cazul in care este student
			}else if(Integer.parseInt(s[2])==1)
			{
				///listeaza cursuri
				//studentii la cursuri
				///noteaza un student
			}
		}
		
	}
}
