Owner will be the responsible for the relationalship where as Inverse end does not care about relatinonship. 
Quesiton is how to make inverse end resposible for relatinonship is to use of Helper method

public void addStudent(Student student) 
{
			students.add(student);
			student.setGuide(this);
}

From Database point of view,Owner is the entity that is persisted to the table that has the foreign key column i.e. For one to many association, Child table which has foreign key column
should own the responsibility of relationship.
