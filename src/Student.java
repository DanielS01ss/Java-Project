import java.util.*;
public class Student implements Comparable {
	String nume;
	String prenume;
	int grupa;
	List<Curs> cursuri;
	
	Student(String nume, String prenume, int grupa) {
		this.nume = nume;
		this.prenume = prenume;
		this.grupa = grupa;
	}
	
	Student(ArrayList<String> properties) throws Exception {
		if ( properties.size() != 3 ) {
			throw new Exception("Invalid number of properties! The student cannot be created!");
		} else {
			this.nume = properties.get(0);
			this.prenume = properties.get(1);
			this.grupa = Integer.parseInt(properties.get(2));
		}
	}
	@Override
	public String toString() {
		return "Student [nume=" + nume + ", prenume=" + prenume + ", grupa=" + grupa + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + grupa;
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
		Student other = (Student) obj;
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

	public void afiseazaCursuriInscrisi()
	{
	   for(Curs c: cursuri)
	   {
		  System.out.println(c);
	   }
	}
	
	public void afiseazaNoteCursuri()
	{
		for(Curs c: cursuri)
		{
			System.out.println("Curs:"+c.nume+" nota:"+c.getNota(this));
		}
	}
	
	public void afiseazaNoteAnUniversitar(int an_univ)
	{
		int sum = 0;
		int nr = 0;
		for(Curs c: cursuri)
		{
			
			if(c.getAnUniv() == an_univ)
			{
				nr++;
				sum+=c.getNota(this);
			}
		}
		float medie = (float)sum/nr;
		System.out.println("Media notelor din anul universitar:"+an_univ+" este:"+medie);
	}
	
	@Override
	public int compareTo(Object o) {
		Student s = (Student)o;
		return this.nume.compareTo(s.nume);
	}
}
