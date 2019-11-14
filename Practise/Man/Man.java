abstract class Man
{
    private final String name;
    private final String surname;

    Man(String _name, String _surname)
    {
        name = new String(_name);
        surname = new String(_surname);
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public String toString()
    {
        return new String(name + " " + surname);
    }

    abstract public Man compare(Man ob);

    public double average()
    {
        return 0.0;
    }
}

class Student extends Man
{
    private int album;
    private double[] marks;

    Student(String _name, String _surname, int _album, double mark1, double mark2, double mark3)
    {
        super(_name, _surname);
        album = _album;
        marks = new double[3];
        marks[0] = mark1;
        marks[1] = mark2;
        marks[2] = mark3;
    }

    public String toString()
    {
        return super.toString() + ", id_number: " + album + ", grades: [" + marks[0] + ", " + marks[1] + ", " + marks[2] + "]"; 
    }

    public Man compare(Man obj)
    {
        if(obj instanceof Student)
        {
            if(this.average() > obj.average())
                return this;
            else
                return obj;
        }
        else
            return null;
    }

    public double average()
    {
        return (marks[0] + marks[1] + marks[2])/3.0;
    }
}

class Graduate extends Student
{
    private String title;
    private int year;
    
    Graduate(String _title, String _name, String _surname, int _album, int _year, double mark1, double mark2, double mark3)
    {
        super(_name, _surname, _album, mark1, mark2, mark3);
        title = new String(_title);
        year = _year;
    }

    public String toString()
    {
        return title + " " + super.toString() + ", year of graduation: " + year; 
    }
}

class Dean extends Man
{
    private String title;
    private int year_start;
    private int year_end;
    
    Dean(String _title, String _name, String _surname, int _year1, int _year2)
    {
        super(_name, _surname);
        title = new String(_title);
        year_start = _year1;
        year_end = _year2;
    }

    public String toString()
    {
        return title + " " + super.toString() + " Dean of the Faculty from " + year_start + " to " + year_end;
    }

    public double average()
    {
        System.out.print("  [Average not applicable]");
        return 0.0;
    }

    public Man compare(Man obj)
    {
        if(obj instanceof Dean)
        {
            if(this.year_end > ((Dean)obj).year_end)
                return this;
            else
                return obj;
        }
        else
            return null;
    }
}
