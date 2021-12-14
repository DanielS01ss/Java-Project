import java.util.List;

public class Profesor {
	String nume;
	String prenume;
	List<Curs> cursuri;
	
	public Profesor(String nume, String prenume, ManagerCursuri mg) {
		this.nume = nume;
		this.prenume = prenume;
		this.cursuri = mg.getProfessorCourses(this);
	}
	
	public String formatForDisplay() {
		return this.nume + " " + this.prenume;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nume == null) ? 0 : nume.hashCode());
		result = prime * result + ((prenume == null) ? 0 : prenume.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		if (nume == null) {
			if (other.nume != null)
				return false;
		} else if (!nume.equals(other.nume))
			return false;
		if (prenume == null) {
			if (other.prenume != null)
				return false;
		} else if (!prenume.equals(other.prenume))
			return false;
		return true;
	}

	public boolean equalTo(Profesor pr)
	{
		if(this.nume.equals(pr.nume)==false)
		{
			return false;
		}
		else if(this.prenume.equals(pr.prenume)==false)
		{
			return false;
		}
		
		return true;
	}
	
	public void displayProfesorCourses()
	{
		if(cursuri!=null && cursuri.size()!=0)
		{
			for(Curs c:cursuri)
			{
				System.out.println(c);
			}
		}
	}
	
	public void displayProfesorCoursesStudents()
	{
		if(cursuri!=null && cursuri.size()!=0)
		{
			for(Curs c:cursuri)
			{
				System.out.println("\n"+" "+c.nume);
				c.AfisareStudenti();
			}
		}
	}
	
	public void noteazaStudentCurs(String nume,Student s,int notaStudent)
	{
		for(Curs c: cursuri)
		{
			try {
				c.noteazaStudent(s, notaStudent);
			} catch(Exception er)
			{
				System.out.println(er);
			}
			
		}
	}
	
	@Override
	public String toString() {
		return "Profesor [nume=" + nume + ", prenume=" + prenume + "]";
	}
}
