package org.example;

import java.util.ArrayList;
public class FormatOutput
{
    ArrayList _idAge;
    ArrayList _idSex;
    ArrayList _name;
    ArrayList _surname;
    ArrayList _lastname;
    ArrayList _age;
    ArrayList _sex;

    public FormatOutput(ArrayList idAge, ArrayList idSex, ArrayList name,ArrayList surname,ArrayList lastname,ArrayList age,ArrayList sex)
    {
        _idAge = idAge;_idSex = idSex; _name = name; _surname = surname; _lastname = lastname; _age = age; _sex = sex;
    }

    public void OutputByAge()
    {
        for (int i = 0; i < _idSex.size(); i++)
        {
            System.out.printf(_surname.get((Integer) _idAge.get(i)) + " "
                    + _name.get(i).toString().charAt(0) + " "
                    + _lastname.get((Integer) _idAge.get(i)).toString().charAt(0) + " "
                    + _age.get((Integer) _idAge.get(i)) + " ");
            System.out.println(_sex.get((Integer) _idAge.get(i)));
        }
    }

    public void OutputBySex(ArrayList sexId)
    {
        for (int i = 0; i < sexId.size(); i++)
        {
            System.out.printf(_surname.get((int) sexId.get(i)) + " "
                    + _name.get((int) sexId.get(i)).toString().charAt(0) + " "
                    + _lastname.get((int) sexId.get(i)).toString().charAt(0) + " "
                    + _age.get((int) sexId.get(i)) + " ");
                    System.out.println(_sex.get((int) sexId.get(i)));
        }
    }

    //TO DO
    public void OutputByAgeAndSex(ArrayList finalId)
    {
        for (int i = 0; i < finalId.size(); i++)
        {
            System.out.printf(_surname.get(i) + " "
                    + _name.get(i).toString().charAt(0) + " "
                    + _lastname.get(i).toString().charAt(0) + " "
                    + _age.get(i) + " ");
            System.out.println(_sex.get(i));
        }
    }
}
